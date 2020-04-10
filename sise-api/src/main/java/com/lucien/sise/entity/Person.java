package com.lucien.sise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 18:09
 */

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
@XmlRootElement
public class Person {
    @XmlElement
    private Integer personId;
    @XmlElement
    private String personName;
    @XmlElement
    private Integer personAge;
    @XmlElement
    private String message;

    @XmlTransient
    public Integer getPersonId() {
        return personId;
    }

    @XmlTransient
    public String getPersonName() {
        return personName;
    }

    @XmlTransient
    public Integer getPersonAge() {
        return personAge;
    }

    @XmlTransient
    public String getMessage() {
        return message;
    }
}
