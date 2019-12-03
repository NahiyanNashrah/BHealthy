package com.doctormanagement.service;


import org.springframework.web.multipart.MultipartFile;



public interface StorageServiceInterface {

    void init();

    String store(MultipartFile file);

}