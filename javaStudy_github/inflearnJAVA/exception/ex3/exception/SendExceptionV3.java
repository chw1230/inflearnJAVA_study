package exception.ex3.exception;

// 전송 실패시 발생하는 예외
public class SendExceptionV3 extends NetworkClientExceptionV3{
    // 내부에 전송을 시도한 sendData 보관
    private final String sendData;

    public SendExceptionV3(String sendData, String message) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}