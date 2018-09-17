package kt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.GeneralSecurityException;

public class ktClientThread extends Thread {
	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			// 서버에 보낼 데이터 생성. 나중에 생성자 만들것~!
			data dataTest = new data();
			dataTest.setDataLength("0045"); // 바이트길이 45
			dataTest.setAge("105");
			dataTest.setRrn("9102221233121");
			dataTest.setGbCode("0003");
			dataTest.setPhoneNumber("01026557713");
			dataTest.setName("할부지");
			String realdata = new String(dataTest.serializeData().getBytes());
			
			//보낼 데이터 암호화
			String key = "aes256-test-key!!";       // key는 16자 이상
		    AES256Util aes256 = new AES256Util(key);
		    String encText = aes256.encrypt(realdata);
		    System.out.println("암호화된 문자 : " + encText);
			
		    
		    // 받을 데이터
			// outputStream의 write()메서드를 호출.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = encText.getBytes("euc-kr");
			System.out.println("데이터전송");
			os.write(byteArr);
			os.flush();

			// m_Socket.close();

			// 클라이언트가 보낸 데이터를 저장할 byte[]배열 생성
			byte[] byteArr2 = new byte[100];
			// 이것을 매개값으로 inputStream의 read메서드 호출
			InputStream is = m_Socket.getInputStream();
			// read메소드도 다시.. 아마 read메소드로 읽어서byteArr에 담는거 같음.
			int readByteCount = is.read(byteArr2);
			// 이부분에 대해서는 검색해볼것. 인자값4개는 뭘 넣어야하는건지.
			String data2 = new String(byteArr2, 0, readByteCount, "euc-kr");
			System.out.println(data2);
			os.close();
			is.close();

			// m_Socket.close();
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}