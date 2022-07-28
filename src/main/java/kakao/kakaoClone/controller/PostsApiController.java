package kakao.kakaoClone.controller;


import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.board.PostsRepository;
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
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequiredArgsConstructor
//@RestController
@Controller
@ComponentScan

public class PostsApiController {

    private final PostsRepository postsRepository;
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
    public String save(@ModelAttribute PostsSaveRequestDto requestDto, MultipartFile file) throws Exception {

            System.out.println("post start");


        SessionUser user=(SessionUser) httpSession.getAttribute("user");

        if (user!=null){
            requestDto.setAuthor(user.getName());
        }
        postsService.save(requestDto,file);


        System.out.println("post end");

            return "redirect:/";
    }

    @GetMapping("/api/post/form")
    public String form(Model model, @RequestParam(required = false) Long id){

        System.out.println("from controller getmapping start");
        if(id==null){
            model.addAttribute("post",new Posts());
        }else{
            Posts post=postsRepository.findById(id).orElse(null);
            model.addAttribute("post",post);

        }
        System.out.println("from controller getmapping end");
        return "post/postform.html";


    }









    @GetMapping("/api/post/list/{board_id}")
    public Posts one(@PathVariable Long board_id) {



        System.out.println("/api/post/list/{board_id} 수정하기 화면 시작");

        return postsRepository.findById(board_id).orElse(null);
    }

    @PutMapping("/api/post/list/{board_id}")// 수정하기
    public Posts replaceEmployee(@RequestBody Posts newPost, @PathVariable Long id) {

        return postsRepository.findById(id)
                .map(post -> {
                    post.setTopic(newPost.getTopic());
                    post.setBigCategory(newPost.getBigCategory());
                    post.setSmallCategory(newPost.getSmallCategory());
                    post.setTitle(newPost.getTitle());
                    post.setContent(newPost.getTitle());
                    post.setTag1(newPost.getTag1());
                    post.setTag2(newPost.getTag2());
                    post.setTag3(newPost.getTag3());
                    post.setEndDate(newPost.getEndDate());
                    post.setPriceState(newPost.getPriceState());

                    return postsRepository.save(newPost);
                })
                .orElseGet(() -> {
                    newPost.setBoard_id(id);
                    return postsRepository.save(newPost);
                });
    }
    @DeleteMapping("/api/post/list/{board_id}")// 삭제하기
    void deletePost(@PathVariable Long board_id){
        postsRepository.deleteById(board_id);

    }

}
/*
String topic, String bigCategory , String smallCategory, String title,
                 String content, String author,  String tag1, String tag2, String tag3,
                 String endDate, Long priceState,

 */