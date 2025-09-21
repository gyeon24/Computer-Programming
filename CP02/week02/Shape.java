package week02;

import java.util.Arrays;

public abstract class Shape implements Comparable{
    public abstract double area();
    public abstract double perimeter();

    @Override
	public int compareTo(Object obj) {
        Shape compareObj = (Shape) obj;
        double area = this.area();
        double area2 = compareObj.area();

        if (area2 > area) {
            return -1;
        } else if (area2 < area) {
            return 1;
        } else {
        	return 0;
        }
    }
	public String toString() {
		return "도형의 종류: ";
	}

}