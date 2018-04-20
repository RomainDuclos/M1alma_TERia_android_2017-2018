public class RoundingJNI
{

	static {
		System.loadLibrary("RoundingLib");
	}

	public native void round_down(); //lance le code C/C++ de fesetround(down)
	public native void round_up(); //lance le code C/C++ de fesetround(up)

	public static double f()
	{
		return 10.0;
	}

	public static void main(String[] args)
	{
		new RoundingJNI().round_down();
		double x = 1.0 / f();
		new RoundingJNI().round_up();
		double y = 1.0 / f();
		boolean t = x==y;
		System.out.println(" x = y ? : " + t);
	}
	
}