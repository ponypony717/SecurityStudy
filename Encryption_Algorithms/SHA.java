// SHA-256 (Secure Hash Algorithm 256-bit): 입력 데이터를 고정된 크기의 해시값(256비트)으로 변환하는 암호화 해시 함수
// 단방향성을 가지고 있어 입력을 해시값으로 변환 할 수는 있지만, 역으로 해시값을 복호화하는것은 거의 불가능함 -> 비밀번호, 블록체인 보안에 사용됨됨
// 입력 데이터 크기에 상관없이 항상 고정된 크기의 해시값을 반환함 ex) SHA-256은 항상 256비트 길이의 해시값을 반환
// 다른 입력데이터가 같은 해시값을 가지지 않도록 설계되어 있어야 함

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    // 바이트 배열을 16진수 문자열로 변환하는 함수
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b)); // 각 바이트를 16진수로 변환
        }
        return sb.toString(); // 최종 16진수 문자열 반환
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 해시할 원본 텍스트
        String text = "Hello World!";

        // SHA-256 알고리즘을 사용하는 해시 객체 생성
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha.digest(text.getBytes()); // 텍스트를 바이트 배열로 변환 후 해시 처리

        // 해시 결과를 16진수 문자열로 출력
        System.out.println("SHA-256 Hash: " + bytesToHex(hash));
    }
}
