package lab12.practice1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private ServerSocket ss;
	private Socket cs;

	private DataInputStream fileNameRecvStream;
	private DataOutputStream fileSendStream;
	private BufferedInputStream fileInServer;
	private String fileName;

	public void settingServer() {
		try {
			System.out.println("서버 생성중...");
			ss = new ServerSocket(8080);
			System.out.println("서버 대기중...");
			cs = ss.accept();
			System.out.println("클라이언트 접속 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setStream() {
		try {
			fileNameRecvStream = new DataInputStream(cs.getInputStream());
			fileSendStream = new DataOutputStream(new BufferedOutputStream(cs.getOutputStream()));
			fileName = fileNameRecvStream.readUTF();
			fileInServer = new BufferedInputStream(new FileInputStream(fileName));
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}

	public void sendFile() {
		System.out.println("전송중");

		// TODO: fileInServer에서 읽은 내용을 fileSendStream으로 전송
		byte[] b = new byte[1024];
		int br;

		try {
			while ((br = fileInServer.read(b)) != -1) {
				fileSendStream.write(b, 0, br);
			}
			fileSendStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("전송 완료");
	}

	public void closeAll() {
		try {
			fileSendStream.flush();
			fileNameRecvStream.close();
			fileInServer.close();
			fileSendStream.close();
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}

	public FileServer() {
		settingServer();
		setStream();
		sendFile();
		closeAll();
	}

	public static void main(String[] arg) {
		new FileServer();
	}
}
