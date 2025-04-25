// Caesar Cipher(카이사르 암호 혹은 시저 암호): 간단한 대체 암호
// 이 코드는 각 문자를 주어진 shift 값만큼 밀어내어 암호화하는 방식이다

public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // 해당 문자의 대소문자를 구분하여 shift만큼 문자를 밀어낸다
            if (Character.isLetter(c)) {    
                char base = (Character.isLowerCase(c)) ? 'a' : 'A'; 
                //c = (char) ((shift % 26) + c); 문자 범위를 초과하는 경우가 발생함
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        String text = "ABCDEFG HIJKLMN";
        int shift = 30;     // 12번라인에 의헤 30칸이 아닌 4칸을 밀어냄
        System.out.println("Encrypted: " + encrypt(text, shift));
    }
}
