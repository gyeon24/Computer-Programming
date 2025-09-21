package lab12.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiChatServer {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            //TODO: 클라이언트의 연결 시도를 수신하는 서버 소켓 생성, 포트번호는 9000
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("서버가 시작되었습니다. 클라이언트 연결을 기다립니다...");

            while (true) {
                //TODO: 클라이언트 접속 요청 대기 -> 클라이언트의 연결 시도가 있으면 통신할 소켓 생성
                Socket clientSocket = ss.accept();
                synchronized (clients){
                    clients.add(clientSocket);
                }

                System.out.println("클라이언트가 연결되었습니다.");

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private BufferedReader reader;
        private Socket clientSocket;

        public ClientHandler(Socket socket) throws IOException {
            // TODO: reader 객체 생성과 clientSocket 초기화
            this.clientSocket = socket;
            this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("클라이언트로부터 수신: " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                System.out.println("클라이언트 종료");
                if(!clientSocket.isClosed()) {
                    try {
                        clientSocket.close();
                    } catch (IOException ex) {
                        System.err.println("Failed to close socket");
                    }
                }
            }
        }

        private void broadcast(String message) throws IOException {
            clients.removeIf(Socket::isClosed);      // Socket이 닫혀있다면 clients에서 삭제
            for (Socket client : clients) {
                // TODO: PrintWriter를 새로 정의하여 client.getOutputStream() 에 내용 전송
                try {
                    PrintWriter pw = new PrintWriter(client.getOutputStream(), true); // 클라이언트 출력 스트림
                    pw.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
