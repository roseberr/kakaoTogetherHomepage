package kakao.kakaoClone.controller;

import kakao.kakaoClone.config.auth.SessionUser;
import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.board.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

@RequiredArgsConstructor

public class HomeController {

    private final HttpSession httpSession;

    private final PostRepository postRepository;
    @GetMapping("/")
    public String index(Model model){
           SessionUser user=(SessionUser) httpSession.getAttribute("user");
        if (user!=null){
            model.addAttribute("userName",user.getName());
        }

        List<Post> posts= postRepository.findByBigCategory("donationTogether");
        if(posts!=null){
        model.addAttribute("post",posts);
        }


        return "index.html";
    }

    @GetMapping("/donationTogether/ing")
    public String donation_ing(Model model){
        SessionUser user=(SessionUser) httpSession.getAttribute("user");
        if (user!=null){
            model.addAttribute("userName",user.getName());
        }

        List<Post> posts= postRepository.findByBigCategoryAndSmallCategory("donationTogether","모금중");
        if(posts!=null){
            model.addAttribute("post",posts);
        }


        return "index.html";
    }
    @GetMapping("/donationTogether/end")
    public String donation_end(Model model){
        SessionUser user=(SessionUser) httpSession.getAttribute("user");
        if (user!=null){
            model.addAttribute("userName",user.getName());
        }

        List<Post> posts= postRepository.findByBigCategoryAndSmallCategory("donationTogether","모금후기");
        if(posts!=null){
            model.addAttribute("post",posts);
        }


        return "index.html";
    }

    @GetMapping("/promotion")
    public String promotion(Model model){
        SessionUser user=(SessionUser) httpSession.getAttribute("user");
        if (user!=null){
            model.addAttribute("userName",user.getName());
        }

        List<Post> posts= postRepository.findByBigCategory("promotion");
        if(posts!=null){
            model.addAttribute("post",posts);
        }


        return "index.html";
    }
}