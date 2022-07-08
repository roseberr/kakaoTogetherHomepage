package environment.environmentHomepage.domain;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {
    @Autowired

    private MemberRepository memberRepository;
    @Test

    public void 멤버_불러오기(){
        //given
        String password="비밀번호";
        Long id=3L;
        String userID="solchan";

        String name="solchan";
        String email1="solchan";
        LocalDateTime date=LocalDateTime.now();


        memberRepository.save(Member.builder()
                .password(password)
                .id(id).userId(userID)
                .name(name)
                .email1(email1)
                .joinDate(date)
                .build());
        //when
        List<Member> memberList=memberRepository.findAll();

        //then
        Member member=memberList.get(0);
        assertThat(member.getName()).isEqualTo(name);




    }

}