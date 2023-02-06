package com.tr.springsecurity.entity;

import com.tr.springsecurity.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author taorun
 * @date 2023/1/30 8:56
 */
@Data
@Entity
public class Role extends BaseEntity {

    private String roleName;
    private String description;

}
