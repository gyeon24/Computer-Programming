package lab11_week12.handout_practice;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinary {
    public static void main(String[] args) {
        // 실습 2번
        // 주어진 data1.bin, data2.bin, data3.bin 파일을 읽어보자.
        // 모두 character로 읽으면 된다는 정보를 받았다.
        // DataInputStream 과 readChar() 함수를 사용해보자.
        // 파일의 끝까지 읽기 위해서 dis.available() 을 이용해보자.
        String[] a = {"D:/data1.bin", "D:/data2.bin", "D:/data3.bin"};

        for(String fileName : a){
            try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
                while(dis.available() > 0){
                    char b = dis.readChar();
                    System.out.print(b);
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
