package com.allsser.book.springboot.service.posts;

import com.allsser.book.springboot.domain.posts.Posts;
import com.allsser.book.springboot.domain.posts.PostsRepository;
import com.allsser.book.springboot.web.dto.PostsResponseDto;
import com.allsser.book.springboot.web.dto.PostsSaveRequesrDto;
import com.allsser.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequesrDto requesrDto) {
        return postsRepository.save(requesrDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }
}
