package exception.ex1;

public class NetworkServiceV1_2 {

    public void sendMessage(String data) { // 복잡한 NetworkClient 사용 로직을 처리
        String address = "http://example.com"; // 접속할 외부 서버 주소도 함께 전달한다.
        NetworkClientV1 client = new NetworkClientV1(address); // NetworkClient를 생성
        client.initError(data); // 에러 초기화!!

        // 전체 적인 흐름을 NetworkService의 sendMessage에서 관리
        // connect( ) 메서드가 연결 상태를 반환하는 것을 볼 수 있음! 그렇다면 반환값을 받을 수 있는 친구 만들어주기!!!
        String connectResult = client.connect();
        if (isError(connectResult)) { // 결과가 성공이 아니라면 -> 오류라면!!!
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
            return;
        }

        // send( ) 메서드가 연결 상태를 반환하는 것을 볼 수 있음! 그렇다면 반환값을 받을 수 있는 친구 만들어주기!!!
        String sendResult = client.send(data);
        if (isError(sendResult)) { // 결과가 성공이 아니라면 -> 오류라면!!!
            System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            return;
        }

        client.disconnect();
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
