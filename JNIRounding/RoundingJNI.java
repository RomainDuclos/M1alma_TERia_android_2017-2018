public class RoundingJNI
{

	static {
		System.loadLibrary("RoundingLib");
	}

	public native void round_down(); //lance le code C/C++ de fesetround(down)
	public native void round_up(); //lance le code C/C++ de fesetround(up)

	
	
}
