public class main{
    public static void main(String[] args){
        //prac1
        Point p1 = new Point(5,5);
        Point p2 = new Point(15,15);
        Circle c = new Circle(p2, 7);
        Rectangle r = new Rectangle(p1,p2);
        
        c.draw();
        r.draw();

        //prac2
        Parent parent = new Parent();
        Child child = new Child();

        parent.parentMethod();
        child.parentMethod();
        child.parentMethod(14);
        child.childMethod();
        child.childMethod(12);

        //prac3
        Child2 child2 = new Child2();
        child2.printMethod();

        //prac4
        Point2 point2 = new Point2(1,2);
        Point3D point3D = new Point3D(2,3,4);
        
        System.out.println(point2.getCoordinates());
        System.out.println(point3D.getCoordinates());

        //prac5
        Point3D_2 p3D = new Point3D_2(5,7,9);
        System.out.println(p3D.getCoordinates());

        //prac6
        Point3D_3 p3D_2 = new Point3D_3(5,7,9);
        System.out.println(p3D_2.getCoordinates());
    }
}

//prac1
class Shape{
    String color = "green";
    
    void draw() {
        System.out.println("draw a shape!");
    }
}

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Circle extends Shape{
    Point center;
    int r;
    
    Circle(Point center, int r){
        this.center = center;
        this.r = r;
    }
    
    void draw() {
        System.out.println("draw a circle!");
    }
}

class Rectangle extends Shape{
    Point lt;
    Point rb;
    
    Rectangle(Point lt, Point rb){
        this.lt = lt;
        this.rb = rb;
    }
    void draw() {
        System.out.println("draw a rectangle!");
    }
}

//prac2
class Parent{
        void parentMethod() {
            System.out.println("parent's parentMethod()");
        }
}

class Child extends Parent{
    void parentMethod() {
        System.out.println("child's parentMethod()");
    }
    
    void parentMethod(int x) {
        System.out.printf("child's parentMethod(int %d)\n", x);
    }
    
    void childMethod() {
        System.out.println("child's childMethod()");
    }
    
    void childMethod(int a) {
        System.out.printf("child's childMethod(int %d)\n", a);
    }
}

//prac3
class Parent2{
    int i = 100;
}

class Child2 extends Parent2{
    int i = 500;
    
    void printMethod() {
        System.out.println("i = "+ i);
        System.out.println("this.i = "+ this.i);
        System.out.println("super.i = "+ super.i);        
        
    }
}

//prac4
class Point2{
    int x;
    int y;
    
    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    String getCoordinates() {
        return "x: " + x + ", y: "+y;
    }
}

class Point3D extends Point2{
    int z;
    
    Point3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }
    
    String getCoordinates() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}

//prac5
class Point3{
    int x;
    int y;
    
    Point3(){
        this(0,0);
    }
    Point3(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    String getCoordinates() {
        return "x: " + x + ", y: "+y;
    }
}

class Point3D_2 extends Point3{
    int z;
    
    Point3D_2(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    String getCoordinates() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}

//prac6

class Point4{
    int x;
    int y;
    
    Point4(){
        this(0,0);
    }
    Point4(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    String getCoordinates() {
        return "x: " + x + ", y: "+y;
    }
}

class Point3D_3 extends Point4{
    int z;
    
    Point3D_3(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    String getCoordinates() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}