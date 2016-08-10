package com.accumulate.entity;

import com.accumulate.utils.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author ryvius 
 * 基础实体类
 */
public abstract class BaseEntity implements Serializable, Persistable<String>, Cloneable {

	private static final long serialVersionUID = -7166979186411587807L;

	@Id
	private String id;

	@Version
	private Long version;

	@CreatedDate
	private DateTime createdDate = new DateTime();

	@LastModifiedDate
	private DateTime lastModifiedDate = new DateTime();

	public String getId() {
		return id;
	}

	public boolean isNew() {
		return null == this.getId();
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@Override
	public String toString() {
		try {
			return ObjectMapperUtil.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return super.toString();
		}
	}

	public BaseEntity clone() throws CloneNotSupportedException {
		BaseEntity entity = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			mapper.writeValue(baos, this);
			entity = mapper.readValue(baos.toByteArray(), this.getClass());
		} catch (IOException e) {
			// ignore
		}
		return entity;
	}
}
