package kt;

public class encrypteTest {
	
	    public static void main(String[] args) throws Exception {
	        String key = "aes256-test-key!!";       // key는 16자 이상
	        AES256Util aes256 = new AES256Util(key);
	         
	        String text = "암호화예제";
	        String encText = aes256.encrypt(text);
	        String decText = aes256.decrypt(encText);
	         
	        System.out.println("암호화할 문자 : " + text);
	        System.out.println("암호화된 문자 : " + encText);
	        System.out.println("복호화된 문자 : " + decText);
	    }
	 
	}