package com.margenta.study.springboot.web;


import com.margenta.study.springboot.service.PostsService;
import com.margenta.study.springboot.web.dto.PostsResponseDto;
import com.margenta.study.springboot.web.dto.PostsSaveRequestDto;
import com.margenta.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) throws IllegalAccessException {

        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) throws IllegalAccessException {

        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long deleteById(@PathVariable Long id) throws IllegalAccessException {

        postsService.delete(id);
        return id;
    }


}
