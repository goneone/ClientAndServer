package Practice1;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.InetSocketAddress;

import java.net.Socket;

public class practiceClient {

	public static void main(String[] args) {

		Socket socket = null;

		try {

			socket = new Socket();
			System.out.println("[���� ��û]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[���� ����]");
			
			
			OutputStream os = socket.getOutputStream();
			
			//������ ���� ������ ����. ���߿� ������ �����~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); //����Ʈ���� 45
			dataTest.setAge("55");
			dataTest.setRrn("9102061231234");
			dataTest.setGbCode("0001");
			dataTest.setPhoneNumber("0103333111");
			dataTest.setName("�̿�");
			String message= new String(dataTest.serializeData().getBytes());
	
	
			byte[] bytes = message.getBytes("euc-kr");
			os.write(bytes);
			os.flush();

			
			
			System.out.println("[������ ������ ����]");

			InputStream is = socket.getInputStream();

			bytes = new byte[100];

			int readByteCount = is.read(bytes);

			message = new String(bytes, 0, readByteCount, "UTF-8");

			System.out.println("[������ �ޱ� ����]: " + message);

			os.close();

			is.close();

		} catch (Exception e) {
		}

		if (!socket.isClosed()) {

			try {

				socket.close();

			} catch (IOException e1) {
			}

		}

	}

}
