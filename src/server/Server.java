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
			// 1.���������� �����Ѵ�. �������� 9999��Ʈ�� ��
			ServerSocket s_socket = new ServerSocket(9999);
			Socket c_socket = s_socket.accept();
			// 2. Ŭ���̾�Ʈ�� ����� �������κ��� outputstream ��ü�� �����´�.
			// �� ��ü�� �������� ������ �޼����� �ۻ��㿩 �����Ѵ�.
			OutputStream output_data = c_socket.getOutputStream();
			String sendDataString = "start server";
			output_data.write(sendDataString.getBytes());

			s_socket.close();
			c_socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
