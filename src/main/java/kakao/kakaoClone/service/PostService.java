package kakao.kakaoClone.service;


import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.board.PostRepository;
import kakao.kakaoClone.domain.board.PostSaveRequestDto;
import kakao.kakaoClone.domain.board.PostUpdateRequestDto;
import kakao.kakaoClone.domain.likes.UserLikePost;
import kakao.kakaoClone.domain.likes.UserLikePostRepository;
import kakao.kakaoClone.domain.user.User;
import kakao.kakaoClone.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service


public class PostService {
    private final PostRepository postRepository;
    private final S3Uploader s3Uploader;

    private final UserRepository userRepository;

    private final UserLikePostRepository userLikePostRepository;

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


    /** ========================= 게시물 좋아요 및 조회수 처리 ========================= **/


    /** 글 좋아요 **/
    @Transactional
    public boolean saveLike(Long post_id, Long user_id) {

        /** 로그인한 유저가 해당 게시물을 좋아요 했는지 안 했는지 확인 **/
        if(!findLike(post_id, user_id)){

            /* 좋아요 하지 않은 게시물이면 좋아요 추가, true 반환 */
            User user = userRepository.findById(user_id).orElseThrow(() ->
                    new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
            Post post = postRepository.findById(post_id).orElseThrow(() ->
                    new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

            /* 좋아요 엔티티 생성 */
            UserLikePost userLikePost = new UserLikePost(user, post);
            userLikePostRepository.save(userLikePost);
            postRepository.plusLike(post_id);

            return true;
        } else {

            /* 좋아요 한 게시물이면 좋아요 삭제, false 반환 */
            userLikePostRepository.deleteByPost_IdAndUser_Id(post_id, user_id);
            postRepository.minusLike(post_id);

            return false;
        }
    }

    /** 글 좋아요 확인 **/
    @Transactional
    public boolean findLike(Long post_id, Long user_id) {

        return userLikePostRepository.existsByPost_IdAndUser_Id(post_id,user_id);

    }

    /** 글 조회수 업데이트 **/
    @Transactional
    public void updateView(Long post_id) {
        postRepository.updateView(post_id);
    }


}

/*



    String topic, String bigCategory , String smallCategory, String title,
        String content, String author, String tag1, String tag2, String tag3,
        String endDate, Long endPrice,Long currentPrice

 */
