package lab12.hw1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class DataServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream readObj;
    private ObjectOutputStream writeObj;
    private Map<String, String> dict;

    public DataServer() throws IOException {
        initialize();
        processData();
    }

    public void initialize() throws IOException {
        System.out.println("서버 생성중");
        dict = new HashMap<>();

        // TODO: dictionary.txt 파일을 읽어 dict 에 데이터 입력
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/user/IdeaProjects/untitled/src/lab12/hw1/dictionary.txt"));
        String s;
        while((s = br.readLine()) != null){
            String[] A = s.split(":");
            dict.put(A[0],A[1]);
        }

        serverSocket = new ServerSocket(9000);
        clientSocket = serverSocket.accept();
        System.out.println("Socket 연결");
        writeObj = new ObjectOutputStream(clientSocket.getOutputStream());
        readObj = new ObjectInputStream(clientSocket.getInputStream());
    }

    public void processData() {
        new Thread(()-> {
            while (!clientSocket.isClosed()) {
                try {
                    Data d = (Data) readObj.readObject();

                    if(d==null){
                        System.out.println("Client에 의한 접속 해제");
                        break;
                    }

                    System.out.println("데이터가 도착했습니다.");
                    System.out.println(d);

                    // TODO: 새로운 데이터 처리. 각 data가 dict에 있는지 살펴보고 key에 맞는 value로 바꾸어서 새로운 Data를 만든다.
                    // TODO: 새로운 Data 객체를 client에 다시 보내준다.

                    String k1 = d.getData1();
                    String k2 = d.getData2();
                    String k3 = d.getData3();
                    if(dict.containsKey(k1)){
                        k1 = dict.get(k1);
                    }
                    if(dict.containsKey(k2)){
                        k2 = dict.get(k2);
                    }
                    if(dict.containsKey(k3)){
                        k3 = dict.get(k3);
                    }
                    writeObj.writeObject(new Data(k1, k2, k3));
                    writeObj.flush();


                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Exception in readData");
                    break;
                }
            }
            try {
                writeObj.close();
                readObj.close();
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("processData Thread 종료");
        }).start();
        System.out.println("processData Thread 생성");
    }

    public static void main(String[] args) throws IOException {
        new DataServer();
    }
}
