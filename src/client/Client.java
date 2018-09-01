package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {

		try {
			Socket c_socket = new Socket("localhost", 9999);

			//연결이 되면 데이터를 스트림형태로 받아와서 콘솔창에 출력
			InputStream input_data = c_socket.getInputStream();

			byte[] receiveBuffer = new byte[100];
			input_data.read(receiveBuffer);

			c_socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
