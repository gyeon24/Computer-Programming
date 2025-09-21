import java.util.Scanner;

public class SeatReservation{
    public static Scanner input = new Scanner(System.in);
    public static int[] seats;
    
    private static void initSeat(int num){
        seats = new int[num];
        for(int i=0;i<num;i++) {
            seats[i] = 0;
        }
    }

    public static void main(String[] args) {
        final int size = 10;
        initSeat(size);
        question();
        System.out.println("프로그램을 종료합니다.");
    }

    private static void question() {
        System.out.print("좌석을 예약하시겠습니까?(y/n)");
        char selection;
        selection = input.next().charAt(0);
        if(selection == 'y') {
            viewCurrentSeat();
        } else if(selection == 'n'){
            return;
        }
    }

    private static void viewCurrentSeat() {
        System.out.println("현재 예약 상황(0: 빈 좌석, 1: 예약된 좌석)");
        System.out.println("------------------------------------");
        System.out.print("좌석번호: ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i+1)+" ");
        }
        System.out.println("\n------------------------------------");
        System.out.print("예약상태:");
        for(int i=0;i<seats.length;i++){
            System.out.print(seats[i]+" ");
        }
        System.out.println("\n------------------------------------");
        reservationMenu();
    }
    private static void reservationMenu() {
        int seatChoice;
        System.out.print("몇 번째 좌석을 예약하시겠습니까?(1~" + seats.length + ")");
        seatChoice = input.nextInt();
        seats[seatChoice-1] = 1;
        System.out.println(seatChoice+"번 좌석이 예약되었습니다.");
        question();
    }
}