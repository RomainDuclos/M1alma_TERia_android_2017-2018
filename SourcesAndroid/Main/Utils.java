package com.inter.romdu.test;


public class Utils {

    static final double piHalfInf = Math.PI / 2;
    static final double piHalfSup = Math.nextUp(Math.PI / 2);

    public static double nextDn(double x) {
        return -Math.nextUp(-x);
    }

    public static double nextUp(double x) {
        return Math.nextUp(x);
    }

    public static double addDn(double x, double y) {
        double r = x + y;
        return r - x > y || r - y > x ? nextDn(r) : r;
    }

    public static double addUp(double x, double y) {
        double r = x + y;
        return r - x < y || r - y < x ? nextUp(r) : r;
    }

    public static double subUp(double x, double y) {
        double r = x - y;
        return x - r > y || r + y < x ? nextUp(r) : r;
    }

    public static double subDn(double x, double y) {
        double r = x - y;
        return x - r < y || r + y > x ? nextDn(r) : r;
    }

    public static double mulUp(double x, double y)
    {
        /*
        long xbits = Double.doubleToRawLongBits(x);
        long ybits = Double.doubleToRawLongBits(y);
        int xexp = (int) (xbits >>> 52);
        int yexp = (int) (ybits >>> 52);
        double z = x * y;
        if (xexp != 0 && xexp < 0x7ff && yexp != 0 && yexp < 0x7ff) {
            long zbits = Double.doubleToRawLongBits(z);
            int zexp = (int) (zbits >>> 52);
            if (zexp != 0 && zexp < 0x7ff) {
                long xsig = (1L << 52) | (xbits & ((1L << 52) - 1));
                long ysig = (1L << 52) | (ybits & ((1L << 52) - 1));
                long prod = xsig * ysig;
                int dexp = zexp - xexp - yexp;
                if (dexp == -1023) {
                    // drop 52 bits
                    prod = prod & ((1L << 53) - 1);
                    if (prod > 0 && prod <= (1L << 51)
                            || prod > (2L << 51) && prod < (3L << 51)) {
                        z = nextUp(z);
                    }
                } else {
                   // assert dexp == -1022;
                    // drop 53 bits
                    prod = prod & ((1L << 54) - 1);
                    if (prod > 0 && prod <= (1L << 52)
                            || prod > (2L << 52) && prod < (3L << 52)) {
                        z = nextUp(z);
                    }
                }
                return z;
            }
        } else if (x == 0 || y == 0) {
            return z;
        }

        return ceil64.mul(ExtendedRational.valueOf(x), ExtendedRational.valueOf(y)).doubleValue();
        */

        /*
        if ((x==0.0)||(y==0.0)) return(0.0);
        return(nextUp(x*y));
        */

        if ((x==0.0)||(y==0.0))
        {
            return(0.0);
        }
        else
        {
            double r = x * y;
            if(r / x < y ||r / y < x)
            {
                return nextUp(r);
            }

            return r;
        }
    }

    //private static final ExtendedRationalContext floor64 = ExtendedRationalContexts.mkFloor(BinaryValueSet.BINARY64);
    //private static final ExtendedRationalContext ceil64 = ExtendedRationalContexts.mkCeiling(BinaryValueSet.BINARY64);

    public static double mulDn(double x, double y)
    {
        /*
        long xbits = Double.doubleToRawLongBits(x);
        long ybits = Double.doubleToRawLongBits(y);
        int xexp = (int) (xbits >>> 52);
        int yexp = (int) (ybits >>> 52);
        double z = x * y;
        if (xexp != 0 && xexp < 0x7ff && yexp != 0 && yexp < 0x7ff) {
            long zbits = Double.doubleToRawLongBits(z);
            int zexp = (int) (zbits >>> 52);
            if (zexp != 0 && zexp < 0x7ff) {
                long xsig = (1L << 52) | (xbits & ((1L << 52) - 1));
                long ysig = (1L << 52) | (ybits & ((1L << 52) - 1));
                long prod = xsig * ysig;
                int dexp = zexp - xexp - yexp;
                if (dexp == -1023) {
                    // drop 52 bits
                    prod = prod & ((1L << 53) - 1);
                    if (prod > (1L << 51) && (prod < (2L << 51))
                            || prod >= (3L << 51)) {
                        z = nextDn(z);
                    }
                } else {
                    assert dexp == -1022;
                    // drop 53 bits
                    prod = prod & ((1L << 54) - 1);
                    if (prod > (1L << 52) && prod < (2L << 52)
                            || prod >= (3L << 52)) {
                        z = nextDn(z);
                    }
                }
                return z;
            }
        } else if (x == 0 || y == 0) {
            return z;
        }

        return floor64.mul(ExtendedRational.valueOf(x), ExtendedRational.valueOf(y)).doubleValue();
        */

        /*
        if ((x==0.0)||(y==0.0)) return(0.0);
        return(nextDn(x*y));
        */

        if ((x==0.0)||(y==0.0))
        {
            return(0.0);
        }
        else
        {
            double r = x * y;
            if(r / x > y ||r / y > x)
            {
                return nextDn(r);
            }

            return r;
        }
    }


    public static double divDn(double x, double y) {
        /*
        if (x >= 0 && y > 0) {
            double r = x / y;
            return x < Utils.mulUp(y, r) ? nextDn(r) : r;
        }

        return floor64.div(ExtendedRational.valueOf(x), ExtendedRational.valueOf(y)).doubleValue();
        */

        /*
        if (x==0.0) return(0.0);
        return(nextDn(x/y));
        */

        if ((x==0.0))
        {
            return(0.0);
        }
        else
        {
            double r = x / y;
            if(x / r > y ||r * y > x)
            {
                return nextDn(r);
            }

            return r;
        }
    }

    public static double divUp(double x, double y) {
        /*
        if (x >= 0 && y > 0) {
            double r = x / y;
            return x > Utils.mulDn(y, r) ? nextUp(r) : r;
        }
        return ceil64.div(ExtendedRational.valueOf(x), ExtendedRational.valueOf(y)).doubleValue();
        */
        /*
        if (x==0.0) return(0.0);
        return(nextUp(x/y));
        */
        if ((x==0.0))
        {
            return(0.0);
        }
        else
        {
            double r = x / y;
            if(x / r < y ||r * y < x)
            {
                return nextUp(r);
            }

            return r;
        }
    }

    public static double sqrtDn(double x) {
        double r = Math.sqrt(x);
        return x < Utils.mulUp(r, r) ? nextDn(r) : r;
    }

    public static double sqrtUp(double x) {
        double r = Math.sqrt(x);
        return x > Utils.mulDn(r, r) ? nextUp(r) : r;
    }

    public static double powDn(double x, double y) {
        /*
        if (x > 0) {
            double r = nextDn(nextDn(Math.pow(x, y)));
            if (x >= 1 && y >= 0 || x <= 1 && y <= 0) {
                return Math.max(1, r);
            } else {
                return Math.max(0, r);
            }
        } else {

            return floor64.pow(ExtendedRational.valueOf(x), ExtendedRational.valueOf(y)).doubleValue();
        }
        */
       // return nextDn((Math.pow(x, y)));

        //Je pense que c'est toujours faux mais je test
        double r = Math.pow(x,y);
        if(Math.pow(r,1/y) > x)
        {
            return nextDn(r);
        }
        return r;
    }

    public static double powUp(double x, double y) {
        /*
        if (x > 0) {
            double r = nextUp(nextUp(Math.pow(x, y)));
            if (x >= 1 && y <= 0 || x <= 1 && y >= 0) {
                return Math.min(1, r);
            } else {
                return r;
            }
        } else {
            return ceil64.pow(ExtendedRational.valueOf(x), ExtendedRational.valueOf(y)).doubleValue();
        }
        */

        //return nextUp((Math.pow(x, y)));

        //Je pense que c'est toujours faux mais je test
        double r = Math.pow(x,y);
        if(Math.pow(r,1/y) < x)
        {
            return nextUp(r);
        }
        return r;
    }

    public static double pownDn(double x, int p) {
       /*
        if (x > 0) {
            switch (p) {
                case 0:
                    return 1;
                case 1:
                    return x;
                case 2:
                    return Utils.mulDn(x, x);
                case 3:
                    return Utils.mulDn(x, Utils.mulDn(x, x));
                case 4:
                    double x2 = Utils.mulDn(x, x);
                    return Utils.mulDn(x2, x2);
                case 5:
                    x2 = Utils.mulDn(x, x);
                    return Utils.mulDn(x, Utils.mulDn(x2, x2));
                case 6:
                    x2 = Utils.mulDn(x, x);
                    return Utils.mulDn(x2, Utils.mulDn(x2, x2));
                case 7:
                    x2 = Utils.mulDn(x, x);
                    double x4 = Utils.mulDn(x2, x2);
                    return Utils.mulDn(x, Utils.mulDn(x2, x4));
                case 8:
                    x2 = Utils.mulDn(x, x);
                    x4 = Utils.mulDn(x2, x2);
                    return Utils.mulDn(x4, x4);
                case 9:
                    x2 = Utils.mulDn(x, x);
                    x4 = Utils.mulDn(x2, x2);
                    return Utils.mulDn(x, Utils.mulDn(x4, x4));
                case 10:
                    x2 = Utils.mulDn(x, x);
                    x4 = Utils.mulDn(x2, x2);
                    return Utils.mulDn(x2, Utils.mulDn(x4, x4));
                default:
                    if (p < 0 && p > -10) {
                        return Utils.divDn(1, pownUp(x, -p));
                    }
                    return Utils.powDn(x, (double) p);
            }
        } else if (x == 0 && p > 0) {
            return 0;
        } else {
            return floor64.pown(ExtendedRational.valueOf(x), p).doubleValue();
        }
        */
        return nextDn((Math.pow(x, p)));

    }

    public static double pownUp(double x, int p) {
       /*
        if (x > 0) {
            switch (p) {
                case 0:
                    return 1;
                case 1:
                    return x;
                case 2:
                    return Utils.mulUp(x, x);
                case 3:
                    return Utils.mulUp(x, Utils.mulUp(x, x));
                case 4:
                    double x2 = Utils.mulUp(x, x);
                    return Utils.mulUp(x2, x2);
                case 5:
                    x2 = Utils.mulUp(x, x);
                    return Utils.mulUp(x, Utils.mulUp(x2, x2));
                case 6:
                    x2 = Utils.mulUp(x, x);
                    return Utils.mulUp(x2, Utils.mulUp(x2, x2));
                case 7:
                    x2 = Utils.mulUp(x, x);
                    double x4 = Utils.mulUp(x2, x2);
                    return Utils.mulUp(x, Utils.mulUp(x2, x4));
                case 8:
                    x2 = Utils.mulUp(x, x);
                    x4 = Utils.mulUp(x2, x2);
                    return Utils.mulUp(x4, x4);
                case 9:
                    x2 = Utils.mulUp(x, x);
                    x4 = Utils.mulUp(x2, x2);
                    return Utils.mulUp(x, Utils.mulUp(x4, x4));
                case 10:
                    x2 = Utils.mulUp(x, x);
                    x4 = Utils.mulUp(x2, x2);
                    return Utils.mulUp(x2, Utils.mulUp(x4, x4));
                default:
                    if (p < 0 && p > -10) {
                        return Utils.divUp(1, pownDn(x, -p));
                    }
                    return Utils.powUp(x, (double) p);
            }
        } else if (x == 0 && p > 0) {
            return 0;
        } else {
            return ceil64.pown(ExtendedRational.valueOf(x), p).doubleValue();
        }*/

        return nextDn((Math.pow(x, p)));
    }

    public static double expDn(double x)
    {
        if(Math.log(Math.exp(x)) > x)
        {
            return nextDn((Math.exp(x)));
        }
        return Math.exp(x);

        //return -Math.nextUp(-(Math.exp(x)));
    }

    public static double expUp(double x)
    {
        if(Math.log(Math.exp(x)) < x)
        {
            return nextUp((Math.exp(x)));
        }
        return Math.exp(x);

        //return Math.nextUp(Math.exp(x));
    }

    public static double logDn(double x)
    {

        if(Math.exp(Math.log(x)) > x)
        {
            return nextDn((Math.log(x)));
        }
        return Math.log(x);
        //return -Math.nextUp(-(Math.log(x)));
    }

    public static double logUp(double x)
    {
        if(Math.exp(Math.log(x)) < x)
        {
            return nextUp((Math.log(x)));
        }
        return Math.log(x);
        //return Math.nextUp(Math.log(x));
    }

    public static double sinDn(double x)
    {
        return -Math.nextUp(-(Math.sin(x)));
    }

    public static double sinUp(double x)
    {
        return Math.nextUp(Math.sin(x));
    }

    public static double cosDn(double x)
    {
        return nextDn(Math.cos(x));
    }

    public static double cosUp(double x)
    {
        return Math.nextUp(Math.cos(x));
    }

    public static double tanDn(double x)
    {
        if(Math.tan(Math.atan(x)) < x)
        {
            return nextDn((Math.tan(x)));
        }
        return Math.tan(x);
        //return nextUp(Math.tan(x));
    }

    public static double tanUp(double x)
    {
        if(Math.tan(Math.atan(x)) > x)
        {
            return nextUp((Math.tan(x)));
        }
        return Math.tan(x);
        //return Math.nextUp(Math.tan(x));
    }

    public static double asinDn(double x)
    {
        return nextDn(Math.asin(x));
    }

    public static double asinUp(double x)
    {
        return nextUp(Math.asin(x));
    }

    public static double acosDn(double x)
    {
        return nextDn(Math.acos(x));
    }

    public static double acosUp(double x)
    {
        return nextUp(Math.acos(x));
    }

    public static double atanDn(double x)
    {
        return nextDn(Math.atan(x));
    }

    public static double atanUp(double x)
    {
        return nextUp(Math.atan(x));
    }



}
