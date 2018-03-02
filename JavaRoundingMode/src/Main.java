import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.math.MathContext;
import java.math.BigDecimal;

public class Main
{
     public static double f()
     {
          return 10.0;
     }


	public static void main(String argv[]) {

     DecimalFormat format = new DecimalFormat();

     //Pour 1.0/10.0
     format.setRoundingMode(RoundingMode.FLOOR);
     double a = 1.0/f();

     format.setRoundingMode(RoundingMode.CEILING);
     double b = 1.0/f();
     
     System.out.println(a==b); //-> donne true...

     //Avec mon exemple de 5.1 + 1.1 
     format.setRoundingMode(RoundingMode.FLOOR);
     System.out.println(format.format(5.1+1.1)); // -> donne 6.199999...
     format.setRoundingMode(RoundingMode.CEILING);
     System.out.println(format.format(5.1+1.1)); // -> donne 6.2

     /*
     Mais en fait je me suis complètement trompé, 
     RoundindMode ici c'est juste pour la sortie avec format.format()...
     Du coup ca nous sert à rien je crois bien.
     */

     //Autre test (mais c'est pas vraiment ce qu'on veut je crois)
     a = Math.ceil(1.0/f());
     System.out.println(a);
     b = Math.floor(1.0/f());
     System.out.println(b);
     System.out.println(a==b); // -> false, les arrondis ce sont bien fait

     //Un dernier exemple mais ca va pas car c'est avec BigDecimal
     BigDecimal ba = new BigDecimal(1.0);
     BigDecimal resa = ba.divide(new BigDecimal(10.0),RoundingMode.FLOOR);
     System.out.println(resa.toString());

     BigDecimal bb = new BigDecimal(1.0);
     BigDecimal resb = bb.divide(new BigDecimal(10.0),RoundingMode.CEILING);
     System.out.println(resb.toString());

     System.out.println(resa.equals(resb)); // -> donne false

     /*
     J'ai cherché d'autres manières de faire mais je trouve pas pour le moment.
     Je m'étais pourtant dis avec MathContext que y'avait peut être moyen mais bon,
     j'ai pas trouvé grand chose pour le moment
     */




  }
}