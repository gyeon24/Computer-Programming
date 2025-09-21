package lab12.hw1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DataClient {
    private Socket clientSocket;
    private ObjectOutputStream writeObj;
    private ObjectInputStream readObj;
    private boolean isSending;

    public DataClient() throws IOException {
        initialize();
        readData();
        sendData();
    }

    public void initialize() throws IOException {
        clientSocket = new Socket("localhost", 9000);
        System.out.println("서버에 연결되었습니다");
        writeObj = new ObjectOutputStream(clientSocket.getOutputStream());
        writeObj.flush();
        readObj = new ObjectInputStream(clientSocket.getInputStream());
        isSending = true;
    }

    public void readData() {
        new Thread(()-> {
            // TODO: 데이터 수신 처리
            try {
                while (isSending) {
                    Data d = (Data) readObj.readObject();
                    System.out.println(d);
                    if (d == null) {
                        isSending = false;
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                isSending = false;
            }
            System.out.println("readData thread 종료");
        }).start();
    }

    public void sendData() {
        new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            String d1, d2, d3;
            while (isSending) {
                try {
                    // TODO: 입력을 세 번 받아 데이터 전송
                    System.out.println("보내실 데이터를 입력하세요 (1/3)");
                    d1 = sc.nextLine();

                    System.out.println("보내실 데이터를 입력하세요 (2/3)");
                    d2 = sc.nextLine();

                    System.out.println("보내실 데이터를 입력하세요 (3/3)");
                    d3 = sc.nextLine();

                    writeObj.writeObject(new Data(d1, d2, d3));
                    System.out.println("데이터를 보냈습니다.");
                    writeObj.flush();

                    System.out.println("더 보내시겠습니까? " + "y/n");

                    System.out.println("데이터가 도착했습니다.");

                    if (sc.nextLine().equals("n")) {
                        isSending = false;
                        writeObj.writeObject(null);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    isSending = false;
                }
            }
            sc.close();
            System.out.println("sendData thread 종료");
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new DataClient();
    }
}
