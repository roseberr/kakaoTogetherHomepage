package kakao.kakaoClone.domain.board;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterAll
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글_불러오기(){
        String title="테스트 게시글";


    }


}