package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {

		try {
			Socket c_socket = new Socket("localhost", 9999);

			//������ �Ǹ� �����͸� ��Ʈ�����·� �޾ƿͼ� �ܼ�â�� ���
			InputStream input_data = c_socket.getInputStream();

			byte[] receiveBuffer = new byte[100];
			input_data.read(receiveBuffer);

			c_socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
