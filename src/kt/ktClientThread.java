package kt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.GeneralSecurityException;

public class ktClientThread extends Thread {
	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// ������ ���� ������ ����. ���߿� ������ �����~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); // ����Ʈ���� 45
			dataTest.setAge("105");
			dataTest.setRrn("9102221233121");
			dataTest.setGbCode("0003");
			dataTest.setPhoneNumber("01026557713");
			dataTest.setName("�Һ���");
			String realdata = new String(dataTest.serializeData().getBytes());
			
			//���� ������ ��ȣȭ
			String key = "aes256-test-key!!";       // key�� 16�� �̻�
		    AES256Util aes256 = new AES256Util(key);
		    String encText = aes256.encrypt(realdata);
		    System.out.println("��ȣȭ�� ���� : " + encText);
			
		    
		    // ���� ������
			// outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = encText.getBytes("euc-kr");
			System.out.println("����������");
			os.write(byteArr);
			os.flush();

			// m_Socket.close();

			// Ŭ���̾�Ʈ�� ���� �����͸� ������ byte[]�迭 ����
			byte[] byteArr2 = new byte[100];
			// �̰��� �Ű������� inputStream�� read�޼��� ȣ��
			InputStream is = m_Socket.getInputStream();
			// read�޼ҵ嵵 �ٽ�.. �Ƹ� read�޼ҵ�� �оbyteArr�� ��°� ����.
			int readByteCount = is.read(byteArr2);
			// �̺κп� ���ؼ��� �˻��غ���. ���ڰ�4���� �� �־���ϴ°���.
			String data2 = new String(byteArr2, 0, readByteCount, "euc-kr");
			System.out.println(data2);
			os.close();
			is.close();

			// m_Socket.close();
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}