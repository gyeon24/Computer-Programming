public class Main{
	public static void main(String[] args) {
        //prac1
		String str = "JAVA Program";
		System.out.println(str);

        //prac2
        float f1 = 9.1234567f;
        double d1 = (double)f1;
        
        System.out.printf("f1 = %20.18f\n", f1);
        System.out.printf("d1 = %20.18f\n", d1);
        System.out.println();
        
        double d2 = 9.1234567890123456789;
        float f2 = (float)d2;
        
        System.out.printf("d2 = %20.18f\n", d2);
        System.out.printf("f2 = %20.18f\n", f2);

        //prac3
        int a1 = 7;
        float b1 = (float) a1;
        int c1 = (int) b1;
        
        int a2 = 91234567;
        float b2 = (float) a2;
        int c2 = (int) b2;
        
        int a3 = 91234567;
        double b3 = (double) a3;
        int c3 = (int) b3;
        
        System.out.printf("c1 = %d\n", c1);
        System.out.printf("c2 = %d\n", c2);
        System.out.printf("c3 = %d\n", c3);

        //prac4
        float a1 = 9.1234567f;
        int b1 = (int) a1;
        float c1 = (float) b1;
        
        float a2 = 1.666f;
        int b2 = (int) a2;
        float c2 = (float) b2;
        
        double a3 = 1.666d;
        int b3 = (int) a3;
        double c3 = (double) b3;
        
        System.out.printf("c1 = %f\n", c1);
        System.out.printf("c2 = %f\n", c2);
        System.out.printf("c3 = %f\n", c3);

        //prac5
        char c1 = 'a';
        int n1 = 1;
        System.out.println(c1 + n1);
        int n2 = 10;
        float n3 = 10.0f;
        System.out.println(n2 + n3);
	}
}