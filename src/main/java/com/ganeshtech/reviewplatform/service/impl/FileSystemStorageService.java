package com.ganeshtech.reviewplatform.service.impl;

import com.ganeshtech.reviewplatform.exception.StorageException;
import com.ganeshtech.reviewplatform.service.StorageService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@Slf4j
public class FileSystemStorageService implements StorageService {

    @Value("${app.storage.location:uploads}")
    private String storageLocation;

    private Path rootLocation;

    @PostConstruct
    public void init(){
        rootLocation= Paths.get(storageLocation);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could Not Intialize storage Location"+e);
        }
    }
    @Override
    public String store(MultipartFile file, String fileName) {
        try {
            if (file.isEmpty()) throw new StorageException("File not save due to Empty");
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String finalFileName = fileName + "." + extension;
            Path absolutePath = rootLocation
                    .resolve(Paths.get(finalFileName))
                    .normalize()
                    .toAbsolutePath();
            if (!absolutePath.getParent().equals(rootLocation.toAbsolutePath()))
                throw new StorageException("Cannot save file outside the specifiedlocation ");

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, absolutePath, StandardCopyOption.REPLACE_EXISTING);
            }
            return finalFileName;
        } catch (IOException e) {
            throw new StorageException("Could Not save file "+e);
        }
    }

    @Override
    public Optional<Resource> loadResource(String fileName) {
        try {
            Path file = rootLocation.resolve(fileName);

            UrlResource urlResource = new UrlResource(file.toUri());
            if (urlResource.exists() || urlResource.isReadable()) {
                return Optional.of(urlResource);
            } else {
                return Optional.empty();
            }
        }catch (MalformedURLException e){
            log.warn("Could not read the resource {}{}", fileName, e);
            return Optional.empty();
        }

    }

}
