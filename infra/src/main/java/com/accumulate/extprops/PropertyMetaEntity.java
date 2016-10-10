package com.accumulate.extprops;

import com.accumulate.entity.BaseEntity;
import com.accumulate.meta.DataType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 扩展属性
 */
@Document
public class PropertyMetaEntity extends BaseEntity {
    /**
     * 所属，如USER,PRODUCT,ORDER
     */
    private String namespace;
    /**
     * 属性名
     */
    private String name;
    /**
     * 数据类型
     */
    private DataType type;
    /**
     * 描述
     */
    private String description;
    /**
     * 排序
     */
    private int order;
    /**
     * 是否被删除
     */
    private boolean deleted;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public void validate() {

    }

}
