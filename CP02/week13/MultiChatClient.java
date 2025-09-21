package lab12.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
    public static void main(String[] args) {
        try {
             // TODO: 서버에 연결을 요청하는 Socket 객체를 생성(서버에 연결 시도)
            Socket socket = new Socket("localhost",9000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("사용자 이름을 입력하세요: ");
            String username = scanner.nextLine();
            writer.println(username + " 님이 입장하였습니다.");

            // reader로 들어오는 모든 입력을 콘솔에 출력하는 스레드 부분
            Thread readerThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("스레드 종료");
                }
            });
            readerThread.start();

            System.out.println("채팅을 시작하세요. 종료하려면 'exit'를 입력하세요.");

            String userInput;
            while(true) {

                // TODO: 콘솔에서 입력된 내용을 writer로 전송하는 부분 구현
                userInput = scanner.nextLine();
                if(userInput.equalsIgnoreCase("exit")){
                    writer.println(username+"님이 퇴장하였습니다.");
                    break;
                } else{
                    writer.println(username+"> "+userInput);
                }
            }

            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}