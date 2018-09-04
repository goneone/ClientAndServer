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
				System.out.println("[���� ��ٸ�]");
				Socket socket = serverSocket.accept();
				
				//Ŭ���̾�Ʈ�� ���� �����͸� ������ byte[]�迭 ����
				byte[] bytes = new byte[100];
				// �̰��� �Ű������� inputStream�� read�޼��� ȣ��
				InputStream is = socket.getInputStream();
				int readByteCount = is.read(bytes);

				String message = new String(bytes, 0, readByteCount, "euc-kr");
				System.out.println("[������ �ޱ� ����]: " + message);

				
				OutputStream os = socket.getOutputStream();
				// ���� Ŭ���̾�Ʈ���� ���� �޼���.
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");

				os.write(bytes);
				os.flush();
				System.out.println("[������ ������ ����]");
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