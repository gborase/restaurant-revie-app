package com.ganeshtech.reviewplatform.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public interface StorageService {

    String store(MultipartFile file,String fileName);
    Optional<Resource> loadResource(String id);

}
