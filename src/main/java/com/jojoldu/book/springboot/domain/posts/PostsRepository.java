package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// ibatis 나 MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자.
// JPA 에서는 Repository 라고 부르며 인터페이스로 생성. JpaRepository<Entity 클래스, PK 타입>를 상속시, 기본적인 CRUD 메서드가 자동으로 생성.
// @Repository 추가 할 필요 없이, Entity 클래스와 기본 Entity Repository 는 함께 위치해야 함.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
