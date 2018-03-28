package com.inter.romdu.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by romdu on 16/03/2018.
 */

public class MyTest {

   public static String fisrttest() {



       Interval a = new Interval(0, 1);
       Interval b = new Interval(1.6, 2.4);
       Interval c = new Interval(-2, 0.5);
       Interval d = new Interval(5.1, 6.1);

       String inte = "Tests de dépârts" + "\n" + "\n";

       inte = inte +  "Interval a = " + a.toString() + "\n" + "Interval b = " + b.toString() + "\n" + "Interval c = " + c.toString() + "\n" + "Interval d = " + d.toString() + "\n";

       Interval z = IMaths.add(a,b);
       String op = "add(a,b) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.sub(c,d);
       op = "sub(c,d) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.mul(a,d);
       op = "mul(a,d) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.div(b,c);
       op = "div(b,c) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.sqrt(a);
       op = "sqrt(a) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.exp(b);
       op = "exp(b) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.log(a);
       op = "log(a = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.pow(b,c);
       op = "pow(b,c) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.cos(d);
       op = "cos(d) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.sin(b);
       op = "sin(b) = " + z.toString();
       inte = inte + op + "\n";

       z = IMaths.tan(c);
       op = "tan(c) = " + z.toString();
       inte = inte + op + "\n";

       inte = inte + "\n" +  "Tests inspiré GAOL - JInterval" + "\n";

       z = IMaths.div(new Interval(-3.0,2.0),new Interval(4,5));
       inte = inte + z.toString();

       Interval k = new Interval("-5.2","3.8");
       inte = inte + "\n" + "Test avec string : "+ "\n" + k.toString();

       return inte;
   }
}
