package kakao.kakaoClone.service;


import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.board.PostRepository;
import kakao.kakaoClone.domain.board.PostSaveRequestDto;
import kakao.kakaoClone.domain.board.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service


public class PostsService {
    private final PostRepository postRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public void save(PostSaveRequestDto requestDto, MultipartFile file)throws Exception{
/*
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
*/
        System.out.println("PostService s3 start");

        String uploadUrl=s3Uploader.upload(file, "static");
        requestDto.setFilepath(uploadUrl);
       // https://solchan-kakao-web-bucket.s3.ap-northeast-2.amazonaws.com/static/
        System.out.println("PostService s3 end");
        postRepository.save(requestDto.toEntity());
        System.out.println("save end");
    }

    @Transactional(readOnly = true)
    public List<Post> getBoards() {
        List<Post> post = postRepository.findAll();
        return post;
    }

    @Transactional(readOnly = true)
    public Post getBoard(Long id) {
       Post post= postRepository.findById(id).get();
        return post;
    }


    @Transactional
    public Post save(Post board) {
        return postRepository.save(board);
    }


    @Transactional
    public Post update(PostUpdateRequestDto requestDto, MultipartFile file, Long id)throws Exception{
/*
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

        */
        //파일업로드
        String uploadUrl=s3Uploader.upload(file, "static");
        requestDto.setFilepath(uploadUrl);


        //받아온 정보 update
        Post post = postRepository.findById(id) .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        post.setTopic(requestDto.getTopic());
        post.setBigCategory(requestDto.getBigCategory());
        post.setSmallCategory(requestDto.getSmallCategory());
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
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
        postRepository.deleteById(id);
    }

}


/*



    String topic, String bigCategory , String smallCategory, String title,
        String content, String author, String tag1, String tag2, String tag3,
        String endDate, Long endPrice,Long currentPrice

 */
