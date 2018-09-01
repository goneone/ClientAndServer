package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static ArrayList<PrintWriter> m_OutputList;

	public static void main(String[] args) {

		try {
			// 1.서버소켓을 생성한다. 서버소켓 9999포트로 염
			ServerSocket s_socket = new ServerSocket(9999);
			Socket c_socket = s_socket.accept();
			// 2. 클라이언트랑 연결된 소켓으로부터 outputstream 객체를 가져온다.
			// 이 객체에 서버에서 전달할 메세지를 작상허여 전달한다.
			OutputStream output_data = c_socket.getOutputStream();
			String sendDataString = "start server";
			output_data.write(sendDataString.getBytes());

			s_socket.close();
			c_socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
