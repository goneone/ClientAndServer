package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//송신스레드
public class SendThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {

			// 클라이언트 소켓의 인풋 스트림을 사용하기 편하게 변경하고 데이터를 받아옴.
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());

			String sendString;
			
			//그 이후 while에서 데이터를 송수신하게 됨
			//실제 데이터를 전송하는 부분
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
	//메인으로부터 소켓 객체를 받기위한 메소드 
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
