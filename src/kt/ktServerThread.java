package kt;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ktServerThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// 서버가 데이터 받는 부분
			// 클라이언트가 보낸 데이터를 저장할 byte[]배열 생성
			byte[] byteArr = new byte[100];
			// 이것을 매개값으로 inputStream의 read메서드 호출
			InputStream is = m_Socket.getInputStream();
			// read메소드 byteArr의 길이만큼 데이터를 읽어서 byteArr에 저장하고 읽은 바이트 수를 반환한다.
			int readByteCount = is.read(byteArr);
			String data = new String(byteArr, 0, readByteCount, "euc-kr");
			System.out.println("!---------ReceiveThread--------!");
			System.out.println(data);

			
			// 서버가 데이터 보내는 부분
			String realdata = new String("hoho".getBytes());
			// 보낼 데이터를 byte[] 배열로 생성하고 이것을 매개값으로 하여
			// outputStream의 write()메서드를 호출.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr1 = realdata.getBytes("euc-kr");
			System.out.println("서버->클라이언트 데이터 전송");
			os.write(byteArr1);
			System.out.println(byteArr1);
			os.flush();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
