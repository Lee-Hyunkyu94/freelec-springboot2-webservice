package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어 준다.(@ResponseBody)
public class HelloController {

    @GetMapping("/hello")   // Http Method 인 Get 의 요청을 받을 수 있는 API 를 만들어 준다.(@RequestMapping(method = RequestMethod.GET))
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // @RequestParam 은 외부에서 API 로 넘긴 파라미터를 가져오는 어노테이션.
                                                                        // 여기서는 외부에서 name(@RequestParam("name")이란 이름으로 넘긴 파라미터를 메서드 파라미터 name(String name) 에 저장.
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
