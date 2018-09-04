package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {

		try {

			Socket c_socket = new Socket("localhost", 9997);

			// 연결이 되면 데이터를 스트림형태로 받아와서 콘솔창에 출력
			SendThread sendThread = new SendThread();
			sendThread.setSocket(c_socket);

			ReceiveThread receiveThread = new ReceiveThread();
			receiveThread.setSocket(c_socket);
		
			sendThread.start();
			receiveThread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
