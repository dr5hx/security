package com.dr5hx.web.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        System.out.println("wac:" + wac);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void stop() {
        System.out.println("finish");
        mockMvc = null;
        wac = null;
    }

    @Test
    public void testHelloURL() throws Exception {
        String result = mockMvc.perform(get("/hello").
                contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().
                        isOk()).
                andReturn().
                getResponse().
                getContentAsString();
        System.out.println(result);
    }

    /**
     * 测试用户简单数据
     *
     * @throws Exception
     */
    @Test
    public void testUserList() throws Exception {
        String contentAsString = mockMvc.perform(
                get("/user/111").
                        contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().
                        isOk()).
                andReturn().
                getResponse().
                getContentAsString();
        System.out.println(contentAsString);
    }

    /**
     * 测试用户详情数据
     *
     * @throws Exception
     */
    @Test
    public void testUserListDetails() throws Exception {
        String contentAsString = mockMvc.perform(get("/user/asdsad").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().
                        isOk()).
                andReturn().
                getResponse().
                getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void createUser() throws Exception {
        Date date = new Date();
        String content = "{\"userName\":\"tom\",\"password\":null,\"date\": " + date.getTime() + "}";
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.
                post("/user").
                contentType(MediaType.APPLICATION_JSON_UTF8).
                content(content)).
                andExpect(status().isOk()).
                andReturn().
                getResponse().
                getContentAsString();
        System.out.println(contentAsString);

    }

    @Test
    public void modifyUser() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        String content = "{ \"id\":1, \"userName\":\"tom\",\"password\":null,\"date\": " + date.getTime() + "}";
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.
                put("/user/1").
                contentType(MediaType.APPLICATION_JSON_UTF8).
                content(content)).
                andExpect(status().isOk()).
                andReturn().
                getResponse().
                getContentAsString();
        System.out.println(contentAsString);

    }
    @Test
    public void upload() throws Exception {
        String contentAsString = mockMvc.perform(
                fileUpload("/file").file(
                        new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes("UTF-8")
                        ))).
                andExpect(status().isOk()).
                andReturn().
                getResponse().
                getContentAsString();
        System.out.println(contentAsString);

    }
}
