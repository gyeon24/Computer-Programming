public class Main{
    public static void main(String[] args){
        //prac1
        int score = 91;
        
        if (score >= 60){
            System.out.println("PASS");
        }

        //prac2
        int score = 51;
        
        if (score >= 60){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }

        //prac3
        int number = 21;
        
        if (number % 2==0){
            System.out.println("even number");
        } else{
            System.out.println("odd number");
        }

        //prac4
        int score = 91;
        
        if(score >= 90){
            System.out.println("A");
        } else if(score >= 80){
            System.out.println("B");
        } else{
            System.out.println("C");
        }

        //prac5
        int number = -13;
        
        if (number >0){
            System.out.println("positive number");
        } else if (number < 0){
            System.out.println("negative number");
        } else{
            System.out.println("0");
        }

        //prac6
        int score = 93;
        
        switch (score/10){
            case 10 :
                System.out.println("A");
                break;
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            default:
                System.out.println("C");
                break;
        }

        //prac7
        int score = 93;
        
        switch(score/10){
            case 10:
                System.out.println("A");
            case 9:
                System.out.println("A");
            case 8:
                System.out.println("B");
            default:
                System.out.println("C");
        }

        //prac8
        int score = 75;
        switch(score/10){
            case 10:
                System.out.println("A");
                break;
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
        }

        //prac9
        int num = 10;
        
        if(num>0){
            System.out.println("num is positive integer.");
        } else{
            if(num<0){
                System.out.println("num is negative integer.");
            }else {
                System.out.println("num is zero.");
            }
        }

        //prac10
        int num = 0;
        
        while(num<5){
            System.out.println(num);
            num++;
        }

        //prac11
        int num = 0;
        
        do{
            System.out.println(num);
            num++;
        } while (num < 5);

        //prac12
        for(int i = 0;i<5;i++){
            System.out.println(i);
        }

        //prac13
        int []numbers = {10,20,30};
        for(int value : numbers){
            System.out.print(value+" ");
        }

        //prac14
        String [] fruits = {"Apple", "Banana", "Pear", "Grape"};
        
        for(String name : fruits){
            System.out.print(name);
            System.out.print(", ");
        }
        System.out.println();

        //prac15
        int i = 1;
        
        while(i<10){
            int j=2;
            while(j<10){
                System.out.print(j + " x" + i + " = " + j*i + "\t");
                j++;
            }
            System.out.println();
            i++;
        }

        //prac16
        for(int i =1;i<10;i++){
            
            for (int j=2;j<10;j++){
                System.out.print(j + " x" + i + " = " + j*i + "\t");
        
            }
            System.out.println();
        }

        //prac17
        int num = 0;
        
        while(true){
            if(num==5){
                break;
            }
            System.out.println(num);
            
            num++;
        }
        
        //prac18
        int num = 0;
        
        while(++num < 10){
            if(num%2==1){
                continue;
            }
            System.out.println(num);
        }
    }
}