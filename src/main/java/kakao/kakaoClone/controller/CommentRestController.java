package kakao.kakaoClone.controller;

import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.comment.CommentDto;
import kakao.kakaoClone.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/form/post")
@Slf4j

public class CommentRestController {

    private final CommentService commentService;

    private final HttpSession httpSession;
    /** 댓글 작성 **/
    @PostMapping("/{post_id}/comment")
    public ResponseEntity save(@PathVariable Long post_id,
                               @RequestBody CommentDto.RequestDto requestDto
                            ) {


        SessionUser user= (SessionUser) httpSession.getAttribute("user");
        commentService.save(post_id, user.getId(), requestDto);

        log.info("댓글 생성 완료");

        return new ResponseEntity(HttpStatus.OK);
    }

    /** 댓글 조회 **/
    @GetMapping("/{post_id}/comment")
    public List<CommentDto.ResponseDto> read(@PathVariable Long post_id) {

        return commentService.findAllByPost(post_id);
    }

    /** 댓글 수정 **/
    @PutMapping("/{post_id}/comment/{comment_id}")
    public ResponseEntity update(@PathVariable("comment_id") Long comment_id,
                                 @RequestBody CommentDto.RequestDto requestDto) {

        commentService.update(comment_id, requestDto);

        log.info("댓글 수정 완료");
        return new ResponseEntity(HttpStatus.OK);
    }

    /** 댓글 삭제 **/
    @DeleteMapping("/{post_id}/comment/{comment_id}")
    public ResponseEntity delete(@PathVariable("comment_id") Long comment_id){

        commentService.delete(comment_id);

        log.info("댓글 삭제 완료");
        return new ResponseEntity(HttpStatus.OK);
    }
}