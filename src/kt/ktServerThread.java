package kt;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ktServerThread extends Thread{

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// Ŭ���̾�Ʈ�� ���� �����͸� ������ byte[]�迭 ����
			byte[] byteArr = new byte[100];
			// �̰��� �Ű������� inputStream�� read�޼��� ȣ��
			InputStream is = m_Socket.getInputStream();
			// read�޼ҵ嵵 �ٽ�.. �Ƹ� read�޼ҵ�� �оbyteArr�� ��°� ����.
			int readByteCount = is.read(byteArr);
			// �̺κп� ���ؼ��� �˻��غ���. ���ڰ�4���� �� �־���ϴ°���.
			String data = new String(byteArr, 0, readByteCount, "euc-kr");
			System.out.println("!---------ReceiveThread--------!");
			System.out.println(data);

			
			String a ="���� : Ŭ���̾�Ʈ�� �ȳ�";
			String realdata = new String(a.getBytes());
			
			//���� �����͸�  byte[] �迭�� �����ϰ� �̰��� �Ű������� �Ͽ�
			//outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr1 = realdata.getBytes("euc-kr");
			System.out.println("����->Ŭ���̾�Ʈ ������ ����");
			os.write(byteArr1);
			os.flush();		
			is.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
