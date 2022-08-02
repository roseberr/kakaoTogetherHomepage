package kakao.kakaoClone.service;


import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.board.PostsRepository;
import kakao.kakaoClone.domain.board.PostsSaveRequestDto;
import kakao.kakaoClone.domain.board.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class PostsService {
    private final PostsRepository postsRepository;


    @Transactional
    public void save(PostsSaveRequestDto requestDto, MultipartFile file)throws Exception{

       String projectPath=System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\files";
        //String projectPath="C:/webclone/upload";

        UUID uuid=UUID.randomUUID();
        //String fileName=uuid+"_"+file.getOriginalFilename();
        String fileName=file.getOriginalFilename();


        File saveFile=new File(projectPath,fileName);
        if(!saveFile.isDirectory()){
            saveFile.mkdirs();
        }


        file.transferTo(saveFile);

        requestDto.setFilename(fileName);
        //requestDto.setFilepath("files/"+fileName);

        requestDto.setFilepath(projectPath+"\\"+fileName);

        postsRepository.save(requestDto.toEntity());

        System.out.println("save end");
    }

    @Transactional(readOnly = true)
    public List<Posts> getBoards() {
        List<Posts> post = postsRepository.findAll();
        return post;
    }

    @Transactional(readOnly = true)
    public Posts getBoard(Long id) {
       Posts post= postsRepository.findById(id).get();
        return post;
    }


    @Transactional
    public Posts save(Posts board) {
        return postsRepository.save(board);
    }


    @Transactional
    public Posts update(PostsUpdateRequestDto requestDto, MultipartFile file, Long id)throws Exception{

        String projectPath=System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\files";
        //String projectPath="C:/webclone/upload";

        UUID uuid=UUID.randomUUID();
        String fileName=uuid+"_"+file.getOriginalFilename();

        File saveFile=new File(projectPath,fileName);
        if(!saveFile.isDirectory()){
            saveFile.mkdirs();
        }


        file.transferTo(saveFile);

        requestDto.setFilename(fileName);
        requestDto.setFilepath(projectPath+"\\"+fileName);

        Posts post = postsRepository.findById(id) .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        post.setTopic(requestDto.getTopic());
        post.setBigCategory(requestDto.getBigCategory());
        post.setSmallCategory(requestDto.getSmallCategory());
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        post.setAuthor(requestDto.getAuthor());
        post.setTag1(requestDto.getTag1());
        post.setTag2(requestDto.getTag2());
        post.setTag3(requestDto.getTag3());
        post.setEndDate(requestDto.getEndDate());
        post.setEndPrice(requestDto.getEndPrice());
        post.setCurrentPrice(requestDto.getCurrentPrice());


        System.out.println("update end");


        return post;
    }

    @Transactional
    public void deleteBoard(Long id) {
        postsRepository.deleteById(id);
    }

}


/*



    String topic, String bigCategory , String smallCategory, String title,
        String content, String author, String tag1, String tag2, String tag3,
        String endDate, Long endPrice,Long currentPrice

 */