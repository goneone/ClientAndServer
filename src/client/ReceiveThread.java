package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {

			// Ŭ���̾�Ʈ ������ ��ǲ ��Ʈ���� ����ϱ� ���ϰ� �����ϰ� �����͸� �޾ƿ�.
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));

			String receiveString;

			while (true) {
				receiveString = tmpbuf.readLine();

				System.out.println(receiveString);
			}
		} catch (IOException e) {
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
