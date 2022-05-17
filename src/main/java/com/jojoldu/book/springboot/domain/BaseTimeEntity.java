package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity 을 상속 할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다. Audit 를 이용하면 자동으로 시간을 매핑하여 데이터베이스의 테이블에 넣어주게 된다.
public class BaseTimeEntity {

    @CreatedDate    // Entity 가 생성되어 저장될 때 시간을 자동 저장한다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity 의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
