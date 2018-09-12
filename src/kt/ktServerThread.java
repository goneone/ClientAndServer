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
			// ������ ������ �޴� �κ�
			// Ŭ���̾�Ʈ�� ���� �����͸� ������ byte[]�迭 ����
			byte[] byteArr = new byte[100];
			// �̰��� �Ű������� inputStream�� read�޼��� ȣ��
			InputStream is = m_Socket.getInputStream();
			// read�޼ҵ� byteArr�� ���̸�ŭ �����͸� �о byteArr�� �����ϰ� ���� ����Ʈ ���� ��ȯ�Ѵ�.
			int readByteCount = is.read(byteArr);
			String data = new String(byteArr, 0, readByteCount, "euc-kr");
			System.out.println("!---------ReceiveThread--------!");
			System.out.println(data);

			//���� ������ �ڸ��� �κ�
			parseData parseData = new parseData();
			String codeGB 		= parseData.getString(data, 4, 4); //CRUD �����ڵ�
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
				//��ȸ
				/*insertMethod insertMethod = new insertMethod();
				insertMethod.insert(data);*/
			} else if (codeGB.equals("0002")) {
				//����
				insertMethod insertMethod = new insertMethod();
				insertMethod.insert(name, age, rrn, phoneNumber);
			} else if (codeGB.equals("0003")) {
				//����
			} else if (codeGB.equals("0004")) {
				//����
			} else {
				
			}
			
			// ������ Ŭ���̾�Ʈ���� ������ ������ �κ�
			String realdata = new String("hoho".getBytes());
			// ���� �����͸� byte[] �迭�� �����ϰ� �̰��� �Ű������� �Ͽ�
			// outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr1 = realdata.getBytes("euc-kr");
			System.out.println("����->Ŭ���̾�Ʈ ������ ����");
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
