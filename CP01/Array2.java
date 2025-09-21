import java.util.*;

public class main{
    public static void main(String[] args){
        //prac1
        String src = "ABCDE";
    
        for(int i =0;i<src.length();i++) {
            char ch = src.charAt(i);
            System.out.println("src.charAt(" + i + "):"+ch);
        }
        char[] chArr = src.toCharArray();
        System.out.println(chArr);

        //prac2
        String[] names = {"Kim", "Park", "Yi"};
    
        for(int i = 0;i<names.length;i++) {
            System.out.println("names["+i+"]:"+names[i]);
        }
        String tmp = names[2];
        System.out.println("tmp:"+tmp);
        names[0] = "Yu";
        for(String str : names) {
            System.out.println(str);
        }

        //prac3
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().split(",");
    
        System.out.println("arr length:"+arr.length);
    
        for(int i=0;i<arr.length;i++) {
            System.out.println("arr["+i+"] = \""+arr[i]+"\"");
        }

        //prac4
        Scanner sc = new Scanner(System.in);
    
        int num1 = sc.nextInt();
        char op = sc.next().charAt(0);
        int num2 = sc.nextInt();
    
        sc.close();
    
        int result = 0;
    
        switch(op) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case 'x':
            result = num1*num2;
            break;
        case '/':
            result = num1/num2;
            break;
        default :
            System.out.print("False");
        }
        System.out.println("result : " + result);

        //prac5
        int[][]score = {
            {100,100,100},
            {20,20,20},
            {30,30,30},
            {40,40,40},
        };
        int sum = 0;
    
        for(int i=0;i<score.length;i++) {
            for(int j =0;j<score[i].length;j++) {
                System.out.printf("score[%d][%d]=%d%n",i,j,score[i][j]);
            }
        }
        for(int[] tmp : score) {
            for(int i :tmp) {
                sum += i;
            }
        }
        System.out.println("sum="+sum);
    }
}