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
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
			
			
			OutputStream os = socket.getOutputStream();
			
			//서버에 보낼 데이터 생성. 나중에 생성자 만들것~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); //바이트길이 45
			dataTest.setAge("55");
			dataTest.setRrn("9102061231234");
			dataTest.setGbCode("0001");
			dataTest.setPhoneNumber("0103333111");
			dataTest.setName("이웅");
			String message= new String(dataTest.serializeData().getBytes());
	
	
			byte[] bytes = message.getBytes("euc-kr");
			os.write(bytes);
			os.flush();

			
			
			System.out.println("[데이터 보내기 성공]");

			InputStream is = socket.getInputStream();

			bytes = new byte[100];

			int readByteCount = is.read(bytes);

			message = new String(bytes, 0, readByteCount, "UTF-8");

			System.out.println("[데이터 받기 성공]: " + message);

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
