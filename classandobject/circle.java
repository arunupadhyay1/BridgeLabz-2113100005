import java.util.Scanner;
public class circle{
private static double radius;
private static double pi=3.14;
public circle(double radius){
this.radius=radius;
}
public void AreaOfCircle(){
System.out.println("The area is :"+(pi*pi* radius));
}
public void CircumferenceOfCircle(){
System.out.println("The circumference is: "+(pi*2*radius) );

}
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
double rad = sc.nextDouble();
circle Circle1=new circle(rad);
System.out.println("The area and circumference of circle is");
Circle1.AreaOfCircle();
Circle1.CircumferenceOfCircle();

}

}