package com.agreemenet.facade;


import com.agreemenet.gcp.ResourceUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileUploadFacade {


    private final ResourceUploadService resourceUploadService;

    @Autowired
    public FileUploadFacade(ResourceUploadService resourceUploadService) {
        this.resourceUploadService = resourceUploadService;
    }


    public void uploadToGcp() throws IOException {
        String filePath = "/Users/parminder.bharti/Downloads/Men_jeans.jpg";
        byte[] data = Files.readAllBytes(Paths.get(filePath));
        resourceUploadService.upload(data);
    }
}
