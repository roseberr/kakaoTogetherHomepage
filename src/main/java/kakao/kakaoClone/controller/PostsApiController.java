package kakao.kakaoClone.controller;


import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.board.PostRepository;
import kakao.kakaoClone.domain.board.PostSaveRequestDto;
import kakao.kakaoClone.domain.board.PostUpdateRequestDto;
import kakao.kakaoClone.domain.comment.CommentDto;
import kakao.kakaoClone.domain.comment.CommentRepository;
import kakao.kakaoClone.domain.message.alarmMsg;
import kakao.kakaoClone.service.CommentService;
import kakao.kakaoClone.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@ComponentScan
@Slf4j

public class PostsApiController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final HttpSession httpSession;

    private final CommentService commentService;

    private final CommentRepository commentRepository;

    /** 등록하기 getmapping  */
    @GetMapping("/api/post")
    public String posts(Model model) {

        System.out.println("mapping start");
        model.addAttribute("requestDto", new PostSaveRequestDto());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        System.out.println("mapping end");
        System.out.println("goto post test");
        return "post/register.html";
    }

    /** 등록하기 postmapping  */
    @PostMapping("/api/posttest")
    public String save(@ModelAttribute PostSaveRequestDto requestDto, MultipartFile file) throws Exception {
        //,ModelAndView mav
        System.out.println("post start");

        if(requestDto.getBigCategory()==null){
            System.out.println("requestDto.getBigCategory():null");
        }

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            requestDto.setAuthor(user.getName());
        }
        postService.save(requestDto, file,user.getId());

        log.info("requestDto.getBigCategory : {}", requestDto.getBigCategory());

        /**
        if (requestDto.getBigCategory().equals("donationTogether")){
            mav.addObject("data", new alarmMsg("글이 등록되었습니다!", "/"));
            mav.setViewName("/message/mymessage.html");

        } else {
            mav.addObject("data", new alarmMsg("글이 등록되었습니다!", "/promotion"));
            mav.setViewName("message/mymessage.html");

        }
        return mav;


         **/
        return "index.html";

    }

    /**postform 등록하기ㅣ*/
    @GetMapping("/api/post/form")
    public String form(Model model, @RequestParam(required = false) Long post_id) {

        System.out.println("from controller getmapping start");
        if (post_id == null) {
            model.addAttribute("post", new Post());
        } else {
            Post post = postRepository.findById(post_id).orElse(null);

            /**
            Long post_userID=post.getUser().getId();
            model.addAttribute("post_")
             */
            model.addAttribute("post", post);

        }
        /** 좋아요 업데이트**/
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        boolean like = false; // 비로그인 유저라면 무조건 like = false;

        if (user != null) {

            Long user_id=user.getId();
            model.addAttribute("login_id",user_id );
            model.addAttribute("userName", user.getName());

            /**조회수 업데이트**/
            postService.updateView(post_id);


            /** 현재 로그인한 유저가 이 게시물을 좋아요 했는지 안 했는지 여부 확인 **/
            like = postService.findLike(post_id, user_id);
        }

        model.addAttribute("like", like);

        /** 댓글 DTO 반환 */
        List<CommentDto.ResponseDto> commentListDto = commentService.findAllByPost(post_id);
        model.addAttribute("commentList", commentListDto);

        System.out.println("from controller getmapping end");
        return "post/postform.html";

    }

    //수정하기 getmapping
    @GetMapping("/api/post/modify")
    public String one(Model model, @RequestParam Long post_id) {
        System.out.println("/api/post/list/{board_id} 수정하기 화면 시작");

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        if (post_id == null) {
            model.addAttribute("post", new Post());
        } else {
            Post post = postRepository.findById(post_id).orElse(null);
            model.addAttribute("post", post);
        }
        return "post/modify.html";
    }


    @PutMapping("/api/post/modify/{id}")// 수정하기
    public ModelAndView update(@ModelAttribute PostUpdateRequestDto requestDto, @PathVariable Long id, MultipartFile file, Model model,ModelAndView mav) throws Exception {
        System.out.println("update putmapping start");

        postService.update(requestDto, file, id);
        System.out.println("update putmapping end");

        if (requestDto.getBigCategory().equals("donationTogether")){
            mav.addObject("data", new alarmMsg("글이 수정되었습니다!", "/"));
            mav.setViewName("/message/mymessage.html");

        } else {
            mav.addObject("data", new alarmMsg("글이 수정되었습니다!", "/promotion"));
            mav.setViewName("message/mymessage.html");

        }
        return mav;
    }


    // 삭제하기
    @DeleteMapping("/api/post/modify/{id}")
    ModelAndView deletePost(@PathVariable Long id,ModelAndView mav) {
        System.out.println("/api/post/list/{board_id} 삭제하기 화면 시작");
        postService.deleteBoard(id);
        mav.addObject("data", new alarmMsg("글이 삭제되었습니다!", "/"));
        mav.setViewName("message/mymessage.html");

        return mav;
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