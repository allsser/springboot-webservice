package com.allsser.book.springboot.web.dto;

import com.allsser.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@NoArgsConstructor
public class PostsSaveRequesrDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequesrDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
