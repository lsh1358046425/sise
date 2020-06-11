package com.lucien.sise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/11 17:53
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String sid;
    private String sname;
    private String cid;
    private Integer rchinese;
    private Integer rmath;
    private Integer renglish;
}
