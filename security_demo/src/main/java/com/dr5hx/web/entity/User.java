package com.dr5hx.web.entity;

import com.dr5hx.web.annotation.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

public class User {
    public interface userSimpleEntity {
    }

    public interface userDetailEntity extends userSimpleEntity {
    }

    @JsonView(userSimpleEntity.class)
    @ApiModelProperty("用户id")
    private Integer id;
    @MyConstraint(message = "china no 1")
    @JsonView(userSimpleEntity.class)
    @ApiModelProperty("用户名")
    private String userName;
    @JsonView(userDetailEntity.class)
    @NotBlank
    private String password;
    //    @JsonIgnore
    //人生就是如此随性
    @Past
    public Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
