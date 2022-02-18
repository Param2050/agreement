package com.agreemenet.controller;


import com.agreemenet.facade.FileUploadFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1/files")
public class FileUploadController {

    private final FileUploadFacade fileUploadFacade;


    @Autowired
    public FileUploadController(FileUploadFacade fileUploadFacade) {
        this.fileUploadFacade = fileUploadFacade;
    }

    @PostMapping("/upload_to_gcp")
    public ResponseEntity uploadToCloud() throws IOException {
        fileUploadFacade.uploadToGcp();
        return ResponseEntity.ok("Image uploaded to gcp !!!!!!!!");
    }
}
