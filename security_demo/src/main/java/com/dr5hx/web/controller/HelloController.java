package com.dr5hx.web.controller;

import com.dr5hx.web.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class HelloController {

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.userSimpleEntity.class)
    @ApiOperation("获取用户数据清单")
    public List<User> getUserList(@ApiParam("用户id") @PathVariable("id") Integer id) {
        System.out.println(id);
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);

        return users;
    }

    @GetMapping(value = "/{details:\\S+}")
    @JsonView(User.userDetailEntity.class)
    public List<User> getUserDetailsList(@PathVariable("details") String details) {
        int i = 1 / 0;
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

    @PostMapping
    @JsonView(User.userSimpleEntity.class)
    public User createUserList(@Valid @RequestBody User user, BindingResult result) {
        errorMessage(result);
        System.out.println("User.getId：" + user.getId());
        System.out.println("User.getUserName：" + user.getUserName());
        System.out.println("User.getUserPassword：" + user.getPassword());
        System.out.println("User.getDate：" + user.getDate());
        user.setId(1);
        return user;
    }

    @PutMapping("/{id:\\d+}")
//    @JsonView(User.userSimpleEntity.class)
    public User modifyUserInformation(@Valid @RequestBody User user, BindingResult bindingResult) {
        errorMessage(bindingResult);
        System.out.println("User.getId：" + user.getId());
        System.out.println("User.getUserName：" + user.getUserName());
        System.out.println("User.getUserPassword：" + user.getPassword());
        System.out.println("User.getDate：" + user.getDate());
        user.setUserName("tom2");
        return user;
    }

    private void errorMessage(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(e -> System.out.println(e.getDefaultMessage()));
        }
    }

}
