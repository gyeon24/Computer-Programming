import java.util.*;

public class Main{
	public static void main(String[] args) {
		System.out.print("스캐너 연습:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Hello, Mr."+name);
		sc.close();
	}
}