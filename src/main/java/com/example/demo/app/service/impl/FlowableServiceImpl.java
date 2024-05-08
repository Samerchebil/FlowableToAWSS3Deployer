package com.example.demo.app.service.impl;

import com.example.demo.app.dto.ContentItemDto;
import com.example.demo.app.mapper.ContentItemMapper;
import com.example.demo.app.repositories.flowable.ProcessInstanceRepository;
import com.example.demo.app.service.FlowableService;
import org.flowable.content.api.ContentItem;
import org.flowable.content.api.ContentService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowableServiceImpl implements FlowableService {
    private final HistoryService historyService;
    private final ProcessInstanceRepository processInstanceRepository;

    private final ContentService contentService;

    public FlowableServiceImpl(HistoryService historyService, ProcessInstanceRepository processInstanceRepository, ContentService contentService) {
        this.historyService = historyService;
        this.processInstanceRepository = processInstanceRepository;
        this.contentService = contentService;
    }


    @Override
    public List<ContentItemDto> getContents() {
        List<ContentItem> list = new ArrayList<>();
        List<HistoricProcessInstance> processInstances = historyService.createHistoricProcessInstanceQuery().list();

        for (HistoricProcessInstance processInstance : processInstances) {
            String rootProcessInstanceId = findRootProcessInstanceId(processInstance);
            loopAllProcess(rootProcessInstanceId, list);
        }

        return setContentData(ContentItemMapper.contentItemDtos(list)).stream().filter(contentItemDto -> contentItemDto.getContentData() != null).collect(Collectors.toList());
    }

    private String findRootProcessInstanceId(HistoricProcessInstance processInstance) {
        String rootProcessInstanceId = processInstanceRepository.getRootProcessInstance(processInstance.getId());
        return (rootProcessInstanceId != null) ? rootProcessInstanceId : processInstance.getId();
    }


    private void loopAllProcess(String parentProcessId, List<ContentItem> list) {
        list.addAll(this.contentService.createContentItemQuery().processInstanceId(parentProcessId).list());

        List<HistoricProcessInstance> subProcessList = historyService.createHistoricProcessInstanceQuery()
                .superProcessInstanceId(parentProcessId)
                .list();

        for (HistoricProcessInstance subProcess : subProcessList) {
            loopAllProcess(subProcess.getId(), list);
        }
    }

    public List<ContentItemDto> setContentData(List<ContentItemDto> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        return list.stream()
                .map(contentItem -> {
                    try {
                         contentItem.setContentData(contentService.getContentItemData(contentItem.getId()));
                        return contentItem;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return contentItem;
                    }
                })
                .collect(Collectors.toList());
    }


}
