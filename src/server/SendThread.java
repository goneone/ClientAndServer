package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import client.data;

//송신스레드
public class SendThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			//서버에 보낼 데이터 생성. 나중에 생성자 만들것~!
			
			String a ="it is Test";
			String realdata = new String(a.getBytes());
			
			//보낼 데이터를  byte[] 배열로 생성하고 이것을 매개값으로 하여
			//outputStream의 write()메서드를 호출.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = realdata.getBytes("euc-kr");
			System.out.println("서버->클라이언트 데이터 전송");
			os.write(byteArr);
			//os.flush();
			//os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//메인으로부터 소켓 객체를 받기위한 메소드 
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
