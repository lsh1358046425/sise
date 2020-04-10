package com.lucien.sise.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/10 20:40
 */

@Data
@XmlRootElement
public class Result {
    @XmlElement
    private String message;

    @XmlTransient
    public void setMessage(String message) {
        this.message = message;
    }
}
