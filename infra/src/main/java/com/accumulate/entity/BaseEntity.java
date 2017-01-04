package com.accumulate.entity;

import com.accumulate.utils.ObjectMapperUtil;
import org.springframework.util.FastByteArrayOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tjwang on 2017/1/3.
 */
public class BaseEntity implements Serializable {

    protected Integer id;

    protected Date createTime;

    protected String createBy;

    protected Date updateTime;

    protected String updateBy;

    @Override
    public String toString() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
