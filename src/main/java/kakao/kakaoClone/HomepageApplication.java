package kakao.kakaoClone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@EnableJpaAuditing
@SpringBootApplication

public class HomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepageApplication.class, args);
	}


	//HiddenHttpMethodFilter를 Bean으로 등록하여, @PutMapping과 @DeleteMapping이작동할 수 있도록 해줍니다.
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
