package com.example.demo.app.service;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.example.demo.app.dto.ContentItemDto;

import java.io.File;

public interface AmazonS3Service {
    PutObjectResult uploadFile(String objectKey, File file);

    void uploadContentItemFromFlowableToS3(ContentItemDto contentItemDto);

    void deleteFile(String objectKey);

    S3Object downloadFile(String objectKey);

}
