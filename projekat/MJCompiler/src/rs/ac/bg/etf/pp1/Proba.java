package rs.ac.bg.etf.pp1;

public class Proba {

	private static int x = 0;
	private static int a = 3;
	private static int b = 3;
	private static int c = 4;
	public static void main(String[] args) {
		x = a *= b += (c *= 3);
		System.out.println(x);
		x = 0;
		a = 2;
		b = 3;
		c = 4;
		b += c;
		//x = a * b += c;
	}
	
}
