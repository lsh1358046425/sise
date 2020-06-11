package com.lucien.sise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/11 17:56
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    private String cid;
    private String cname;
}
