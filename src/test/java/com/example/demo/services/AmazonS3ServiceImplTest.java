package com.example.demo.services;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.demo.app.dto.ContentItemDto;
import com.example.demo.app.entity.Document;
import com.example.demo.app.repositories.DocumentRepository;
import com.example.demo.app.service.impl.AmazonS3ServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AmazonS3ServiceImplTest {

    @Mock
    private AmazonS3 amazonS3;

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private AmazonS3ServiceImpl amazonS3Service;


    @Test
    public void testUploadContentItemFromFlowableToS3_success2() throws IOException {
        UUID contentId = UUID.randomUUID();
        byte[] contentData = "test content".getBytes();
        InputStream contentStream = Mockito.mock(InputStream.class);
        Mockito.when(contentStream.read(Mockito.any(byte[].class))).thenReturn(contentData.length, -1);
        ContentItemDto contentItemDto = new ContentItemDto();
        contentItemDto.setId(contentId.toString());
        contentItemDto.setContentData(contentStream);
        Document document = Mockito.mock(Document.class);
        // when(DocumentMapper.contentItemDtoToDocument(contentItemDto)).thenReturn(document);

        PutObjectResult result = Mockito.mock(PutObjectResult.class);
        when(amazonS3.putObject(Mockito.any(PutObjectRequest.class))).thenReturn(result);
        amazonS3Service.uploadContentItemFromFlowableToS3(contentItemDto);
        ArgumentCaptor<PutObjectRequest> argumentCaptor = ArgumentCaptor.forClass(PutObjectRequest.class);
        Mockito.verify(amazonS3).putObject(argumentCaptor.capture());

        PutObjectRequest request = argumentCaptor.getValue();
        Assert.assertEquals(contentId.toString(), request.getKey());
        Mockito.verify(documentRepository).save(document);

    }

}