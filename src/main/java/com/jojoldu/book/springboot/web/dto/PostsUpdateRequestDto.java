package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {    // update 기능에서 데이터베이스에 쿼리를 날리는 부분이 없다. JPA 의 영속성 컨텍스트 때문.
                                        // 영속성 컨텍스트 란? 엔티티를 영구적으로 저장하는 환경.
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
