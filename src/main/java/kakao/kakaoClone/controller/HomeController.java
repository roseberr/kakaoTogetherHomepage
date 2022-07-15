package kakao.kakaoClone.controller;

import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.board.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

@RequiredArgsConstructor

public class HomeController {

    private final HttpSession httpSession;

    private final PostsRepository postsRepository;
    @GetMapping("/")
    public String index(Model model){
        SessionUser user=(SessionUser) httpSession.getAttribute("user");
        if (user!=null){
            model.addAttribute("userName",user.getName());
        }

        List<Posts> posts= postsRepository.findAll();
        if(posts!=null){
        model.addAttribute("posts",posts);
        }
        return "index.html";
    }

}
