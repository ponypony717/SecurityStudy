// AES (Advanced Encryption Standard): 현대에서 가장 널리 사용되는 대칭키 암호화 알고리즘
// AES는 128비트, 192비트, 256비트 키 길이를 지원하며, 빠르고 안전하게 데이터를 암호화할 수 있다
// 이 코드는 AES 알고리즘을 사용하여 데이터를 암호화하고 복호화하는 방식이다
// 대칭키 방식이기 때문에 암호화와 복호화에 동일한 비밀 키 사용

import javax.crypto.Cipher; // 암호화 알고리즘을 구현하는 기능 제공
import javax.crypto.KeyGenerator; // 대칭키를 생성하는 도구 
import javax.crypto.SecretKey; // 대칭키 암호화에서 사용하는 암호/복호화용 키

public class AES {
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");    // AES 알고리즘에 필요한 키 생성할 수 있는 KeyGenerator객체 생성
        keyGenerator.init(128); // 키 길이: 128비트
        return keyGenerator.generateKey();  // KeyGenerator 클래스의 generateKey()함수를 호출하여 비밀 키 생성하여 리턴 (재귀아님XXX)
    }
    public static void main(String[] args) throws Exception {
        String text = "Hello World!";

        // 대칭키 생성 (128비트)
        SecretKey secretKey = generateKey();

        // AES 암호화 객체 생성
        Cipher cipher = Cipher.getInstance("AES");

        // 암호화 모드로 설정
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        System.out.println("Encrypted: " + new String(encrypted)); // 출력은 깨질 수 있음 (바이트 배열임)

        // 복호화 모드로 설정
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }

    
}

