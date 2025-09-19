public class Main {
    public static void main(String[] args) {
        //prac1
        int num1 = 5;
        int num2 = +num1;
        int num3 = -num1;
        System.out.println("num1 => " + num1);
        System.out.println("num2 => " + num2);
        System.out.println("num3 => " + num3);

        //prac2
        int num1 = 5;
        int num2 = 13;
        boolean led = true;
        
        System.out.println("logical value of led => " + led );
        System.out.println("reversal value of led => " + !led);
        System.out.println("result of num1>num2 : " + (num1 > num2));
        System.out.print("reversal result of num1>num2 : ");
        System.out.println(!(num1 > num2));

        //prac3
        int num1 = 5;
        int num2 = ++num1;
        
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        System.out.println("++num1 : " + ++num1);

        //prac4
        int num1 = 5;
        int num2 = num1++;
        
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        System.out.println("num1++ : " + num1++);

        //prac5
        int num1 = 30;
        
        System.out.println(num1++);
        System.out.println(++num1);
        System.out.println(num1--);
        System.out.println(--num1);
        System.out.println(num1++ + ++num1);

        //prac6
        byte num1 = 10;
        byte num2 = 20;
        
        byte num3 = (byte)(num1 + num2);
        
        System.out.print(num3);

        //prac7
        int num1 = 30;
        int num2 = 2;
        float num3 = 2.0f;
        
        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);
        System.out.println(num1/num3);
        System.out.println(num1%num2);

        //prac8
        float num1 = 10.f;
        float num2 = 3.0f;
        
        System.out.println(num1 / num2);
        System.out.println(num1%num2);

        //prac9
        char c1 = 'A';
        int n1 = c1;
        
        int n2 = c1 + 1;
        
        System.out.println(c1);
        System.out.println(n1);
        System.out.println(n2);

        //prac10
        char c = 'A';
        
        System.out.println(c++);
        System.out.println(c--);
        System.out.println(c);
        System.out.println(++c);
        System.out.println(--c);

        //prac11
        int num1 = 30;
        int num2 = 2;
        
        System.out.println(num1 == num2);
        System.out.println(num1>num2);
        System.out.println(num1<num2);
        System.out.println(num1>=num2);
        System.out.println(num1<=num2);
        System.out.println(num1 != num2);

        //prac12
        char c = 'A';
        int num = 10;
        
        System.out.println(c>10);
        System.out.println('1'>'0');
        System.out.println(num == 10f);

        //prac13
        int num1 = 30;
        int num2 = 2;
        
        System.out.println(num1 > 10 && num1 < 50);
        System.out.println(num1 < 10 && num1 < 50);
        System.out.println(num1 > 10 || num2 > 10);
        System.out.println(num1 < 10 || num2 > 10);

        //prac14
        int num1 = 5;
        int num2 = 3;
        
        System.out.println(5&3);
        System.out.println(5|3);
        System.out.println(5^3);
        System.out.println(~5);

        //prac15
        int num1 = 5;
        byte num2 = -5;
        
        System.out.println(num1<<1);
        System.out.println(num1<<3);
        System.out.println(num1>>1);
        System.out.println(num2>>1);
        System.out.println(num2>>>1);

        //prac16
        int num = 10;
        
        num+=5;
        System.out.println(num);
        num -=5;
        System.out.println(num);
        num *= 2;
        System.out.println(num);
        num /= 2;
        System.out.println(num);
        num %= 3;
        System.out.println(num);
        
        short snum1 = 20;
        short snum2 = 30;
        
        System.out.println(snum1 + snum2);
        
        num = snum1 = snum2;
        System.out.println("num = " + num);
        System.out.println("snum1 = " + snum1);
        System.out.println("snum2 = " + snum2);
    }
}