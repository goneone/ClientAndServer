package kt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ktClientThread extends Thread {
	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// ������ ���� ������ ����. ���߿� ������ �����~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); // ����Ʈ���� 45
			dataTest.setAge("55");
			dataTest.setRrn("9102061231234");
			dataTest.setGbCode("0001");
			dataTest.setPhoneNumber("0103333111");
			dataTest.setName("�̿�");
			String realdata = new String(dataTest.serializeData().getBytes());

			// Ŭ���̾�Ʈ�� ���� ������
			// outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = realdata.getBytes("euc-kr");
			System.out.println("����������");
			os.write(byteArr);
			os.flush();

			// Ŭ���̾�Ʈ�� ���� ������
			byte[] byteArr2 = new byte[100];
			// �̰��� �Ű������� inputStream�� read�޼��� ȣ��
			InputStream is = m_Socket.getInputStream();
			// read�޼ҵ� - byteArr2�� ���̸�ŭ �����͸� �о byteArr�� �����ϰ� ���� ����Ʈ ���� ��ȯ�Ѵ�.
			int readByteCount = is.read(byteArr2);
			String data2 = new String(byteArr2, 0, readByteCount, "euc-kr");
			System.out.println(data2);
			os.close();
			is.close();
			// m_Socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}