package lab08_handout;

public class MyMath<T extends Number> {
    // TODO: generic 정의를 추가
    T[] numberArray;
	// TODO: 아래 함수를 구현
	public double getAverage(T[] numberArray){
        double sum = 0.0;
        for(T num : numberArray){
            sum += num.doubleValue();
        }
        return sum/numberArray.length;
	}

}
