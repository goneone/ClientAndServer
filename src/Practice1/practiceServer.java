package Practice1;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.InetSocketAddress;

import java.net.ServerSocket;

import java.net.Socket;

public class practiceServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while (true) {
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept();
				
				//클라이언트가 보낸 데이터를 저장할 byte[]배열 생성
				byte[] bytes = new byte[100];
				// 이것을 매개값으로 inputStream의 read메서드 호출
				InputStream is = socket.getInputStream();
				int readByteCount = is.read(bytes);

				String message = new String(bytes, 0, readByteCount, "euc-kr");
				System.out.println("[데이터 받기 성공]: " + message);

				
				OutputStream os = socket.getOutputStream();
				// 내가 클라이언트에게 보낼 메세지.
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");

				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
				is.close();
				os.close();
				socket.close();

			}

		} catch (Exception e) {
		}

		if (!serverSocket.isClosed()) {

			try {

				serverSocket.close();

			} catch (IOException e1) {
			}

		}

	}

}