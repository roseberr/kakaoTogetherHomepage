package environment.environmentHomepage.domain;

import environment.environmentHomepage.domain.user.User;
import environment.environmentHomepage.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired

    private UserRepository userRepository;
    @Test

    public void 멤버_불러오기(){
        //given
        String password="비밀번호";
        Long id=3L;
        String userID="solchan";

        String name="solchan";
        String email1="solchan";
        LocalDateTime date=LocalDateTime.now();


        userRepository.save(User.builder()
                .password(password)
                .id(id).userId(userID)
                .name(name)
                .email1(email1)
                .joinDate(date)
                .build());
        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);




    }

}