public class main{
    public static void main(String[] args){
        //prac1
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;
        
        fe.water();
        car = fe;
        fe2 = (FireEngine) car;
        fe2.water();

        //prac2
        Tv t1 = new Tv();
        CaptionTV t2 = new CaptionTV();
        Tv t3 = new CaptionTV();
        ((CaptionTV) t3).caption();

        //prac3
        Buyer b= new Buyer();
        
        Tv2 tv2 = new Tv2();
        Computer com = new Computer();
        b.buy(tv2);
        System.out.println("After buy Tv : " + b.money + " " + b.bonusPoint);
        b.buy(com);
        System.out.println("After buy Computer : "+ b.money + " "+b.bonusPoint);

        //prac4
        Parent p= new Child();
        Child c = new Child();
        
        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = "+ c.x);
        c.method();
    }
}

//prac1
class Car{
    String color;
    int door;
    void drive() {
        System.out.println("drive");
    }
    void stop() {
        System.out.println("stop");
    }
}

class FireEngine extends Car{
    void water() {
        System.out.println("water");
    }
}

class Ambulance extends Car{
    void siren() {
        System.out.println("siren");
    }
}

//prac2
class Tv{
    boolean power;
    int channel;
    
    void power() {
        power = !power;
        }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}

class CaptionTV extends Tv{
    String text;
    void caption() {
        System.out.println("caption");
    }
}

//prac3
class Product{
    int price;
    int bonusPoint;
    Product(int price){
        this.price = price;
        this.bonusPoint = (int)(price * 0.01);
    }
}

class Tv2 extends Product{
    Tv(){
        super(400000);
    }
}
class Computer extends Product{
    Computer() {
        super(600000);
    }
}

class Buyer{
    int money = 1000000;
    int bonusPoint = 0;
    
    void buy(Product p) {
        money -= p.price;
        bonusPoint += p.bonusPoint;
    }
}

//prac4
class Parent{
    int x = 100;
    void method(){
        System.out.println("Parent");
    }
}

class Child extends Parent{
    int x = 200;
    void method(){
        System.out.println("Child");
    }
}