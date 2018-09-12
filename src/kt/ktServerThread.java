package kt;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;

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

			//받은 데이터 자르는 부분
			parseData parseData = new parseData();
			String codeGB 		= parseData.getString(data, 4, 4); //CRUD 구분코드
			String name 		= parseData.getString(data, 8, 10);
			String age 			= parseData.getString(data, 18, 3);
			String rrn 			= parseData.getString(data, 21, 13);
			String phoneNumber  = parseData.getString(data, 34, 11);
			System.out.println(codeGB);
			System.out.println(name);
			System.out.println(age);
			System.out.println(rrn);
			System.out.println(phoneNumber);
			
			if (codeGB.equals("0001")) {
				//조회
				/*insertMethod insertMethod = new insertMethod();
				insertMethod.insert(data);*/
			} else if (codeGB.equals("0002")) {
				//삽입
				insertMethod insertMethod = new insertMethod();
				insertMethod.insert(name, age, rrn, phoneNumber);
			} else if (codeGB.equals("0003")) {
				//수정
			} else if (codeGB.equals("0004")) {
				//삭제
			} else {
				
			}
			
			// 서버가 클라이언트에게 데이터 보내는 부분
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
