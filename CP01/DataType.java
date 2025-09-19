public class Main{
	public static void main(String[] args) {
		//데이터 타입 1
		boolean a = true;
		boolean b = false;
		
		System.out.println(a);
		System.out.println(b);
		
		//데이터 타입 2
		char c = 'A';
		char d = 65;
		
		System.out.print(c+"\n"+d);
		System.out.println();
		
		//데이터 타입 3
		byte e = 10;
		short f = 300;
		int g = 100000;
		long h = 100000000000L; //long 타입은 끝에 L을 붙인다!
		
		System.out.print(e+"\n"+f+"\n"+g+"\n"+h);
		System.out.println();
		
		//데이터 타입 4
		float i = 1.2345679f; //float은 끝에 f를 붙인다!
		double j = 1.234567891234568;
		
		System.out.print(i+"\n"+j);
	}
}