package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Base implements Serializable {

    private static final long serialVersionUID = 6110492957663170624L;

    private String createdUser;

    private String updatedUser;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updatedDate;

    public void setUserId(String userId) {
        this.createdUser = userId;
        this.updatedUser = userId;
    }

    public void setDocumentDate() {
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    public Date getCreatedDate() {
        if (createdDate != null) {
            return (Date) createdDate.clone();
        }
        return null;
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate != null) {
            this.createdDate = (Date) createdDate.clone();
        }

    }

    public Date getUpdatedDate() {
        return (Date) updatedDate.clone();
    }

}
