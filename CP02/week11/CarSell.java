package lab10_handout;

import java.io.*;
import java.util.*;

class Car{
    String carType;
    int year;
    int mileage;
    String color;
    int price;

    Car(String carType, int year, int mileage, String color, int price){
        this.carType = carType;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.price = price;
    }

    public String toString(){
        return carType+" ("+year+") "+mileage+"km  색:"+color+" "+price+"만원";
    }
}

public class CarSell {
    @FunctionalInterface
    public interface CarPredicate{
        boolean test (Car car);
    }

    public static List<Car> filterCars(List<Car> inventory, CarPredicate p) {
        List<Car> result = new ArrayList<>();
        for(Car car: inventory) {
            if(p.test(car))  result.add(car);
        }
        return result;
    }

    @Deprecated
    static class MyCarPredicate implements CarPredicate{
        String carType;
        int year;
        int mileage;
        String color;
        int price;

        MyCarPredicate(String carType, int year, int mileage, String color, int price){
            this.carType = carType;
            this.year = year;
            this.mileage = mileage;
            this.color = color;
            this.price = price;
        }

        @Override
        public boolean test(Car c) {
            // TODO: 조건에 맞는 차량을 찾는다.
            //  (1) carType이 같아야 함 (equals 함수 활용)
            //  (2) mileage가 설정값보다 작아야 함
            //  (3) year가 설정 값보다 커야 함
            //  (4) color가 같아야 함
            //  (5) price가 설정 값보다 작아야 함
            // 향후 활용을 위해 되도록이면 한 줄로 표현하는 것이 좋다.
            return c.carType.equals(this.carType) &&
                    c.mileage < mileage &&
                    c.year > year &&
                    c.color.equals(color) &&
                    c.price < price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/lab10_week11/data.txt"));  // 파일을 읽어온다. 경로 설정 확인이 필요함.

        ArrayList<Car> cars = new ArrayList<>();
        String s;
        while((s = br.readLine())!=null){    // 데이터를 읽어서 모든 차량 데이터가 속해있는 ArrayList인 cars를 초기화한다.
            StringTokenizer stk = new StringTokenizer(s);

            String carType = stk.nextToken();
            int year = Integer.parseInt(stk.nextToken());
            // TODO: mileage, color, price를 StringTokenizer를 이용해 파싱하기.
            //  data.txt파일 내용도 잘 확인해보자.
            int mileage = Integer.parseInt(stk.nextToken());
            String color = stk.nextToken();
            int price = Integer.parseInt(stk.nextToken());

            cars.add(new Car(carType, year, mileage, color, price));
        }

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("찾으시는 차종은? (\"grandeur\", \"avante\", \"sonata\", \"morning\", \"K3\", \"K5\", \"K7\", \"K9\", \"SM3\", \"SM5\", \"SM6\", \"SM7\")");
            String carType = sc.nextLine();

            // TODO: 연식, 마일리지, 색상, 가격을 입력받기 위한 코드 작성
            System.out.println("몇년도이후의차량을찾으시나요? (예. 2015)");
            int year = sc.nextInt();

            System.out.println("최대주행거리는? (예. 100000) (단위km)");
            int mileage = sc.nextInt();

            System.out.println("원하는색상은? (\"white\", \"gray\", \"black\", \"blue\", \"green\", \"red\")");
            String color = sc.next();

            System.out.println("얼마이하의차량을찾으시나요? (예. 2000) (만원단위)");
            int price = sc.nextInt();

            MyCarPredicate mcp = new MyCarPredicate(carType, year, mileage, color, price);
            List<Car> filteredCars = filterCars(cars, mcp);
            Collections.sort(filteredCars, new Comparator<Car>() {
                @Override
                public int compare(Car c1, Car c2) {
                    return c1.price - c2.price;
                }
            });

            // TODO: 람다 식으로 표현 (1) filterCars를 람다식으로 표현,(2) sort 를 람다식으로 표현
            List<Car> filteredCars2 = filterCars(cars, c -> mcp.test(c));
            filteredCars2.sort((c1, c2) -> c1.price - c2.price);

            // TODO: 스트림 활용 filter, sort, toList 활용
            List<Car> filteredCars3 =cars.stream()
                    .filter(c -> c.carType.equals(carType) && c.mileage < mileage && c.color.equals(color) && c.price < price && c.year > year)
                    .sorted(Comparator.comparingInt(c -> c.price))
                    .toList();

            System.out.println("-----------------방법1-------------------");
            System.out.println("조건에 맞는 차 "+filteredCars.size()+" 대를 찾았습니다.");
            filteredCars.stream().forEach(System.out::println);

            System.out.println("-----------------방법2-------------------");
            System.out.println("조건에 맞는 차 "+filteredCars2.size()+" 대를 찾았습니다.");
            filteredCars2.stream().forEach(System.out::println);

            System.out.println("-----------------방법3-------------------");
            System.out.println("조건에 맞는 차 "+filteredCars3.size()+" 대를 찾았습니다.");
            filteredCars3.stream().forEach(System.out::println);

            // 모두 같은 결과가 나와야 함.
        }
    }
}
