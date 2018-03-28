package com.inter.romdu.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.math.RoundingMode;

import static java.math.RoundingMode.*;

/**
 * Created by romdu on 02/03/2018.
 */

public class Interval {

    //Pour le moment je laisse en public. A changer et passer pas des get
    double lo;
    double hi;

    public Interval()
    {
        this.lo = 0;
        this.hi = 0;
    }
    public Interval(double a, double b)
    {
        if(a<=b)
        {
            this.lo = a;
            this.hi = b;
        }
        else
        {
            EmptyInt();
        }
    }

    //Constructeur avec string
    public Interval(String a, String b)
    {
        BigDecimal blo = new BigDecimal(a, new MathContext(128,RoundingMode.FLOOR));
        BigDecimal bhi = new BigDecimal(b, new MathContext(128,RoundingMode.CEILING));
        lo = blo.doubleValue();
        hi = bhi.doubleValue();
        if (lo > hi)
        {
            EmptyInt();
        }
    }

    public boolean isEmpty()
    {
        if(lo > hi) {
            return true;
        }
        return false;
    }

    //Pour le moment je considère un intervalle vide comme ayant ses bornes croisés. C'est pas robuste du tout mais je garde comme ça le temps de tout écrire.
    //Je pense pour plus tard créer une classe emptyInterval et aussi jeter des exceptions...
    public void EmptyInt()
    {
        lo = 1.0;
        hi = 0.0;
    }

    //Pour le moment je m'en sers que dans les tests et du coup j'aurai du faire un mock mais bon.
    //Ca fait partie des choses à changer pour avoir un programme qui ressemble un peu plus à quelque chose
    public void set(double a, double b)
    {
        lo = a;
        hi = b;
    }
    public String toString() {
    /*
        DecimalFormat format = new DecimalFormat();
        format.setRoundingMode(FLOOR);
        String low = format.format(lo);
        format.setRoundingMode(CEILING);
        String hig = format.format(hi);
        return "[ " + low + " , " + hig + " ]";
    */
        return "[ " + Double.toString(lo) + " , " + Double.toString(hi) + " ]";

    }

    /*
    Méthodes to string tirées de jinterval et iamath
    public String b_toString()
    {
        return this.toString1();
    }

    private String toString1(){
        return(new String(
                "[" +
                        doubleToString(this.lo) +
                        " , " +
                        doubleToString(this.hi) +
                        "]"));
    }

    private String doubleToString(double x) {
        StringBuffer s = new StringBuffer((new Double(x)).toString());
        int i = s.length();
        int j;
        for(j=1;j<20-i;i++) s.append(' ');
        return(s.toString());
    }
    */
}
