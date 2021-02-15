package com.margenta.study.springboot.web;

import com.margenta.study.springboot.domain.posts.Posts;
import com.margenta.study.springboot.domain.posts.PostsRepository;
import com.margenta.study.springboot.web.dto.PostsSaveRequestDto;
import com.margenta.study.springboot.web.dto.PostsUpdateRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void indexLoading(){

        String body =  restTemplate.getForObject("/" , String.class);

        assertThat(body).contains("스프링 공부용 웹서비스");

    }


}
