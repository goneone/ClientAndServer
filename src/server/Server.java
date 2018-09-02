package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) {

		try {
			//���������� �����Ѵ�. �������� 9997��Ʈ�� ��
			ServerSocket s_socket = new ServerSocket(9997);
			//Ŭ���̾�Ʈ ���� ����.
			//**���� ������ ������ Ŭ���̾�Ʈ ������ ���� ��û�� ����ϰ�, ���� ��û�� ���� Ŭ���̾�Ʈ ������ �����Ͽ� ����� �����ϰ� �Ѵ�.
			//**Ŭ���̾�Ʈ ������ ����ϴ� �� ���� �ٷ� ��밡���ϸ�, ������ ������ �ۼ����� �Ͼ�� ���� Ŭ���̾�Ʈ ����.
			
			//accept �޼ҵ��� ������ Ŭ���̾�Ʈ�� ������ ���� ��� �ϴ� ����. 
			//��, Ŭ���̾�Ʈ�� �ش� ��Ʈ�� ���� �õ��ϸ� accept �޼ҵ�� ��⸦ Ǯ�� Ŭ���̾�Ʈ�� �����Ű�� socket Ŭ������ �����Ͽ� ��ȯ�Ѵ�.
			//�׷��� c_socket�� Ŭ���̾�Ʈ�� 1:1 ����� �����̴�. �� c_socekt���� Ŭ���̾�Ʈ�� ����� �ϰ� ��.
			Socket c_socket = s_socket.accept();
			System.out.println("Ŭ���̾�Ʈ ����");
			
			
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
