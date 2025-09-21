public class main{
    public static void main(String[] args){
        //prac1
        int[] score = new int[5];
        
        score[0] = 50;
        score[1] = 60;
        score[2] = 70;
        score[3] = 80;
        score[4] = 90;
        
        for(int i =0;i<5;i++) {
            System.out.printf("score[%d]:%d%n", i, score[i]);
        }

        //prac2
        int[] arr1 = new int[10];
        for(int i =0;i<arr1.length;i++) {
            arr1[i] = i+1;
        }
        for(int i=0;i<arr1.length;i++) {
            System.out.print(arr1[i] + ",");
        }
        System.out.println();
        
        int[] arr2 = {100,95,90,80,70,60};
        System.out.println(Arrays.toString(arr2));
        
        char[] arr3 = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3);

        //prac3
        int[] arr1 = new int[5];
        
        for(int i =0;i<arr1.length;i++)
            arr1[i] = i+1;
        
        System.out.println("before - arr.length:"+arr1.length);
        for(int i =0;i<arr1.length;i++)
            System.out.println("arr["+i+"]:"+arr1[i]);
        
        int[] tmp = new int[arr1.length*2];
        
        for(int i=0;i<arr1.length;i++) {
            tmp[i] = arr1[i];
        }
        arr1=tmp;
        
        System.out.println("after - arr.length:"+arr1.length);
        for(int i=0;i<arr1.length;i++) {
            System.out.println("arr["+i+"]:"+arr1[i]);
        }

        //prac4
        char[] abc = {'A','B','C','D'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        System.out.println(abc);
        System.out.println(num);
        
        char[] arr = new char[abc.length+num.length];
        System.arraycopy(abc, 0, arr, 0, abc.length);
        System.arraycopy(num, 0, arr, abc.length, num.length);
        System.out.println(arr);
        
        System.arraycopy(abc, 0, num, 0, abc.length);
        System.out.println(num);
        
        System.arraycopy(abc, 0, num, 6, 3);
        System.out.println(num);

        //prac5
        int[] score = {};
        for(int i =0;i<5;i++) {
            System.out.println("null");
        }
        boolean[] boolArray = new boolean[5];
        System.out.println(boolArray[0]);
        System.out.println(boolArray[1]);
        System.out.println(boolArray[2]);
        System.out.println(boolArray[3]);
        System.out.println(boolArray[4]);
    }
}