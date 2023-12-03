package TcpIpServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		try {
			// 서버 소켓을 생성한다.
			serverSocket = new ServerSocket(7777); // port number = 7777
			System.out.println(getTime() + "Server is ready");
		} catch(IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				System.out.println(getTime() + "Waiting for the connection request");
				// 서버 소켓이 클라이언트 프로그램의 연결요청을 처리할 수 있도록 대기상태로 만든다.
				// 클라이언트 프로그램의 연결요청이 오면 새로운 소켓을 생성해서 클라이언트 프로그램의 소켓과 연결한다.
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결 요청이 들어왔습니다.");
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF("[Notice] TestMessage1 from Server");
				System.out.println(getTime() + "Data transferring is over");
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
