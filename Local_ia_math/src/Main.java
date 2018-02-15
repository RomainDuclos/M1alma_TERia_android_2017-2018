public class Main
{
	public static void main(String argv[]) {

     RealInterval a,b,c,d,e;

     a = new RealInterval(5,5.1);
     b = new RealInterval(1,2);
     c = new RealInterval(0.36,0.899);
     d = new RealInterval(-1,1);

     System.out.println("a= "+a);
     System.out.println("b= "+b);
     System.out.println("c= "+c);
     System.out.println("d= "+d);

     e = IAMath.add(a , b);
     System.out.println("a+b= "+ e);
     
     e = IAMath.intersect(c , d);
     System.out.println("c inter d= "+ e);
     
     e = IAMath.mul(a , c);
     System.out.println("a+b= "+ e);
     
     e = IAMath.sin(a);
     System.out.println("sin(a)= "+ e);
     
     e = IAMath.cos(b);
     System.out.println("cos(b)= "+ e);
     
     e = IAMath.midpoint(d);
     System.out.println("midpoint(d)= "+ e);
  }
}