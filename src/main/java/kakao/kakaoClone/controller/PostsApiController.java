package kakao.kakaoClone.controller;


import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.board.PostsRepository;
import kakao.kakaoClone.domain.board.PostsSaveRequestDto;
import kakao.kakaoClone.domain.board.PostsUpdateRequestDto;
import kakao.kakaoClone.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Session;
import org.h2.util.IOUtils;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

@RequiredArgsConstructor
@Controller
@ComponentScan

public class PostsApiController {

    private final PostsRepository postsRepository;
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/api/post")
    public String posts(Model model) {

        System.out.println("mapping start");
        model.addAttribute("requestDto", new PostsSaveRequestDto());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        System.out.println("mapping end");
        return "post/register.html";
    }

    @PostMapping("/api/post")
    public String save(@ModelAttribute PostsSaveRequestDto requestDto, MultipartFile file) throws Exception {

        System.out.println("post start");


        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            requestDto.setAuthor(user.getName());
        }
        postsService.save(requestDto, file);


        System.out.println("post end");

        return "redirect:/";
    }

    @GetMapping("/api/post/form")
    public String form(Model model, @RequestParam(required = false) Long id) {

        System.out.println("from controller getmapping start");
        if (id == null) {
            model.addAttribute("post", new Posts());
        } else {
            Posts post = postsRepository.findById(id).orElse(null);
            model.addAttribute("post", post);

        }
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        System.out.println("from controller getmapping end");
        return "post/postform.html";


    }


    //수정하기 getmapping
    @GetMapping("/api/post/modify")
    public String one(Model model, @RequestParam Long id) {
        System.out.println("/api/post/list/{board_id} 수정하기 화면 시작");

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        if (id == null) {
            model.addAttribute("post", new Posts());
        } else {
            Posts post = postsRepository.findById(id).orElse(null);
            model.addAttribute("post", post);
        }
        return "post/modify.html";
    }


    @PutMapping("/api/post/modify/{id}")// 수정하기
    public String update(@ModelAttribute PostsUpdateRequestDto requestDto, @PathVariable Long id, MultipartFile file,Model model) throws Exception {
        System.out.println("update putmapping start");
        postsService.update(requestDto, file, id);
        System.out.println("update putmapping end");

        return "redirect:/";
    }


    // 삭제하기
    @DeleteMapping("/api/post/modify/{id}")
    String deletePost(@PathVariable Long id) {
        System.out.println("/api/post/list/{board_id} 삭제하기 화면 시작");
        postsService.deleteBoard(id);
        return "redirect:/";
    }

    // feed image 반환하기
    @ResponseBody
    @GetMapping("/{filepath}")
    public Resource showImage(@PathVariable String filepath) throws
            MalformedURLException {
        return new UrlResource("file:" + filepath);
    }

}
/*
String topic, String bigCategory , String smallCategory, String title,
                 String content, String author,  String tag1, String tag2, String tag3,
                 String endDate, Long priceState,

 */