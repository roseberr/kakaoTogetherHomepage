package kakao.kakaoClone.controller;


import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.board.PostsSaveRequestDto;
import kakao.kakaoClone.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.h2.api.Aggregate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
//@RestController
@Controller
@ComponentScan

public class PostsApiController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/api/post")
    public String posts(Model model) {

         System.out.println("mapping start");
        model.addAttribute("requestDto",new PostsSaveRequestDto());
        SessionUser user=(SessionUser) httpSession.getAttribute("user");

        if (user!=null){
            model.addAttribute("userName",user.getName());
        }

        System.out.println("mapping end");
        return "register.html";
    }

// post 등록하기 controller
/*
    @PostMapping("/api/post")
    public ResponseEntity<?> save(@Validated @ModelAttribute PostsSaveRequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            System.out.println("post start");
            final List<String> errors=new ArrayList<>();

            errors.add(bindingResult.toString());
            for (final FieldError error :bindingResult.getFieldErrors()){
             errors.add(error.getField()+":"+error.getDefaultMessage()) ;
             return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }

            postsService.save(requestDto);

            System.out.println("post end");
            //return "/post/register";
        }

        return new ResponseEntity<>(requestDto,HttpStatus.CREATED);
    }*/

    @PostMapping("/api/post")
    public String save(@ModelAttribute PostsSaveRequestDto requestDto) {

            System.out.println("post start");

            postsService.save(requestDto);

            System.out.println("post end");

            return "redirect:/";
    }
}