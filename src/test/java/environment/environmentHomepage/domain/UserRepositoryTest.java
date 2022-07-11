package environment.environmentHomepage.domain;


import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import environment.environmentHomepage.domain.user.Role;
import environment.environmentHomepage.domain.user.User;
import environment.environmentHomepage.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

public class UserRepositoryTest {
    @Autowired

    UserRepository userRepository;
    @After("")
    public void cleanup(){
        userRepository.deleteAll();
    }
    @Test
    public void 멤버_불러오기(){
        //given


        String name="솔찬";
        String email="solchan@gmail.com";

        userRepository.save(User.builder()
                .name(name)
                .email(email)
                .build());

/*
        userRepository.save(User.builder()
                .name(name)
                .email(email)
                .build());
            */

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);

    }

}