package lab07;


import java.util.*;

class Customer{
    static Random random = new Random();
    static HashSet<Integer> allIndexes=new HashSet<>();
    int customerNumber;

    public Customer(){
        int newIndex = random.nextInt(100);
        // TODO: allIndexes에 newIndex가 있는지 검사하고, 이미 포함하고 있다면 다른 index를 부여
       while(allIndexes.contains(newIndex)){
           newIndex = random.nextInt(100);
       }
       allIndexes.add(newIndex);
       customerNumber = newIndex;
    }

    public String toString(){
        return "고객 "+ customerNumber;
    }
}

public class FishBread {

    static Queue<Customer> customerQueue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numSuccess = 0;
        int finishAt = 5;

        while(true){
            int numCustomer = random.nextInt(4); // 한 번에 0~3 명의 고객이 주문

            if(customerQueue.size() == 0 && numCustomer == 0){  // 고객이 아무도 없을 경우 최소 1건의 주문이 생성됨
                numCustomer = 1;
            }

            System.out.println("-------------------------");
            for(int i=0;i<numCustomer;i++){
                Customer newCustomer = new Customer();
                System.out.println("새로운 "+newCustomer +" 가 붕어빵을 주문했습니다.");
                // TODO: 새로운 Customer를 처리
                customerQueue.add(newCustomer);
                Thread.sleep(1000);
            }
            if(numCustomer==0){
                System.out.println("아무도 붕어빵을 주문하지 않았습니다.");
            }

            System.out.println("누구에게 붕어빵을 줄까요? (현재 남은 인원:"+new HashSet<>(customerQueue)+"): "); // HashSet을 통해 현재 대기 중인 인원을 임의의 순서로 출력
            int giveNumber = scanner.nextInt(); // 사용자가 입력한 숫자 (예. 17)

            // TODO: 사용자가 입력한 숫자 (giveNumber)가 가장 먼저 주문한 Customer인지 확인 후,
            // TODO: 맞다면 붕어빵을 받아간 것에 대한 처리 (참고: numSuccess)
            // TODO: 아니라면, 실패 메시지 출력 후 종료 (System.exit(1))
            Customer first = customerQueue.poll();
            if(first != null && giveNumber == first.customerNumber){
                numSuccess++;
                System.out.println("Customer "+giveNumber+" (이)가 붕어빵을 받아갔습니다.");
            } else{
                System.out.println("실패");
                System.exit(1);
            }

            if(numSuccess >= finishAt){
                System.out.println("성공! 총 "+finishAt+" 명의 붕어빵 판매를 성공했습니다. 종료합니다.");
                System.exit(0);
            }
        }
    }
}
