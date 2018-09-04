package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {

		try {

			Socket c_socket = new Socket("localhost", 9997);

			// ������ �Ǹ� �����͸� ��Ʈ�����·� �޾ƿͼ� �ܼ�â�� ���
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
