package com.margenta.study.springboot.web;

import com.margenta.study.springboot.config.auth.LoginUser;
import com.margenta.study.springboot.config.auth.dto.SessionUser;
import com.margenta.study.springboot.service.PostsService;
import com.margenta.study.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession session;


    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null){
            model.addAttribute("userName" , user.getName());
            model.addAttribute("picture" , user.getPicture());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        try {

            PostsResponseDto postsResponseDto = postsService.findById(id);;
            model.addAttribute("post" , postsResponseDto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "posts-update";
    }
}
