package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//�۽Ž�����
public class SendThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {

			// Ŭ���̾�Ʈ ������ ��ǲ ��Ʈ���� ����ϱ� ���ϰ� �����ϰ� �����͸� �޾ƿ�.
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());

			String sendString;
			
			//�� ���� while���� �����͸� �ۼ����ϰ� ��
			//���� �����͸� �����ϴ� �κ�
			while (true) {
				sendString = tmpbuf.readLine();

				if (sendString.equals("exit")) {
					break;
				}
				sendWriter.println(sendString);
				sendWriter.flush();
			}

			sendWriter.close();
			tmpbuf.close();
			m_Socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�������κ��� ���� ��ü�� �ޱ����� �޼ҵ� 
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
