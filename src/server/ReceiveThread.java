package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//수신 쓰레드 
public class ReceiveThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {

			// 클라이언트 소켓의 인풋 스트림을 사용하기 편하게 변경하고 데이터를 받아옴.
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));

			String receiveString;
			while (true) {
				receiveString = tmpbuf.readLine();

				if(receiveString == null) {
					System.out.println("연결 끊김");
					break;
				}
				else 
				{
					System.out.println("상대방 : " + receiveString);
				}
			}
			tmpbuf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
