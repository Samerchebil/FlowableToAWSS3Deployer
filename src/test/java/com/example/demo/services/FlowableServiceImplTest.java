package com.example.demo.services;

import com.example.demo.app.dto.ContentItemDto;
import com.example.demo.app.repositories.flowable.ProcessInstanceRepository;
import com.example.demo.app.service.impl.FlowableServiceImpl;
import org.flowable.content.api.ContentItem;
import org.flowable.content.api.ContentService;
import org.flowable.content.engine.impl.ContentItemQueryImpl;
import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.HistoricProcessInstanceQueryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class FlowableServiceImplTest {
    @Mock
    private HistoryService historyService;

    @Mock
    private ProcessInstanceRepository processInstanceRepository;

    @Mock
    private ContentService contentService;

    @InjectMocks
    private FlowableServiceImpl flowableService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetContents() {

        List<HistoricProcessInstance> processInstances = new ArrayList<>();
        HistoricProcessInstance processInstance1 = mock(HistoricProcessInstance.class);
        HistoricProcessInstance processInstance2 = mock(HistoricProcessInstance.class);
        processInstances.add(processInstance1);
        processInstances.add(processInstance2);

        List<ContentItem> contentItems = new ArrayList<>();
        ContentItem contentItem1 = mock(ContentItem.class);
        ContentItem contentItem2 = mock(ContentItem.class);
        contentItems.add(contentItem1);
        contentItems.add(contentItem2);

        HistoricProcessInstanceQueryImpl processInstanceQueryMock = mock(HistoricProcessInstanceQueryImpl.class);
        when(historyService.createHistoricProcessInstanceQuery()).thenReturn(processInstanceQueryMock);
        when(processInstanceQueryMock.list()).thenReturn(processInstances);

        when(processInstanceRepository.getRootProcessInstance(anyString())).thenReturn("4cf0e5a6-bc52-11ee-8856-e0c2647eafb9");


        ContentItemQueryImpl contentItemQueryMock = mock(ContentItemQueryImpl.class);
        when(contentService.createContentItemQuery()).thenReturn(contentItemQueryMock);
        when(contentItemQueryMock.processInstanceId(anyString())).thenReturn(contentItemQueryMock);
        when(contentItemQueryMock.list()).thenReturn(contentItems);

        when(processInstanceRepository.getRootProcessInstance(anyString())).thenReturn("4cf0e5a6-bc52-11ee-8856-e0c2647eafb9");

        List<ContentItemDto> result = flowableService.getContents();

        verify(historyService, times(1)).createHistoricProcessInstanceQuery().list();
        verify(processInstanceRepository, times(2)).getRootProcessInstance(anyString());
        verify(contentService, times(2)).createContentItemQuery().processInstanceId(anyString()).list();
        Assertions.assertEquals(1, result.size());
        result.forEach(val -> {
            Assertions.assertNotNull(val.getContentData());
        });
    }

}
