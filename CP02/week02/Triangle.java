package week02;

public class Triangle extends Shape {
	private double side;

	public Triangle(double side) {
		this.side = side;
	}

	@Override
	public double area() {
		return (Math.sqrt(3) / 4) * side * side;
	}

	@Override
	public double perimeter() {
		return 3 * side;
	}

	@Override
	public String toString() {
		return super.toString() + "삼각형, " + "둘레: " + String.format("%.2f", perimeter()) + "cm, "
				+ "넓이: " + String.format("%.2f", area()) + "㎠";
	}
}