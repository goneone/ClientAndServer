package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			//Ŭ���̾�Ʈ�� ���� �����͸� ������ byte[]�迭 ����
			byte[] byteArr = new byte[100];
			//�̰��� �Ű������� inputStream�� read�޼��� ȣ��
			InputStream is = m_Socket.getInputStream();
			//read�޼ҵ嵵 �ٽ�.. �Ƹ� read�޼ҵ�� �оbyteArr�� ��°� ����.
			int readByteCount = is.read(byteArr);
			//�̺κп� ���ؼ��� �˻��غ���. ���ڰ�4���� �� �־���ϴ°���.
			String data = new String(byteArr, 0, readByteCount, "UTF-8");
			System.out.println(data);

			is.close();
			m_Socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
