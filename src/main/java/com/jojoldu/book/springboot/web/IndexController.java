package com.jojoldu.book.springboot.web;
// 페이지와 관련된 controller 는 모두 IndexController 로 컨트롤 한다.
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;    // final 을 안붙이면 service 가 null 값으로 들어온다. 그 이유는??
                                                // findAllDesc() 메소드는 게시판 전체 글 목록을 가져오는 메소드로서 메인 화면에 출력된다.
                                                // 에러는 PostService 클래스에 정의된 findAllDesc() 메소드 값이 null 로 리턴되어 NullPointerException 이 발생했다.
                                                // @RequiredArgsConstructor
                                                // 초기화 되지않은 final 필드, @NonNull 이 붙은 필드를 매개변수로 갖는 생성자를 자동으로 생성하고, 주로 의존성 주입(DI) 편의성을 높이기 위해 사용된다.
                                                // @RequiredArgsConstructor 어노테이션 설정에 따라 생성자로 사용할 클래스 접근제어자 앞에 final 키워드를 추가하지 않아서 생성자가 만들어지지 않았고,
                                                // 따라서 호출된 메소드에 대한 필드값이 들어가지 않았기 때문에 null 값이 리턴되지 않았나 추측.

    @GetMapping("/")    // 머스테치 스타터 덕분에 컨트롤러에서 문자열 반환 시 앞의 경로와 뒤의 파일 확장자는 자동으로 지정. (앞의 경로는 src/main/resource , 뒤의 확장자는 .mustache)
    public String index(Model model) {  // model. 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장. 여기서는 postsService.findAllDesc() 로 가져온 결과를 posts 로 index.mustache 로 전달.
        try{
            System.out.println("PostService: "+postsService);
            model.addAttribute("posts", postsService.findAllDesc());
            return "index"; // model 에 posts 의 값이 안담아진다.
        }catch(NullPointerException e){
            System.out.println("값 안들어옴");
            return "posts-save";
        }
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
