package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import client.data;

//�۽Ž�����
public class SendThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			//������ ���� ������ ����. ���߿� ������ �����~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); //����Ʈ���� 45
			dataTest.setAge("55");
			dataTest.setRrn("9102061231234");
			dataTest.setGbCode("0001");
			dataTest.setPhoneNumber("0103333111");
			dataTest.setName("�̿�");
			String realdata= new String(dataTest.serializeData().getBytes());
			String a = "it is Test";
			String test = new String(a.getBytes());
			
			//���� �����͸�  byte[] �迭�� �����ϰ� �̰��� �Ű������� �Ͽ�
			//outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = test.getBytes("UTF-8");
			System.out.println(byteArr);
			os.write(byteArr);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�������κ��� ���� ��ü�� �ޱ����� �޼ҵ� 
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
