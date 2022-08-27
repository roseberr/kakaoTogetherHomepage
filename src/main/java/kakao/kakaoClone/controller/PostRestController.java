package kakao.kakaoClone.controller;


import groovy.util.logging.Slf4j;
import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/form/post")
@Slf4j
public class PostRestController {

    private final PostService postService;


    /** 글 좋아요 **/
    @PostMapping("/like/{post_id}")
    public boolean like(@PathVariable Long post_id, @AuthenticationPrincipal SessionUser user){

        Long user_id = user.getId();

        // 좋아요하지 않은 게시물이라 좋아요 헀다면 true, 좋아요 한 게시물이라 삭제했다면 false
        return postService.saveLike(post_id, user_id);
    }



}
