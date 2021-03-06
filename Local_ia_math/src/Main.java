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

     RealInterval t = IAMath.add(new RealInterval(-1,1),new RealInterval(2,2));
     System.out.println("test [-1,1] + 2 = " + t.b_toString());

     RealInterval j = IAMath.my_add(a,b);
     System.out.println("test my_add(a,b) = " + j.b_toString());

     j = IAMath.my_addB(new RealInterval(5.1,6.1), new RealInterval(1.1,2.1));
     System.out.println("test my_add([5.1,6.1],[1.1,2.1] = " + j.b_toString());
     
     double tes = 5.1 + 1.1;
     System.out.println("5.1 + 1.1 = " + tes);
     tes = tes - 5.1;
     System.out.println("6.199999 - 5.1 = " + tes);
    // System.out.println(Math.nextDown(tes));
     System.out.println(5.1+1.1);
  }
}