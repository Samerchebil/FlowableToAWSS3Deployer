package com.example.demo.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Document {
    @Id
    private UUID id;
    private String taskId;
    private String name;
    private String processInstanceId;
    private String contentStoreId;
    private String contentStoreName;
    private String field;
    private Long contentSize;
    private Date created;
    private String createdBy;
    private Date lastModified;
    private String lastModifiedBy;

}
