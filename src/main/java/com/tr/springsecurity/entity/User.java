package com.tr.springsecurity.entity;

import com.tr.springsecurity.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

import static org.hibernate.annotations.FetchMode.SELECT;

/**
 * @author taorun
 * @date 2023/1/30 8:56
 */
@Data
@Entity
public class User extends BaseEntity implements Serializable {

    private String username;
    private String password;

    @ManyToMany
    @Fetch(value = SELECT)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

}
