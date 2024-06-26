package com.example.demo.app.entity;

import org.flowable.content.engine.impl.persistence.entity.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ContentItemEntityImpl extends AbstractContentEngineNoRevisionEntity implements ContentItemEntity, Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected String mimeType;
    protected String taskId;
    protected String processInstanceId;
    protected String scopeId;
    protected String scopeType;
    protected String contentStoreId;
    protected String contentStoreName;
    protected boolean contentAvailable;
    protected String field;
    protected Long contentSize;
    protected Date created;
    protected String createdBy;
    protected Date lastModified;
    protected String lastModifiedBy;
    protected String tenantId = "";
    protected boolean provisional;

    public ContentItemEntityImpl() {
    }

    public Object getPersistentState() {
        Map<String, Object> persistentState = new HashMap();
        persistentState.put("name", this.name);
        persistentState.put("mimeType", this.mimeType);
        persistentState.put("taskId", this.taskId);
        persistentState.put("processInstanceId", this.processInstanceId);
        persistentState.put("contentStoreId", this.contentStoreId);
        persistentState.put("contentStoreName", this.contentStoreName);
        persistentState.put("contentAvailable", this.contentAvailable);
        persistentState.put("field", this.field);
        persistentState.put("contentSize", this.contentSize);
        persistentState.put("created", this.created);
        persistentState.put("createdBy", this.createdBy);
        persistentState.put("lastModified", this.lastModified);
        persistentState.put("lastModifiedBy", this.lastModifiedBy);
        persistentState.put("tenantId", this.tenantId);
        persistentState.put("scopeId", this.scopeId);
        persistentState.put("scopeType", this.scopeType);
        return persistentState;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getContentStoreId() {
        return this.contentStoreId;
    }

    public void setContentStoreId(String contentStoreId) {
        this.contentStoreId = contentStoreId;
    }

    public String getContentStoreName() {
        return this.contentStoreName;
    }

    public void setContentStoreName(String contentStoreName) {
        this.contentStoreName = contentStoreName;
    }

    public boolean isContentAvailable() {
        return this.contentAvailable;
    }

    public void setContentAvailable(boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getContentSize() {
        return this.contentSize;
    }

    public void setContentSize(Long contentSize) {
        this.contentSize = contentSize;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getScopeType() {
        return this.scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public boolean isProvisional() {
        return this.provisional;
    }

    public void setProvisional(boolean provisional) {
        this.provisional = provisional;
    }

    public String toString() {
        return "ContentItemEntity[" + this.id + "]";
    }
}
