package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import client.data;

//�۽Ž�����
public class SendThread extends Thread {

	private Socket m_Socket;

	@Override
	public void run() {
		super.run();

		try {
			//������ ���� ������ ����. ���߿� ������ �����~!
			
			String a ="���ۼ����߽��ϴ� ";
			String realdata = new String(a.getBytes());
			
			//���� �����͸�  byte[] �迭�� �����ϰ� �̰��� �Ű������� �Ͽ�
			//outputStream�� write()�޼��带 ȣ��.
			OutputStream os = m_Socket.getOutputStream();
			byte[] byteArr = realdata.getBytes("euc-kr");
			System.out.println("����->Ŭ���̾�Ʈ ������ ����");
			//Thread.sleep(3000);
			os.write(byteArr);
			os.flush();
			//os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		/*} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
	}
	//�������κ��� ���� ��ü�� �ޱ����� �޼ҵ� 
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
