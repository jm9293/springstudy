package com.margenta.study.springboot.service;

import com.margenta.study.springboot.domain.posts.Posts;
import com.margenta.study.springboot.domain.posts.PostsRepository;
import com.margenta.study.springboot.web.dto.PostsListResponseDto;
import com.margenta.study.springboot.web.dto.PostsResponseDto;
import com.margenta.study.springboot.web.dto.PostsSaveRequestDto;
import com.margenta.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public long update(Long id , PostsUpdateRequestDto requestDto) throws IllegalAccessException {

        Posts posts = postsRepository.findById(id).orElseThrow(() ->
            new IllegalAccessException("해당 게시글이 없습니다. id = "+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) throws IllegalAccessException {
        Posts entity =  postsRepository.findById(id).orElseThrow(
                () ->  new IllegalAccessException("해당 게시글이 없습니다. id = "+id)
        );

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) throws IllegalAccessException {
        Posts entity =  postsRepository.findById(id).orElseThrow(
                () ->  new IllegalAccessException("해당 게시글이 없습니다. id = "+id)
        );

        postsRepository.delete(entity);
    }

}
