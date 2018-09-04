package kt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ktClient {
	public static void main(String[] args) {
		try {

			Socket c_socket = new Socket("localhost", 9997);

			// 연결이 되면 데이터를 스트림형태로 받아와서 콘솔창에 출력
			ktClientThread ktClientThread = new ktClientThread();
			ktClientThread.setSocket(c_socket);

			ktClientThread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
