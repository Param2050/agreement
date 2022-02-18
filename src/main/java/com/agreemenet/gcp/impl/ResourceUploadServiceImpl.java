package com.agreemenet.gcp.impl;

import com.agreemenet.gcp.ResourceUploadService;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ResourceUploadServiceImpl implements ResourceUploadService {


    private final Storage storage;

    @Autowired
    public ResourceUploadServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void upload(byte[] data) {
        String fileName = "Men_jeans.jpg";
        BlobId blobId = BlobId.of("agreement_uat", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/" + ".jpg").build();
        try {
            Blob blob = storage.create(blobInfo, data);
            log.info("Uploaded url {} ", blob.getMediaLink());
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
