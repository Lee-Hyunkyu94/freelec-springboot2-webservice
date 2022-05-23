package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { // SessionUser: 인증된 사용자 정보만 필요.
    /* 왜 User 클래스를 사용하지 않는가.
    User 클래스를 사용하게 되면 Failed to convert from type [java.lang.Object] to type [byte[]] for value 'com.jojoldu.book.springboot.domain.user.User@4a43d6' 에러가 발생.
    이는 세션에 저장하기 이해 User 클래스에 세션을 저장하려니 User 클래스에 직렬화를 구현하지 않았기 때문. 해결을 위해 직렬화 코드를 넣으면?
    User 클래스는 entity 이기 때문에, 다른 엔티티와 관계가 생겼을 때 성능이슈, 부수 효과가 발생할 확률이 높다. 그래서 일반적으로 이후 운영 및 유지보수를 위해 직렬화 기능을 가진 세션 Dto 를 추가로 하나 더 만든다.
    * */
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
