package com.example.demo.app.repositories.flowable.impl;

import com.example.demo.app.repositories.flowable.ProcessInstanceRepository;
import lombok.RequiredArgsConstructor;
import org.flowable.engine.HistoryService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProcessInstanceRepositoryImpl implements ProcessInstanceRepository {

    private final HistoryService historyService;

    @Override
    public String getRootProcessInstance(String instanceId) {

        String query = "WITH RECURSIVE ProcessHierarchy AS (" +
                "    SELECT id_, start_time_, super_process_instance_id_ FROM ACT_HI_PROCINST" +
                "    WHERE ID_ ='" + instanceId + "'" +
                "    UNION ALL" +
                "    SELECT ph1.ID_, ph1.start_time_, ph1.super_process_instance_id_" +
                "    FROM ACT_HI_PROCINST ph1" +
                "             JOIN ProcessHierarchy ph2 ON ph1.id_ = ph2.super_process_instance_id_" +
                ")" +
                "SELECT *" +
                "FROM ProcessHierarchy p where p.super_process_instance_id_ IS NULL";

        return historyService.createNativeHistoricProcessInstanceQuery().sql(query).singleResult().getId();
    }
}
