package kakao.kakaoClone.controller;


import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.board.PostsSaveRequestDto;
import kakao.kakaoClone.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
//@RestController
@Controller

public class PostsApiController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/api/post")
    public String posts(Model model){


        model.addAttribute("requestDto",new PostsSaveRequestDto());
        //SessionUser user=(SessionUser) httpSession.getAttribute("user");

        //if (user!=null){
        //    model.addAttribute("userName",user.getName());
        //}

        return "/post/register";
    }

// post 등록하기 controller

    @PostMapping("/api/post")
    public String save(@ModelAttribute  PostsSaveRequestDto requestDto){

        postsService.save(requestDto);
        return "/post/register";
    }

}
