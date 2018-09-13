import java.util.*;

public class Triangle
{
	public static void main(String[] args) {
		double x1, y1;
		double x2, y2;
		double x3, y3;

		Scanner input = new Scanner(System.in);

		System.out.println("Insert v1:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();

		System.out.println("Insert v2:");
		x2 = input.nextDouble();
		y2 = input.nextDouble();

		System.out.println("Insert v3:");
		x3 = input.nextDouble();
		y3 = input.nextDouble();

		double n1 = x3 - x2;
		double m1 = y3 - y2;

		double n2 = x3 - x1;
		double m2 = y3 - y1;

		double n3 = x2 - x1;
		double m3 = y2 - y1;

		double a = Math.sqrt(n1*n1 + m1*m1);
		double b = Math.sqrt(n2*n2 + m2*m2);
		double c = Math.sqrt(n3*n3 + m3*m3);

		System.out.println("a " + a + " b " + b + " c " + c);

		if(
			Math.abs((a + b) - c) < 1e-8 ||
		 	Math.abs((a + c) - b) < 1e-8 ||
		 	Math.abs((b + c) - a) < 1e-8)
		{
			System.out.println("Invalid triangle");
		}
		else
		{
			double A = Math.acos((a*a - b*b - c*c)/(-2*b*c)) / Math.PI *180;
			double B = Math.acos((b*b - a*a - c*c)/(-2*a*c)) / Math.PI *180;
			double C = Math.acos((c*c - b*b - a*a)/(-2*a*b)) / Math.PI *180;

			System.out.println("A " + A + " B " + B + " C " + C);
		}
	}
}