package environment.environmentHomepage.domain.board;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @AfterAll
    public void cleanup(){
        boardRepository.deleteAll();
    }
    @Test
    public void 게시글_불러오기(){
        String title="테스트 게시글";


    }


}