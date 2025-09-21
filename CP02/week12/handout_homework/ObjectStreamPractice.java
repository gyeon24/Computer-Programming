package lab12_handout;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;


//아악 customer 파일이 없어어어어어

public class ObjectStreamPractice {

    private static List<CustomerVO> GetDefaultCustomers() {
        List<CustomerVO> customerList = new Vector<>();
        customerList.add(new CustomerVO("202400001", "광수", "202400001",
        		new AccountVO("광수", "202400001", AccountType.CHECKING, 100000000, Date.valueOf(LocalDate.now()))));
        customerList.add(new CustomerVO("202400002", "영철", "202400002",
                new AccountVO("영철", "202400002", AccountType.CHECKING, 10000000, Date.valueOf(LocalDate.now()))));
        customerList.add(new CustomerVO("202400003", "영숙", "202400003",
                new AccountVO("영숙", "202400003", AccountType.CHECKING, 5000000, Date.valueOf(LocalDate.now()))));
        customerList.add(new CustomerVO("202400004", "옥순", "202400004",
                new AccountVO("옥순", "202400004", AccountType.CHECKING, 1000000, Date.valueOf(LocalDate.now()))));
        return customerList;
    }

    public static void SaveCustomerFile(List<CustomerVO> customers, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(customers);
            System.out.println("Objects saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CustomerVO> ReadCustomerFile(String filePath) {
        // TODO: ObjectInputStream을 이용해 파일 경로 읽고 return
        List<CustomerVO> c = null;
        try(ObjectInputStream oi= new ObjectInputStream(new FileInputStream(filePath))){
            Object obj = oi.readObject();
            if(obj instanceof List<?>) {
            	c = (List<CustomerVO>) obj;
            	System.out.println(filePath);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        List<CustomerVO> customerList = GetDefaultCustomers();
        SaveCustomerFile(customerList, "customer.txt");  // customer.txt 파일을 열어서 내용 확인해보기

        List<CustomerVO> readCustomers = ReadCustomerFile("customer.txt");
        System.out.println(readCustomers);
    }
}
