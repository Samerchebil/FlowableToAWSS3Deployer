package com.example.demo.app.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.example.demo.app.dto.ContentItemDto;
import com.example.demo.app.mapper.DocumentMapper;
import com.example.demo.app.repositories.DocumentRepository;
import com.example.demo.app.service.AmazonS3Service;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class AmazonS3ServiceImpl implements AmazonS3Service {
    private final AmazonS3 amazonS3;
    private final DocumentRepository documentRepository;


    @Value("${minio.bucketName}")
    private String bucketName;

    public AmazonS3ServiceImpl(AmazonS3 amazonS3, DocumentRepository documentRepository) {
        this.amazonS3 = amazonS3;
        this.documentRepository = documentRepository;
    }

    @Override
    @SneakyThrows
    public PutObjectResult uploadFile(String objectKey, File file) {
        return amazonS3.putObject(new PutObjectRequest(bucketName, objectKey, file));
    }

    @Override
    @SneakyThrows
    public void deleteFile(String objectKey) {
        amazonS3.deleteObject(bucketName, objectKey);
    }

    @Override
    @SneakyThrows
    public S3Object downloadFile(String objectKey) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, objectKey);
        return amazonS3.getObject(getObjectRequest);
    }

    @Override
    public void uploadContentItemFromFlowableToS3(ContentItemDto contentItemDto) {
        try {
            String objectKey = contentItemDto.getId();
            File tempFile = createTempFile(contentItemDto.getContentData());
            documentRepository.save(DocumentMapper.contentItemDtoToDocument(contentItemDto));
            PutObjectResult result = uploadFile(objectKey, tempFile);
            log.info("Uploaded {} to S3. ETag: {}", objectKey, result.getETag());
            tempFile.delete();
        } catch (IOException e) {
            log.error("Error uploading content item to S3: {}", e.getMessage());
        }
    }



    public File createTempFile(InputStream inputStream) throws IOException {
        File tempFile = File.createTempFile("temp", ".tmp");
        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        }
        return tempFile;
    }
}
