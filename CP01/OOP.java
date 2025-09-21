public class main{
    public static void main(String[] args){
        //prac1
        SmartPhone sp = new SmartPhone();
        
        sp.os = "Hello!";
        sp.color = "black";
        sp.volume = 6;
        
        System.out.println("Message: " + sp.os);
        System.out.println("Phone color: "+sp.color);
        System.out.println("Phone volume: "+sp.volume);
        
        //prac2
        SmartPhone sp1 = new SmartPhone();
        
        sp1.os = "iOS14";
        sp1.color = "gold";
        sp1.volume = 3;
        
        System.out.println("Phone1 OS: " + sp1.os);
        System.out.println("Phone1 color: "+sp1.color);
        System.out.println("Phone1 volume: "+sp1.volume);
        
        SmartPhone sp2 = new SmartPhone();
        
        sp2.os = "Android";
        sp2.color = "black";
        sp2.volume = 7;
        
        System.out.println("Phone2 OS: " + sp2.os);
        System.out.println("Phone2 color: "+sp2.color);
        System.out.println("Phone2 volume: "+sp2.volume);
        
        //prac3
        SmartPhone1 sp3 = new SmartPhone1();

        sp3.os = "Android";
        sp3.color = "black";
        sp3.volume = 5;
        sp3.size = 6.5;
        
        System.out.println("Phone size: " + sp3.size);
        System.out.println("Phone OS: " + sp3.os);
        System.out.println("Phone color: "+sp3.color);
        System.out.println("Phone volume: "+sp3.volume);
        System.out.println("Phone size: " + sp3.size);

        //prac4
        int[] a = {2,2,2,3,5};
        
        MyMath mm = new MyMath();
        System.out.println("int Result = " + mm.multiply(5,7));
        System.out.println("long Result = " + mm.multiply(2L, 3L));
        System.out.println("arr Result = " + mm.multiply(a));
    }
}

class SmartPhone{
    String os;
    String color;
    int volume;
}

class SmartPhone1{
    String os;
    String color;
    int volume;
    double size;
}

class MyMath {
    int multiply(int a, int b) {return a*b; }
    long multiply(long a, long b) {return a*b; }
    int multiply(int[] a) {
        int res = 1;
        for(int i=0;i<a.length;i++) {
            res = res*a[i];
        }
    return res;
    }           
}