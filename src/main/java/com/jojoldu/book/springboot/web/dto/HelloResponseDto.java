package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드에 get 메서드를 생성
@RequiredArgsConstructor    // 선언된 모든 final 필드가 포함된 생성자 생성, final 이 없는 필드는 생성자가 포함되지 않음.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
