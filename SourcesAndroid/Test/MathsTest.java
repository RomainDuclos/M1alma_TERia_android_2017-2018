package com.inter.romdu.test;

import org.junit.Test;
import com.inter.romdu.test.IMaths;

import static org.junit.Assert.*;


public class MathsTest {

    Interval a = new Interval();
    Interval b = new Interval();
    Interval r = new Interval();

    @Test
    public void add_isCorrect() throws Exception {
        a.set(3.0,4.0);
        b.set(-6.0,2.0);
        r = IMaths.add(a,b);
        assertEquals(-3.0,r.lo,0.0);
        assertEquals(6.0,r.hi,0.0);

        a.set(3.0,4.0);
        b.set(3.0,4.0);
        r = IMaths.add(a,b);
        assertEquals(6.0,r.lo,0.0);
        assertEquals(8.0,r.hi,0.0);

        a.set(3.5,4.5);
        b.set(-2.8,2.3);
        r = IMaths.add(a,b);
        assertEquals(3.5+(-2.8),r.lo,0.0);
        assertEquals(4.5+2.3,r.hi,0.0);
    }

    @Test
    public void sub_isCorrect() throws Exception {
        a.set(3.0,4.0);
        b.set(-6.0,2.0);
        r = IMaths.sub(a,b);
        assertEquals(1.0,r.lo,0.0);
        assertEquals(10.0,r.hi,0.0);

        a.set(3.0,4.0);
        b.set(3.0,4.0);
        r = IMaths.sub(a,b);
        assertEquals(-1.0,r.lo,0.0);
        assertEquals(1.0,r.hi,0.0);

        a.set(3.5,4.5);
        b.set(-2.8,2.3);
        r = IMaths.sub(a,b);
        assertEquals(3.5-2.3,r.lo,0.0);
        assertEquals(4.5-(-2.8),r.hi,0.0);
    }

    @Test
    public void mul_isCorrect() throws Exception {
        // P P
        a.set(4.0,5.0);
        b.set(2.0,3.0);
        r = IMaths.mul(a,b);
        assertEquals(8.0,r.lo,0.0);
        assertEquals(15.0,r.hi,0.0);

        // P M
        a.set(4.0,5.0);
        b.set(-2.0,3.0);
        r = IMaths.mul(a,b);
        assertEquals(-10.0,r.lo,0.0);
        assertEquals(15.0,r.hi,0.0);

        // P N
        a.set(4.0,5.0);
        b.set(-3.0,-2.0);
        r = IMaths.mul(a,b);
        assertEquals(-15.0,r.lo,0.0);
        assertEquals(-8.0,r.hi,0.0);

        // M P
        a.set(-3.0,-2.0);
        b.set(4.0,5.0);
        r = IMaths.mul(a,b);
        assertEquals(-15.0,r.lo,0.0);
        assertEquals(-8.0,r.hi,0.0);

        // M M
        a.set(-3.0,2.0);
        b.set(-4.0,5.0);
        r = IMaths.mul(a,b);
        assertEquals(-15.0,r.lo,0.0);
        assertEquals(12.0,r.hi,0.0);

        // M N
        a.set(-3.0,2.0);
        b.set(-5.0,-4.0);
        r = IMaths.mul(a,b);
        assertEquals(-10.0,r.lo,0.0);
        assertEquals(15.0,r.hi,0.0);

        // N P
        a.set(-3.0,-2.0);
        b.set(4.0,5.0);
        r = IMaths.mul(a,b);
        assertEquals(-15.0,r.lo,0.0);
        assertEquals(-8.0,r.hi,0.0);

        // N M
        a.set(-3.0,-2.0);
        b.set(-4.0,5.0);
        r = IMaths.mul(a,b);
        assertEquals(-15.0,r.lo,0.0);
        assertEquals(12.0,r.hi,0.0);

        // N N
        a.set(-3.0,-2.0);
        b.set(-5.0,-4.0);
        r = IMaths.mul(a,b);
        assertEquals(8.0,r.lo,0.0);
        assertEquals(15.0,r.hi,0.0);
    }

    @Test
    public void div_isCorrect() throws Exception {
        //Je n'ai pas pris l'intégralité des tests de div de GAOL pour le moment (manque des cas)
        a.set(3.0,5.0);
        b.set(0.0,0.0);
        r = IMaths.div(a,b);
        //Intervalle vide pour moi [1,0]
        assertEquals(1.0,r.lo,0.0);
        assertEquals(0.0,r.hi,0.0);

        a.set(-3.0,-2.0);
        b.set(-5.0,-4.0);
        r = IMaths.div(a,b);
        assertEquals(0.4,r.lo,0.0);
        assertEquals(0.75,r.hi,0.0);

        a.set(-3.0,-2.0);
        b.set(-4.0,0.0);
        r = IMaths.div(a,b);
        assertEquals(0.5,r.lo,0.0);
        assertEquals(Double.POSITIVE_INFINITY,r.hi,0.0);

        a.set(-3.0,-2.0);
        b.set(-4.0,5.0);
        r = IMaths.div(a,b);
        assertEquals(Double.NEGATIVE_INFINITY,r.lo,0.0);
        assertEquals(Double.POSITIVE_INFINITY,r.hi,0.0);

        a.set(-3.0,-2.0);
        b.set(0.0,0.4);
        r = IMaths.div(a,b);
        assertEquals(Double.NEGATIVE_INFINITY,r.lo,0.0);
        assertEquals(-5.0,r.hi,0.0);

        a.set(-3.0,-2.0);
        b.set(4.0,5.0);
        r = IMaths.div(a,b);
        assertEquals(-0.75,r.lo,0.0);
        assertEquals(-0.4,r.hi,0.0);

        a.set(-3.0,2.0);
        b.set(4.0,5.0);
        r = IMaths.div(a,b);
        assertEquals(-0.75,r.lo,0.0);
        assertEquals(0.5,r.hi,0.0);

        a.set(0.0,2.0);
        b.set(-5.0,-4.0);
        r = IMaths.div(a,b);
        assertEquals(-0.5,r.lo,0.0);
        assertEquals(0.0,r.hi,0.0);

        a.set(0.0,2.0);
        b.set(4.0,5.0);
        r = IMaths.div(a,b);
        assertEquals(0.0,r.lo,0.0);
        assertEquals(0.5,r.hi,0.0);

        a.set(2.0,3.0);
        b.set(-5.0,-4.0);
        r = IMaths.div(a,b);
        assertEquals(-0.75,r.lo,0.0);
        assertEquals(-0.4,r.hi,0.0);

        //TODO : autres cas

    }

    @Test
    public void sqrt_isCorrect() throws Exception {
        a.set(1.0,0.0);
        r = IMaths.sqrt(a);
        assertEquals(1.0,r.lo,0.0);
        assertEquals(0.0,r.hi,0.0);

        a.set(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        r = IMaths.sqrt(a);
        assertEquals(0.0,r.lo,0.0);
        assertEquals(Double.POSITIVE_INFINITY,r.hi,0.0);

        a.set(1.0,0.0);
        r = IMaths.sqrt(a);
        assertEquals(1.0,r.lo,0.0);
        assertEquals(0.0,r.hi,0.0);

        a.set(2.0,3.0);
        r = IMaths.sqrt(a);
        assertEquals(1.414213562373095,r.lo,0.0);
        assertEquals(1.7320508075688774,r.hi,0.0); //c'est moi qui ai rajouté le 4 à la fin

      //  TEST_EQ(sqrt(interval(-3,2)),interval("[0,1.414213562373096]"));
        a.set(-3.0,2.0);
        r = IMaths.sqrt(a);
        assertEquals(0.0,r.lo,0.0);
        assertEquals(1.4142135623730951,r.hi,0.0); //-> ben la précision est pas la même, qu'est ce que je prends ? :/

     //   TEST_EQ(sqrt(interval(-2,3)),interval("[0,1.732050807568877]"));
        a.set(-2.0,3.0);
        r = IMaths.sqrt(a);
        assertEquals(0.0,r.lo,0.0);
        assertEquals(1.7320508075688774,r.hi,0.0); //-> le 4
    }

    @Test
    public void pow_isCorrect() throws Exception {

        // /!\ Mon powDn/Up est tout cassé, je dois y revenir.
        /*
        //TEST_SEQ(pow(interval::universe(),interval::zero()),interval::one());
        a.set(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        b.set(0.0,0.0);
        r = IMaths.pow(a,b);
        assertEquals(1.0,r.lo,0.0);
        assertEquals(1.0,r.hi,0.0);

        //TEST_EQ(pow(interval(3,4),interval(2,3)),interval(9,64));
        a.set(3.0,4.0);
        b.set(2.0,3.0);
        r = IMaths.pow(a,b);
        assertEquals(9.0,r.lo,0.0);
        assertEquals(64.0,r.hi,0.0);

        // -> ca c'est du pown DONC FAUT PAS LE METTRE DANS POW
        //TEST_SEQ(pow(interval::zero(),0),interval::one());
        a.set(0.0,0.0);
        b.set(0.0,0.0);
        r = IMaths.pown(a,0);
        assertEquals(1.0,r.lo,0.0);
        assertEquals(1.0,r.hi,0.0);
/*
        a.set(-3.0,-2.0);
        b.set(-2.0,-2.0);
        r = IMaths.my_pow(a,b);
        assertEquals(0.11111111,r.lo,0.0);
        assertEquals(0.25,r.hi,0.0);
       /*

        CPPUNIT_ASSERT(pow(interval::emptyset(),3).is_empty());
        TEST_EQ(pow(interval(-3,-2),-2),interval("[0.111111111,0.25]"));
        TEST_EQ(pow(interval(-3,-2),-1),interval("[-0.5,-0.333333333]"));
        TEST_SEQ(pow(interval(-3,-2),0),interval::one());
        TEST_EQ(pow(interval(-3,-2),1),interval(-3,-2));
        TEST_EQ(pow(interval(2,3),-1),interval("[0.333333333,0.5]"));
        TEST_SEQ(pow(interval(2,3),0),interval::one());
        TEST_EQ(pow(interval(2,3),1),interval(2,3));
        TEST_PEQ(pow(interval(-3,2),-2),interval("[0.1111111111,+inf]"));
        TEST_SEQ(pow(interval(-3,2),-1),interval::universe());
        TEST_SEQ(pow(interval(-3,2),0),interval::one());
        TEST_EQ(pow(interval(-3,2),1),interval(-3,2));
        TEST_EQ(pow(interval(-2,3),1),interval(-2,3));
        TEST_EQ(pow(interval(-2,3),2),interval(0,9));
        TEST_EQ(pow(interval(-2,3),3),interval(-8,27));
        TEST_EQ(pow(interval(-2,3),4),interval(0,81));

        TEST_CONT(pow(interval(-15,-15),17),-98526125335693359375.0);
        */
        //TODO : plus de cas
    }

    @Test
    public void exp_isCorrect() throws Exception {
        /*
        TEST_EMPTY(exp(interval::emptyset()));
    TEST_EQ(exp(interval::zero()),interval::one());
    TEST_EQ(exp(interval::one()),interval("2.7182818284590452"));
    TEST_SEQ(exp(interval(740.0)),interval(std::numeric_limits<double>::max(),GAOL_INFINITY));
    TEST_EQ(exp(interval(-800.0)),interval::zero());
    TEST_EQ(exp(interval(-10.0,-5.0)),interval("[4.53999297624848e-5,6.7379469990855e-3]"));
    TEST_EQ(exp(interval(-5.0,9.0)),interval("[6.7379469990854e-3,8103.0839275754]"));
    TEST_EQ(exp(interval(9.0,11.0)),interval("[8103.0839275754,59874.14171519782]"));
    TEST_EQ(exp(interval(-3.5)),interval("3.01973834223185e-2"));
    TEST_EQ(exp(interval(3.5)),interval("33.1154519586923"));
	CPPUNIT_ASSERT(exp(m_inf_m_max).certainly_positive());
         */
    }

    @Test
    public void log_isCorrect() throws Exception {
        /*
        TEST_SEQ(log(interval(-4.0,0.0)),interval(-GAOL_INFINITY,-std::numeric_limits<double>::max()));
        TEST_EMPTY(log(interval::emptyset()));
        interval tmp = log(interval(-3,4));
        CPPUNIT_ASSERT(tmp.left()==-GAOL_INFINITY && (tmp.right()-1.386294361119891)<=1e-8);
        TEST_EQ(log(interval(5,9)),interval(1.6094379124341003746,2.19722457733621938279));
        TEST_EQ(log(interval("56.1")),interval("4.02713581252865063169"));
    */
    }

    @Test
    public void sin_isCorrect() throws Exception {


    }

    @Test
    public void cos_isCorrect() throws Exception {
        /*
        TEST_EMPTY(cos(interval::emptyset()));

        TEST_PEQ(cos(interval(-1,-0.5)),interval("[0.540302305868139, 0.877582561890373]"));
        TEST_SEQ(cos(interval(-10,10)),interval(-1,1));
        TEST_SEQ(cos(interval::universe()),interval(-1,1));
        TEST_EQ(cos(interval::pi()),interval(-1,-1));

        TEST_EQ(cos(interval(3,3.5)),interval("[-1,-0.936456687290796]"));
        TEST_EQ(cos(interval(-3.5,-3)),interval("[-1,-0.936456687290796]"));
        TEST_EQ(cos(interval(-3.5,3)),interval(-1,1));
        TEST_EQ(cos(interval(10,12)),interval("[-0.839071529076452,0.843853958732493]"));
        TEST_EQ(cos(interval(13,14)),interval("[0.136737218207833,0.907446781450197]"));
        TEST_EQ(cos(interval(10,14)),interval("[-0.839071529076452,1]"));
        TEST_EQ(cos(interval(14,16)),interval("[-1,0.136737218207833]"));
        TEST_EQ(cos(interval(-11,-10)),interval("[-0.839071529076452,0.004425697988051]"));
        TEST_EQ(cos(interval(-14,-13)),interval("[0.136737218207833,0.907446781450197]"));
        TEST_EQ(cos(interval(-16,-14)),interval("[-1,0.136737218207833]"));
        TEST_EQ(cos(interval(-102,-100)),interval("[0.101585703696621,1]"));
        TEST_EQ(cos(interval(4.6e15,4.7e15)),interval(-1,1));
    */
    }

    @Test
    public void tan_isCorrect() throws Exception {
        /*
        TEST_EMPTY(tan(interval::emptyset()));
 	TEST_SEQ(tan(interval::universe()),interval::universe());
	TEST_EQ(tan(interval(0,1)),interval(0,1.55740772465490223051));
	TEST_EQ(tan(interval(-1,0)),interval(-1.55740772465490223051,0));
	TEST_EQ(tan(interval(-2,-1)),interval::universe());
	TEST_EQ(tan(interval(202,203)),interval::universe());
         */
    }

    @Test
    public void asin_isCorrect() throws Exception {

    }

    @Test
    public void acos_isCorrect() throws Exception {

    }

    @Test
    public void atan_isCorrect() throws Exception {

    }
}
