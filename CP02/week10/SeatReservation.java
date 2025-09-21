package lab09_handout;

public class SeatReservation {
    public static void main(String[] args) {
        Reservation reserve = new Reservation();

        // TODO: 예약자1의 5좌석 예약을 위한 스레드 생성 및 시작
        Thread t1 = new Person(reserve, 5);
        t1.start();

        // TODO: 예약자2의 4좌석 예약을 위한 스레드 생성 및 시작
        Thread t2 = new Person(reserve,4);
        t2.start();

        // TODO: 예약자3의 2좌석 예약을 위한 스레드 생성 및 시작
        Thread t3 = new Person(reserve,2);
        t3.start();
    }
}

class Reservation {
    static int availableSeats = 10;        // 전체 좌석 수

    void reserveSeat(int requestedSeats) {
        // TODO: 여러 예약자가 동시에 좌석을 예약할 수 없도록 동기화(수정)
        synchronized (this) {
            System.out.println(requestedSeats + "가 들어왔음.");
            // TODO: 예약자 스레드 이름 출력

            System.out.println("가능한 좌석 수: " + availableSeats + ", 요청 좌석 수: " + requestedSeats);

        if (availableSeats >= requestedSeats)  {   // 예약 가능한 경우
            // TODO: 1초 대기
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                return;
            }



            System.out.println(requestedSeats + " 좌석이 예약되었음.");
            availableSeats = availableSeats - requestedSeats;
        }
        else {       // 예약 불가능한 경우
            System.out.println("좌석 예약이 불가능합니다.");
        }

        System.out.println(Thread.currentThread().getName()+"가 나갑니다."); // TODO: 예약자 스레드 이름 출력

        System.out.println("----------------------------------------------");
        }
    }
}

class Person extends Thread  {
    Reservation reserve;
    int requestedSeats;

    public Person(Reservation reserve, int requestedSeats) {
        this.reserve = reserve;
        this.requestedSeats = requestedSeats;
    }

    @Override
    public void run()  {      // TODO: 좌석 예약
        reserve.reserveSeat(requestedSeats);

    }
}
