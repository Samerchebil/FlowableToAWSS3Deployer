package com.example.demo.app.mapper;

import com.example.demo.app.dto.ContentItemDto;
import com.example.demo.app.entity.Document;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.content.api.ContentItem;

public class DocumentMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;

    public static Document contentItemDtoToDocument(ContentItemDto contentItemDto) {
        return (Document) objectMapper.convertValue(contentItemDto, Document.class);

    }
}
