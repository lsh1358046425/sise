package com.lucien.sise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 18:09
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Person {
    private Integer personId;
    private String personName;
    private Integer personAge;
    private String message;
}
