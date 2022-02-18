package com.agreemenet.gcp;

import org.springframework.web.multipart.MultipartFile;

public interface ResourceUploadService {
    void upload(byte data[]);
}
