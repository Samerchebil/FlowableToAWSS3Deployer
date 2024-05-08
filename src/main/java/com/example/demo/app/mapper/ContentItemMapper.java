package com.example.demo.app.mapper;

import com.example.demo.app.dto.ContentItemDto;
import com.example.demo.app.entity.ContentItemEntityImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.content.api.ContentItem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ContentItemMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ContentItemMapper() {
    }

    public static ContentItemEntityImpl toContentItem(ContentItemDto contentItemDto) {
        return (ContentItemEntityImpl) objectMapper.convertValue(contentItemDto, ContentItemEntityImpl.class);
    }

    public static ContentItemDto contentItemDto(ContentItem contentItem) {
        ContentItemDto contentItemDto = (ContentItemDto) objectMapper.convertValue(contentItem, ContentItemDto.class);
        String path = contentItem.getTaskId() == null ? "/process-instance-content/" + contentItem.getProcessInstanceId() + "/" + contentItem.getId() : "/task-content/" + contentItem.getTaskId() + "/" + contentItem.getId();
        Path targetLocation = Paths.get(path).normalize();
        contentItemDto.setGeneratedPath(targetLocation.toString() + contentItem.getMimeType());
        return contentItemDto;
    }

    public static List<ContentItemDto> contentItemDtos(List<ContentItem> contentItems) {
        return (List) contentItems.stream().map(ContentItemMapper::contentItemDto).collect(Collectors.toList());
    }

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
