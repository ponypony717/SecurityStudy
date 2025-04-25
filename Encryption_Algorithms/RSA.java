// RSA 알고리즘: 공개키로 암호화하고 개인키로 복호화 
// 개인키 생성과정에서 큰 소수 p와 q를 결정함
/* 
   해커는 통신중에 공개된 공개키 e, p와 q를 곱한 결과인 n을 얻게 됨
   -> 이를 통해 개인키를 얻기위해서는 n = p x q 로 표현되는 두 소수 p와 q를 소인수 분해로 구해야 함 
   -> n은 매우 큰 수이므로, 이를 소인수 분해하려면 수백 년이 걸릴 정도로 계산이 어려움 
*/ 
import java.security.*;
import javax.crypto.Cipher;

public class RSA {
    public static void main(String[] args) throws Exception {
        // 암호화할 원본 텍스트
        String text = "Hello World!";

        // 공개키/개인키 쌍 생성
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // RSA 키 길이 설정
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();  // 공개키
        PrivateKey privateKey = keyPair.getPrivate();   // 개인키

        // RSA 암호화/복호화 객체 생성
        Cipher cipher = Cipher.getInstance("RSA");

        //암호화
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);    // 공개키로 원본 텍스트 암호화
        byte[] encrypted = cipher.doFinal(text.getBytes());
        System.out.println("Encrypted: " + new String(encrypted)); // 암호화된 텍스트 출력 (깨질 수 있음)

        //복호화
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(encrypted);   // 개인키로 암호문 복호화
        System.out.println("Decrypted: " + new String(decrypted)); // 복호화된 텍스트 출력
    }
}
