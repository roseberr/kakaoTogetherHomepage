package environment.environmentHomepage.controller;


import environment.environmentHomepage.domain.board.Posts;
import environment.environmentHomepage.domain.dto.PostsSaveRequestDto;
import environment.environmentHomepage.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class PostsApiController {

    private final PostsService postsService;


    @GetMapping("/api/posts")
    public String posts(Model model){
        model.addAttribute("",new PostsSaveRequestDto());
        return "/post/register";
    }

// post 등록하기 controller
    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

}
