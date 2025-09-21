package lab12.practice1;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileClient {
	private Socket cs;
	private DataOutputStream fileNameSendStream;
	private DataOutputStream fileSaveStream;
	private DataInputStream fileRecvStream;
	private String fileName;
	private Scanner sc = new Scanner(System.in);

	public void connect() {
		System.out.println("접속 시도");

		// TODO: Socket 생성
		try{
			cs = new Socket("localhost",8080);
			System.out.println("접속 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setStream() {
		try {
			fileNameSendStream = new DataOutputStream(cs.getOutputStream());
			fileRecvStream = new DataInputStream(new BufferedInputStream(cs.getInputStream()));
			sendFileName();
			fileSaveStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}

	public void fileRecv() {
		int c = 0;
		try {
			while ((c = fileRecvStream.read()) != -1)
				fileSaveStream.write(c);
			System.out.println("저장완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendFileName() throws IOException {
		System.out.print("파일 이름 입력: ");

		// TODO: Scanner sc 로 파일 이름을 입력받아 fileNameSendStream.writeUTF로 전송
		fileName = sc.nextLine();
		fileNameSendStream.writeUTF(fileName);
	}

	public void closeAll() {
		try {
			fileSaveStream.flush();
			fileNameSendStream.close();
			fileRecvStream.close();
			fileSaveStream.close();
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}

	public FileClient() {
		connect();
		setStream();
		fileRecv();
		closeAll();
	}

	public static void main(String[] arg) {
		new FileClient();
	}
}
