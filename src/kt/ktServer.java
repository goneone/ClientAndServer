package kt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.ReceiveThread;

public class ktServer {
	public static void main(String[] args) {
		try {
			System.out.println("--서버구동---");
			// 서버소켓을 생성한다. 서버소켓 9997포트로 염
			ServerSocket s_socket = new ServerSocket(9997);
			 /*
			 accept 메소드의 역할은 클라이언트가 들어오는 것을 대기 하는 역할.
			 즉, 클라이언트가 해당 포트에 연결 시도하면 accept 메소드는 대기를 풀고 
			 클라이언트와 연결시키는 socket 클래스를 생성하여 반환한다.
			 그래서 c_socket은 클라이언트와 1:1 연결된 소켓이다. 
			 이 c_socekt으로 클라이언트랑 통신을 하게 됨.
			 */
			Socket c_socket = s_socket.accept();
			System.out.println(c_socket.getInetAddress() + "로 부터 연결요청이 들어옴");

			ktServerThread ktServerThread = new ktServerThread();
			ktServerThread.setSocket(c_socket);

			ktServerThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}