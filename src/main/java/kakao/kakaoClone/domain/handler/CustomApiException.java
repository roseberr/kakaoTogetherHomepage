package kakao.kakaoClone.domain.handler;


public class CustomApiException extends RuntimeException{

    public CustomApiException(String message) {
        super(message);
    }
}