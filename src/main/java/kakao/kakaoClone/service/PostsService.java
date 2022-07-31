package kakao.kakaoClone.service;


import kakao.kakaoClone.domain.board.PostsRepository;
import kakao.kakaoClone.domain.board.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        String fileName=uuid+"_"+file.getOriginalFilename();

        File saveFile=new File(projectPath,fileName);
        if(!saveFile.isDirectory()){
            saveFile.mkdirs();
        }


        file.transferTo(saveFile);

        requestDto.setFilename(fileName);
        requestDto.setFilepath(projectPath+"\\"+fileName);

        postsRepository.save(requestDto.toEntity());

        System.out.println("save end");
    }

}
