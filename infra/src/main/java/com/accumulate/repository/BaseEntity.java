package com.accumulate.repository;

import com.accumulate.utils.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.util.FastByteArrayOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author tjwang
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

	public abstract void validate();
	
	@Override
	public String toString() {
//		try {
//			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
//		} catch (JsonProcessingException e) {
//			return super.toString();
//		}
		return ObjectMapperUtil.writePretty(this);
	}



	public BaseEntity clone() throws CloneNotSupportedException {
		BaseEntity entity = null;
		try {
			// Write the object out to a byte array
			FastByteArrayOutputStream fbos = new FastByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(fbos);
			out.writeObject(this);
			out.flush();
			out.close();

			// Retrieve an input stream from the byte array and read
			// a copy of the object back in.
			ObjectInputStream in = new ObjectInputStream(fbos.getInputStream());

			entity = (BaseEntity) in.readObject();
		} catch (IOException e) {
			// ignore
		} catch (ClassNotFoundException cnfe) {
			// ignore
		}
		return entity;
	}
}
