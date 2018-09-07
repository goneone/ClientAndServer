package kt;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ktServerThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// ������ ������ �޴� �κ�
			// Ŭ���̾�Ʈ�� ���� �����͸� ������ byte[]�迭 ����
			byte[] byteArr = new byte[100];
			// �̰��� �Ű������� inputStream�� read�޼��� ȣ��
			InputStream is = m_Socket.getInputStream();
			// read�޼ҵ� byteArr�� ���̸�ŭ �����͸� �о byteArr�� �����ϰ� ���� ����Ʈ ���� ��ȯ�Ѵ�.
			int readByteCount = is.read(byteArr);
			String data = new String(byteArr, 0, readByteCount, "euc-kr");
			System.out.println("!---------ReceiveThread--------!");
			System.out.println(data);

			
			// ������ ������ ������ �κ�
			String realdata = new String("hoho".getBytes());
			// ���� �����͸� byte[] �迭�� �����ϰ� �̰��� �Ű������� �Ͽ�
			// outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr1 = realdata.getBytes("euc-kr");
			System.out.println("����->Ŭ���̾�Ʈ ������ ����");
			os.write(byteArr1);
			System.out.println(byteArr1);
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
