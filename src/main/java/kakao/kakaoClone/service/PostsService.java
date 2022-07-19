package kakao.kakaoClone.service;


import kakao.kakaoClone.domain.board.PostsRepository;
import kakao.kakaoClone.domain.board.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service

public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public void save(PostsSaveRequestDto requestDto){
        postsRepository.save(requestDto.toEntity());
        System.out.println("save end");
    }


}
