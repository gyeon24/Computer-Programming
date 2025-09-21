public class main {
    public static void main(String[] args){
        //prac1
        Card c5 = new Card("CLOVER", 5);
        System.out.println(c5);
        
        Card d9 = new Card("DIAMOND", 9);
        System.out.println(d9);

        //prac2
        Time time = new Time(10,37,45);
        time.setHour(15);
        System.out.println(time);

        //prac3
        Singleton s2 = Singleton.getInstance();
        System.out.println("s2 value = " + s2.getValue());
        s2.setValue(15);
        System.out.println("s2 value = " + s2.getValue());
        Singleton s3 = Singleton.getInstance();
        System.out.println("s3 value = " + s3.getValue());
    }
}

//prac1
class Card{
    final String KIND;
    final int NUMBER;
    static int width = 50;
    static int height = 100;
    
    Card(String kind, int num)
    {
        KIND = kind;
        NUMBER = num;
    }
    public String toString() {
        return KIND + " " + NUMBER;
    }
}

//prac2
class Time{
    private int hour, minute, second;
    
    public Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    
    public int getHour() {return hour;}
    public void setHour(int hour) {
        if(hour < 0 || hour > 23) return;
        this.hour = hour;
    }
    public int getMinute() {return minute;}
    public void setMinute(int minute) {
        if(minute <0 || minute > 59) return;
        this.minute = minute;
    }
    public int getSecond() {return second;}
    public void setSecond(int second) {
        if(second<0 || second > 59) return;
        this.second = second;
    }
}

//prac3
class Singleton{
    private static Singleton s;
    private int value;
    
    private Singleton() {
        value = 5;
    }
    public static Singleton getInstance() {
        if(s == null)
            s = new Singleton();
        return s;
    }
    public void setValue(int a) {value = a;}
    public int getValue() {return value;}
}