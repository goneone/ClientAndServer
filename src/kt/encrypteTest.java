package kt;

public class encrypteTest {
	
	    public static void main(String[] args) throws Exception {
	        String key = "aes256-test-key!!";       // key�� 16�� �̻�
	        AES256Util aes256 = new AES256Util(key);
	         
	        String text = "��ȣȭ����";
	        String encText = aes256.encrypt(text);
	        String decText = aes256.decrypt(encText);
	         
	        System.out.println("��ȣȭ�� ���� : " + text);
	        System.out.println("��ȣȭ�� ���� : " + encText);
	        System.out.println("��ȣȭ�� ���� : " + decText);
	    }
	 
	}