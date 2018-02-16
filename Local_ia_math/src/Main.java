public class Main
{
	public static void main(String argv[]) {

     RealInterval a,b,c,d,e;

     a = new RealInterval(5.0,5.1);
     b = new RealInterval(1.0,2.0);
     c = new RealInterval(0.36,0.899);
     d = new RealInterval(-1.0,1.0);

     System.out.println("a = " + a.b_toString());
     System.out.println("b = " + b.b_toString());
     System.out.println("c = " + c.b_toString());
     System.out.println("d = " + d.b_toString());

     e = IAMath.add(a , b);
     System.out.println("a+b= " + e.b_toString());
     
     e = IAMath.intersect(c , d);
     System.out.println("c inter d= "+ e.b_toString());
     
     e = IAMath.mul(a , c);
     System.out.println("a*c= "+ e.b_toString());
     
     e = IAMath.sin(a);
     System.out.println("sin(a)= "+ e.b_toString());
     
     e = IAMath.cos(b);
     System.out.println("cos(b)= "+ e.b_toString());
     
     e = IAMath.midpoint(d);
     System.out.println("midpoint(d)= "+ e.b_toString());
  }
}