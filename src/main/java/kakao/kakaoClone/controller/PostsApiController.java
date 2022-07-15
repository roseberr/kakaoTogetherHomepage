package kakao.kakaoClone.controller;


import kakao.kakaoClone.domain.dto.PostsSaveRequestDto;
import kakao.kakaoClone.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class PostsApiController {

    private final PostsService postsService;


    @GetMapping("/api/posts")
    public String posts(){
       //model.addAttribute("",new PostsSaveRequestDto());
        return "/post/register";
    }

// post 등록하기 controller
    @PostMapping("/api/posts")
    public String save(@RequestBody PostsSaveRequestDto requestDto){
        postsService.save(new PostsSaveRequestDto());
        return "redirect:/";
    }

}
