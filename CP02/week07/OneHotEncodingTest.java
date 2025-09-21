package lab07;

public class OneHotEncodingTest {
	public static void main(String[] args) {

		String str = "Hello";
		StringOneHot soh = new StringOneHot(str);
		System.out.println("문자열: " + soh.getString());
		System.out.println("문자열 Set: " + soh.getStrSet());
		System.out.println("문자열 Map: "+ soh.getStrMap());
		System.out.println("문자열 One-hot 벡터: " + soh.getStrOneHotVec());

		System.out.println("One-hot 벡터로 나타낸 문자열 " + soh.getString());
		for(int i = 0; i < str.length(); i++) {
			System.out.print(soh.getString().charAt(i) + " = ");
			System.out.println(soh.getStrOneHotVec().get(str.substring(i, i+1)));
		}
	}
}
