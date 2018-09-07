package kt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ktClientThread extends Thread {
	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// 서버에 보낼 데이터 생성. 나중에 생성자 만들것~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); // 바이트길이 45
			dataTest.setAge("55");
			dataTest.setRrn("9102061231234");
			dataTest.setGbCode("0001");
			dataTest.setPhoneNumber("0103333111");
			dataTest.setName("이웅");
			String realdata = new String(dataTest.serializeData().getBytes());

			// 클라이언트가 보낼 데이터
			// outputStream의 write()메서드를 호출.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = realdata.getBytes("euc-kr");
			System.out.println("데이터전송");
			os.write(byteArr);
			os.flush();

			// 클라이언트가 받을 데이터
			byte[] byteArr2 = new byte[100];
			// 이것을 매개값으로 inputStream의 read메서드 호출
			InputStream is = m_Socket.getInputStream();
			// read메소드 - byteArr2의 길이만큼 데이터를 읽어서 byteArr에 저장하고 읽은 바이트 수를 반환한다.
			int readByteCount = is.read(byteArr2);
			String data2 = new String(byteArr2, 0, readByteCount, "euc-kr");
			System.out.println(data2);
			os.close();
			is.close();
			// m_Socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}