package com.example.demo.app.dto;

import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;


public class ContentItemDto implements Serializable {

    private String id;
    private String name;
    @JsonIgnore // Alternatively use @Ignored from
    private String mimeType;
    private String taskId;
    private String processInstanceId;
    private String scopeId;
    private String scopeType;
    private String contentStoreId;
    private String contentStoreName;
    private boolean contentAvailable;
    private String field;
    private Long contentSize;
    private Date created;
    private String createdBy;
    private Date lastModified;
    private String lastModifiedBy;
    private String tenantId = "";
    private boolean provisional;
    private String generatedPath;
    @JsonIgnore
    private transient InputStream contentData;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public String getScopeId() {
        return this.scopeId;
    }

    public String getScopeType() {
        return this.scopeType;
    }

    public String getContentStoreId() {
        return this.contentStoreId;
    }

    public String getContentStoreName() {
        return this.contentStoreName;
    }

    public boolean isContentAvailable() {
        return this.contentAvailable;
    }

    public String getField() {
        return this.field;
    }

    public Long getContentSize() {
        return this.contentSize;
    }

    public Date getCreated() {
        return this.created;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public boolean isProvisional() {
        return this.provisional;
    }

    public String getGeneratedPath() {
        return this.generatedPath;
    }

    public InputStream getContentData() {
        return this.contentData;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMimeType(final String mimeType) {
        this.mimeType = mimeType;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    public void setProcessInstanceId(final String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setScopeId(final String scopeId) {
        this.scopeId = scopeId;
    }

    public void setScopeType(final String scopeType) {
        this.scopeType = scopeType;
    }

    public void setContentStoreId(final String contentStoreId) {
        this.contentStoreId = contentStoreId;
    }

    public void setContentStoreName(final String contentStoreName) {
        this.contentStoreName = contentStoreName;
    }

    public void setContentAvailable(final boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public void setField(final String field) {
        this.field = field;
    }

    public void setContentSize(final Long contentSize) {
        this.contentSize = contentSize;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModified(final Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }

    public void setProvisional(final boolean provisional) {
        this.provisional = provisional;
    }

    public void setGeneratedPath(final String generatedPath) {
        this.generatedPath = generatedPath;
    }

    public void setContentData(final InputStream contentData) {
        this.contentData = contentData;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ContentItemDto)) {
            return false;
        } else {
            ContentItemDto other = (ContentItemDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isContentAvailable() != other.isContentAvailable()) {
                return false;
            } else if (this.isProvisional() != other.isProvisional()) {
                return false;
            } else {
                label220:
                {
                    Object this$contentSize = this.getContentSize();
                    Object other$contentSize = other.getContentSize();
                    if (this$contentSize == null) {
                        if (other$contentSize == null) {
                            break label220;
                        }
                    } else if (this$contentSize.equals(other$contentSize)) {
                        break label220;
                    }

                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                label206:
                {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label206;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label206;
                    }

                    return false;
                }

                label199:
                {
                    Object this$mimeType = this.getMimeType();
                    Object other$mimeType = other.getMimeType();
                    if (this$mimeType == null) {
                        if (other$mimeType == null) {
                            break label199;
                        }
                    } else if (this$mimeType.equals(other$mimeType)) {
                        break label199;
                    }

                    return false;
                }

                Object this$taskId = this.getTaskId();
                Object other$taskId = other.getTaskId();
                if (this$taskId == null) {
                    if (other$taskId != null) {
                        return false;
                    }
                } else if (!this$taskId.equals(other$taskId)) {
                    return false;
                }

                label185:
                {
                    Object this$processInstanceId = this.getProcessInstanceId();
                    Object other$processInstanceId = other.getProcessInstanceId();
                    if (this$processInstanceId == null) {
                        if (other$processInstanceId == null) {
                            break label185;
                        }
                    } else if (this$processInstanceId.equals(other$processInstanceId)) {
                        break label185;
                    }

                    return false;
                }

                label178:
                {
                    Object this$scopeId = this.getScopeId();
                    Object other$scopeId = other.getScopeId();
                    if (this$scopeId == null) {
                        if (other$scopeId == null) {
                            break label178;
                        }
                    } else if (this$scopeId.equals(other$scopeId)) {
                        break label178;
                    }

                    return false;
                }

                Object this$scopeType = this.getScopeType();
                Object other$scopeType = other.getScopeType();
                if (this$scopeType == null) {
                    if (other$scopeType != null) {
                        return false;
                    }
                } else if (!this$scopeType.equals(other$scopeType)) {
                    return false;
                }

                Object this$contentStoreId = this.getContentStoreId();
                Object other$contentStoreId = other.getContentStoreId();
                if (this$contentStoreId == null) {
                    if (other$contentStoreId != null) {
                        return false;
                    }
                } else if (!this$contentStoreId.equals(other$contentStoreId)) {
                    return false;
                }

                label157:
                {
                    Object this$contentStoreName = this.getContentStoreName();
                    Object other$contentStoreName = other.getContentStoreName();
                    if (this$contentStoreName == null) {
                        if (other$contentStoreName == null) {
                            break label157;
                        }
                    } else if (this$contentStoreName.equals(other$contentStoreName)) {
                        break label157;
                    }

                    return false;
                }

                label150:
                {
                    Object this$field = this.getField();
                    Object other$field = other.getField();
                    if (this$field == null) {
                        if (other$field == null) {
                            break label150;
                        }
                    } else if (this$field.equals(other$field)) {
                        break label150;
                    }

                    return false;
                }

                Object this$created = this.getCreated();
                Object other$created = other.getCreated();
                if (this$created == null) {
                    if (other$created != null) {
                        return false;
                    }
                } else if (!this$created.equals(other$created)) {
                    return false;
                }

                label136:
                {
                    Object this$createdBy = this.getCreatedBy();
                    Object other$createdBy = other.getCreatedBy();
                    if (this$createdBy == null) {
                        if (other$createdBy == null) {
                            break label136;
                        }
                    } else if (this$createdBy.equals(other$createdBy)) {
                        break label136;
                    }

                    return false;
                }

                Object this$lastModified = this.getLastModified();
                Object other$lastModified = other.getLastModified();
                if (this$lastModified == null) {
                    if (other$lastModified != null) {
                        return false;
                    }
                } else if (!this$lastModified.equals(other$lastModified)) {
                    return false;
                }

                label122:
                {
                    Object this$lastModifiedBy = this.getLastModifiedBy();
                    Object other$lastModifiedBy = other.getLastModifiedBy();
                    if (this$lastModifiedBy == null) {
                        if (other$lastModifiedBy == null) {
                            break label122;
                        }
                    } else if (this$lastModifiedBy.equals(other$lastModifiedBy)) {
                        break label122;
                    }

                    return false;
                }

                Object this$tenantId = this.getTenantId();
                Object other$tenantId = other.getTenantId();
                if (this$tenantId == null) {
                    if (other$tenantId != null) {
                        return false;
                    }
                } else if (!this$tenantId.equals(other$tenantId)) {
                    return false;
                }

                Object this$generatedPath = this.getGeneratedPath();
                Object other$generatedPath = other.getGeneratedPath();
                if (this$generatedPath == null) {
                    if (other$generatedPath == null) {
                        return true;
                    }
                } else if (this$generatedPath.equals(other$generatedPath)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ContentItemDto;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isContentAvailable() ? 79 : 97);
        result = result * 59 + (this.isProvisional() ? 79 : 97);
        Object $contentSize = this.getContentSize();
        result = result * 59 + ($contentSize == null ? 43 : $contentSize.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $mimeType = this.getMimeType();
        result = result * 59 + ($mimeType == null ? 43 : $mimeType.hashCode());
        Object $taskId = this.getTaskId();
        result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
        Object $processInstanceId = this.getProcessInstanceId();
        result = result * 59 + ($processInstanceId == null ? 43 : $processInstanceId.hashCode());
        Object $scopeId = this.getScopeId();
        result = result * 59 + ($scopeId == null ? 43 : $scopeId.hashCode());
        Object $scopeType = this.getScopeType();
        result = result * 59 + ($scopeType == null ? 43 : $scopeType.hashCode());
        Object $contentStoreId = this.getContentStoreId();
        result = result * 59 + ($contentStoreId == null ? 43 : $contentStoreId.hashCode());
        Object $contentStoreName = this.getContentStoreName();
        result = result * 59 + ($contentStoreName == null ? 43 : $contentStoreName.hashCode());
        Object $field = this.getField();
        result = result * 59 + ($field == null ? 43 : $field.hashCode());
        Object $created = this.getCreated();
        result = result * 59 + ($created == null ? 43 : $created.hashCode());
        Object $createdBy = this.getCreatedBy();
        result = result * 59 + ($createdBy == null ? 43 : $createdBy.hashCode());
        Object $lastModified = this.getLastModified();
        result = result * 59 + ($lastModified == null ? 43 : $lastModified.hashCode());
        Object $lastModifiedBy = this.getLastModifiedBy();
        result = result * 59 + ($lastModifiedBy == null ? 43 : $lastModifiedBy.hashCode());
        Object $tenantId = this.getTenantId();
        result = result * 59 + ($tenantId == null ? 43 : $tenantId.hashCode());
        Object $generatedPath = this.getGeneratedPath();
        result = result * 59 + ($generatedPath == null ? 43 : $generatedPath.hashCode());
        return result;
    }

    public String toString() {
        return "ContentItemDto(id=" + this.getId() + ", name=" + this.getName() + ", mimeType=" + this.getMimeType() + ", taskId=" + this.getTaskId() + ", processInstanceId=" + this.getProcessInstanceId() + ", scopeId=" + this.getScopeId() + ", scopeType=" + this.getScopeType() + ", contentStoreId=" + this.getContentStoreId() + ", contentStoreName=" + this.getContentStoreName() + ", contentAvailable=" + this.isContentAvailable() + ", field=" + this.getField() + ", contentSize=" + this.getContentSize() + ", created=" + this.getCreated() + ", createdBy=" + this.getCreatedBy() + ", lastModified=" + this.getLastModified() + ", lastModifiedBy=" + this.getLastModifiedBy() + ", tenantId=" + this.getTenantId() + ", provisional=" + this.isProvisional() + ", generatedPath=" + this.getGeneratedPath() + ", contentData=" + this.getContentData() + ")";
    }

    public ContentItemDto() {
    }

}
