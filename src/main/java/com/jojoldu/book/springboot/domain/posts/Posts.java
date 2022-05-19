package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 주요 어노테이션을 클래스에 가깝게 둠, Entity 클래스에서는 절대 Setter 메서드를 만들지 않는다. 해당 클래스의 인스터스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없기 때문.
@Getter // 클래스 내의 모든 필드의 Getter 메소드를 자동으로 생성.
@NoArgsConstructor  // 기본 생성자 자동 추가, public Posts() {}와 같은 효과.
@Entity // 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭. (ex. SalesManager.java -> sales_manager table)
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PX 필드.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙. GenerationType.IDENTITY = auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타냄. 굳이 선언하지 않아도 해당 클래스의 필ㄷ는 모두 칼럼이 되지만, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용.
                                            // 문자열의 경우 VARCHAR(255)가 기본값, 사이즈를 500으로 늘리거나, 타입을 TEXT 로 변경하고 싶을 때 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
