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
			System.out.println("서버연결");
			// 1.서버소켓을 생성한다. 서버소켓 9999포트로 염
			ServerSocket s_socket = new ServerSocket(9998);
			Socket c_socket = s_socket.accept();

			ReceiveThread receiveThread = new ReceiveThread();
			receiveThread.setSocket(c_socket);

			SendThread sendThread = new SendThread();
			sendThread.setSocket(c_socket);

			receiveThread.start();
			sendThread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
