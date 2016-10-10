package com.accumulate.extprops;

import com.accumulate.entity.BaseEntity;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * 实体扩展属性值
 */
@Document
public class ExtraPropertyEntity extends BaseEntity {
	
	private static final long serialVersionUID = -1009419787066475971L;

	/**
	 * 所属，如USER,PRODUCT,ORDER
	 */
	private String namespace;

	/**
	 * 实体ID，比如用户ID，商品ID等
	 */
	private String masterId;

	/**
	 * key为PropertyMetaEntity的ID，value为值
	 */
	private Map<String, Object> values;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	@Override
	public void validate() {

	}
}
