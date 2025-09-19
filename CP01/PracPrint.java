public class Main{
	public static void main(String[] args) {
		//데이터 출력1
		System.out.print("Hello, this is JAVA.");
		
		//데이터 출력2
		System.out.println("Hello,");
		System.out.println("this is JAVA.");
		
		//데이터 출력3 --> java는 %를 쓴다.
		System.out.printf("Hello, this is JAVA.\n"
				+ "This is 20 years old.\n"
				+ "Integer: %d, Realnumber: %f\n"
				+ "Character: %c, String: %s", 10, 13.5, 'Z', "KING");
		
		//데이터 출력4 --> "출력은 \앞에, \출력은 \\(더플)
		System.out.println("\nABC\nDEF\n\tTAB\tTAB");
		System.out.println("Character is \"highlighted\".");
		System.out.println("\\\\\\Print three backslash");
	}
}