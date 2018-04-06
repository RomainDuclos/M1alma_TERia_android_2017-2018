package com.inter.romdu.TERapp;

/**
 * Created by romdu on 16/03/2018.
 */

public class IMaths {



    public static Interval add(Interval a, Interval b)
    {
        Interval z = new Interval();
        z.lo = Utils.addDn(a.lo,b.lo);
        z.hi = Utils.addUp(a.hi,b.hi);
        return(z);
    }

    public static Interval sub(Interval a, Interval b)
    {
        Interval z = new Interval();
        z.lo = Utils.subDn(a.lo,b.hi);
        z.hi = Utils.subUp(a.hi,b.lo);
        return(z);
    }

    public static Interval mul(Interval a, Interval b)
    {
        if(!a.isEmpty() && !b.isEmpty()) {
            Interval z = new Interval();
            double xi = a.lo;
            double xs = a.hi;
            double yi = b.lo;
            double ys = b.hi;
            double inf, sup;

            //[ 0, 0 ] * x = x * [ 0, 0 ] = [ 0, 0 ]
            if ((xi == 0 && xs == 0) || (yi == 0 && ys == 0)) {
                inf = sup = 0;
            } else if (ys <= 0) {
                if (xs <= 0) {
                    inf = Utils.mulDn(-xs, -ys);
                    sup = Utils.mulUp(-xi, -yi);
                } else if (xi >= 0) {
                    inf = -Utils.mulUp(xs, -yi);
                    sup = -Utils.mulDn(xi, -ys);
                } else {
                    inf = -Utils.mulUp(xs, -yi);
                    sup = Utils.mulUp(-xi, -yi);
                }
            } else if (yi >= 0) {
                if (xs <= 0) {
                    inf = -Utils.mulUp(-xi, ys);
                    sup = -Utils.mulDn(-xs, yi);
                } else if (xi >= 0) {
                    inf = Utils.mulDn(xi, yi);
                    sup = Utils.mulUp(xs, ys);
                } else {
                    inf = -Utils.mulUp(-xi, ys);
                    sup = Utils.mulUp(xs, ys);
                }
            } else if (xs <= 0) {
                inf = -Utils.mulUp(-xi, ys);
                sup = Utils.mulUp(-xi, -yi);
            } else if (xi >= 0) {
                inf = -Utils.mulUp(xs, -yi);
                sup = Utils.mulUp(xs, ys);
            } else {
                inf = -Math.max(Utils.mulUp(-xi, ys), Utils.mulUp(xs, -yi));
                sup = Math.max(Utils.mulUp(-xi, -yi), Utils.mulUp(xs, ys));
            }

            z.lo = inf;
            z.hi = sup;
            return z;
        } else {
            //intervalle vide pour moi (pour le moment)
            return new Interval(1.0,0.0);
        }
    }

    public static Interval div(Interval a, Interval b) {
        if(!a.isEmpty() && !b.isEmpty()) {
            Interval z = new Interval();
            double xi = a.lo;
            double xs = a.hi;
            double yi = b.lo;
            double ys = b.hi;
            double inf, sup;

            if (yi > 0) {
                if (xi > 0) { // x > 0, y > 0
                    inf = Utils.divDn(xi, ys);
                    sup = Utils.divUp(xs, yi);
                } else if (xs < 0) { // x < 0, y > 0
                    inf = -Utils.divUp(-xi, yi);
                    sup = -Utils.divDn(-xs, ys);
                } else { // 0 in x, y > 0
                    inf = -Utils.divUp(-xi, yi);
                    sup = Utils.divUp(xs, yi);
                }
            } else if (ys < 0) {
                if (xi > 0) { // x > 0, y < 0
                    inf = -Utils.divUp(xs, -ys);
                    sup = -Utils.divDn(xi, -yi);
                } else if (xs < 0) { // x < 0, y < 0
                    inf = Utils.divDn(-xs, -yi);
                    sup = Utils.divUp(-xi, -ys);
                } else { // 0 in x, y < 0
                    inf = -Utils.divUp(xs, -ys);
                    sup = Utils.divUp(-xi, -ys);
                }
            } else { // 0 in y
                if (yi == 0 && ys == 0) {
                    //intervalle vide pour moi
                    return (new Interval(1.0,0.0));
                }
                if (xi == 0 && xs == 0) {
                    inf = sup = 0;
                } else if (xi >= 0) {
                    inf = yi == 0 ? Utils.divDn(xi, ys) : Double.NEGATIVE_INFINITY;
                    sup = ys == 0 ? -Utils.divDn(xi, -yi) : Double.POSITIVE_INFINITY;
                } else if (xs <= 0) {
                    inf = ys == 0 ? Utils.divDn(-xs, -yi) : Double.NEGATIVE_INFINITY;
                    sup = yi == 0 ? -Utils.divDn(-xs, ys) : Double.POSITIVE_INFINITY;
                } else {
                    inf = Double.NEGATIVE_INFINITY;
                    sup = Double.POSITIVE_INFINITY;
                }

            }

            z.lo = inf;
            z.hi = sup;
            return (z);
        }else{
            //intervalle vide pour moi (pour le moment)
            return new Interval(1.0,0.0);
        }
    }

    public static Interval sqrt(Interval x) {
        if(!x.isEmpty()) {
            Interval z = new Interval();
            double xi = x.lo;
            double xs = x.hi;

            if (xi >= 0) {
                z.lo = Utils.sqrtDn(xi);
                z.hi = Utils.sqrtUp(xs);
                return z;
            }
            if (xs < 0) {
                //Intervalle vide (version GAOL) dans jinterval c'est [0,0] je crois
                return (new Interval(1.0,0.0));
            }

            z.lo = 0.0;
            z.hi = Utils.sqrtUp(xs);
            return z;
        } else {
            //intervalle vide pour moi (pour le moment)
            return new Interval(1.0,0.0);
        }

    }

    public static Interval pown(Interval x, int p) {
        if (!x.isEmpty()) {
            Interval z = new Interval();
            double xi = x.lo;
            double xs = x.hi;
            double inf;
            double sup;
            if (p > 0) {
                if (xi >= 0) {
                    inf = Utils.pownDn(xi, p);
                    sup = Utils.pownUp(xs, p);
                } else if (xs <= 0) {
                    if ((p & 1) != 0) {
                        inf = -Utils.pownUp(-xi, p);
                        sup = -Utils.pownDn(-xs, p);
                    } else {
                        inf = Utils.pownDn(-xs, p);
                        sup = Utils.pownUp(-xi, p);
                    }
                } else if ((p & 1) != 0) {
                    inf = -Utils.pownUp(-xi, p);
                    sup = Utils.pownUp(xs, p);
                } else {
                    inf = 0;
                    sup = Utils.pownUp(Math.max(-xi, xs), p);
                }
            } else if (p < 0) {
                if (xi > 0) {
                    inf = Utils.pownDn(xs, p);
                    sup = Utils.pownUp(xi, p);
                } else if (xs < 0) {
                    if ((p & 1) != 0) {
                        inf = -Utils.pownUp(-xs, p);
                        sup = -Utils.pownDn(-xi, p);
                    } else {
                        inf = Utils.pownDn(-xi, p);
                        sup = Utils.pownUp(-xs, p);
                    }
                } else if (xi == 0 && xs == 0) {
                    //intervalle vide pour moi
                    return new Interval(1.0,0.0);
                } else {
                    if ((p & 1) != 0) {
                        inf = xi == 0 ? Utils.pownDn(xs, p) : Double.NEGATIVE_INFINITY;
                        sup = xs == 0 ? -Utils.pownDn(-xi, p) : Double.POSITIVE_INFINITY;
                    } else {
                        inf = Utils.pownDn(Math.max(-xi, xs), p);
                        sup = Double.POSITIVE_INFINITY;
                    }

                }
            } else {
                inf = sup = 1;
            }
            z.lo = inf;
            z.hi = sup;
            return z;
        } else {
            //intervalle vide pour moi
            return new Interval(1.0,0.0);
        }
    }

    //C'est juste pour tester la puissance en mode "bourrin". Mais bon comme powUp et powDn ils sont nazes, c'est pas très utile.
    public static Interval my_pow(Interval a, Interval b)
    {
        if(!a.isEmpty() && !b.isEmpty()) {
            double xi = a.lo;
            double xs = a.hi;
            double yi = b.lo;
            double ys = b.hi;
            Interval z = new Interval();
            z.lo = Utils.powDn(xi, yi);
            z.hi = Utils.powUp(xs, ys);
            return z;
        }
        return new Interval(1.0,0.0);
    }

    public static Interval pow(Interval a, Interval b) {
        if(!a.isEmpty() && !b.isEmpty()) {
            double xi = a.lo;
            double xs = a.hi;
            double yi = b.lo;
            double ys = b.hi;
            Interval z = new Interval();


            if (xs <= 0) {
                if (xs < 0 || ys <= 0) {
                    //Intervalle vide pour moi
                    return new Interval(1.0,0.0);
                }
                return z; //[0.0,0.0]
            }
            int xicmp = Double.compare(xi, 1);
            int xscmp = Double.compare(xs, 1);

            double inf, sup;

            //[ 1, 1 ] * x = x * [ 0, 0 ] = [ 1, 1 ]
            if ((xicmp == 0 && xscmp == 0) || (yi == 0 && ys == 0)) {
                inf = sup = 1;
            } else if (ys <= 0) {
                if (xscmp <= 0) {
                    inf = Utils.powDn(xs, ys);
                    sup = xi > 0 ? Utils.powUp(xi, yi) : Double.POSITIVE_INFINITY;
                } else if (xicmp >= 0) {
                    inf = Utils.powDn(xs, yi);
                    sup = Utils.powUp(xi, ys);
                } else {
                    inf = Utils.powDn(xs, yi);
                    sup = xi > 0 ? Utils.powUp(xi, yi) : Double.POSITIVE_INFINITY;
                }
            } else if (yi >= 0) {
                if (xscmp <= 0) {
                    inf = xi > 0 ? Utils.powDn(xi, ys) : 0;
                    sup = Utils.powUp(xs, yi);
                } else if (xicmp >= 0) {
                    inf = Utils.powDn(xi, yi);
                    sup = Utils.powUp(xs, ys);
                } else {
                    inf = xi > 0 ? Utils.powDn(xi, ys) : 0;
                    sup = Utils.powUp(xs, ys);
                }
            } else if (xscmp <= 0) {
                inf = xi > 0 ? Utils.powDn(xi, ys) : 0;
                sup = xi > 0 ? Utils.powUp(xi, yi) : Double.POSITIVE_INFINITY;
            } else if (xicmp >= 0) {
                inf = Utils.powDn(xs, yi);
                sup = Utils.powUp(xs, ys);
            } else {
                inf = xi > 0
                        ? Math.min(Utils.powDn(xi, ys), Utils.powDn(xs, yi))
                        : 0;
                sup = xi > 0
                        ? Math.max(Utils.powUp(xi, yi), Utils.powUp(xs, ys))
                        : Double.POSITIVE_INFINITY;
            }
            z.lo = inf;
            z.hi = sup;
            return z;
        } else {
            //Intervalle vide pour moi
            return new Interval(1.0,0.0);
        }

    }

    public static Interval exp(Interval x) {
        if(!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;
            double l = Utils.expDn(xi);
            double u = Utils.expUp(xs);
            //double l = -Math.nextUp(-(Math.exp(xi)));
            //double u = Math.nextUp(Math.exp(xs));
            return (new Interval(l, u));
        } else {
            //Intervalle vide pour moi
            return new Interval(1.0,0.0);
        }

    }

    public static Interval log(Interval x) {
        if(!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;

            if (xi > 0) {
                //return (new Interval(-Math.nextUp(-(Math.log(xi))), Math.nextUp(Math.log(xs))));
                return (new Interval(Utils.logDn(xi), Utils.logUp(xs)));
            }
            if (xs <= 0) {
                return (new Interval(1.0,0.0));
            }
            return (new Interval(Double.NEGATIVE_INFINITY, Math.nextUp(Math.log(xs))));
        } else {
            //Intervalle vide pour moi
            return new Interval(1.0,0.0);
        }


    }

    public static Interval sin(Interval x) {
        if(!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;
            if (-Utils.piHalfInf <= xi && xs <= Utils.piHalfInf) {
                // Spead-up only for subintervals of [-pi/2,+pi/2]
                //double l = xi == 0 ? 0 : Math.max(-1, -Math.nextUp(-Math.sin(xi)));
                //double u = xs == 0 ? 0 : Math.min(1, Math.nextUp(Math.sin(xs)));
                double l = xi == 0 ? 0 : Math.max(-1, Utils.sinDn(xi));
                double u = xs == 0 ? 0 : Math.min(1, Utils.sinUp(xs));
                return (new Interval(l, u));
            }

            return x; // -> faux, je sais pas pourquoi j'ai mis ça
        } else {
            //Intervalle vide pour moi
            return new Interval(1.0,0.0);
        }
    }

    public static Interval cos(Interval x) {
        if(!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;
            if (0 <= xi && xs <= 2 * Utils.piHalfInf) {
                // Spead-up only for subintervals of [0,pi]

                //double l = xs == 0 ? 1 : Math.max(-1, -Math.nextUp(-Math.cos(xs)));
                //double u = xi == 0 ? 1 : Math.min(1, Math.nextUp(Math.cos(xi)));
                double l = xs == 0 ? 1 : Math.max(-1.0, Utils.cosDn(xs));
                double u = xi == 0 ? 1 : Math.min(1.0, Utils.cosUp(xi));
                return (new Interval(l, u));
            }

            //return x; // -> faux, je sais pas pourquoi j'ai mis ça
            return new Interval(Math.cos(xi),Math.cos(xs));
        } else {
            //Intervalle vide pour moi
            return new Interval(1.0,0.0);
        }
    }

    public static Interval tan(Interval x) {
        if(!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;
            if (-Utils.piHalfInf <= xi && xs <= Utils.piHalfInf) {
                // Spead-up only for subintervals of [-pi/2,+pi/2]

                //double l = -Math.nextUp(-Math.tan(xi));
                //double u = Math.nextUp(Math.tan(xs));
                double l = Utils.tanDn(xi);
                double u = Utils.tanUp(xs);
                return (new Interval(l, u));
            }

            return x; // -> faux, je sais pas pourquoi j'ai mis ça
        } else {
            //Intervalle vide pour moi
            return new Interval(1.0,0.0);
        }
    }


    public static Interval asin(Interval x) {
        if (!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;


            if (xs < -1 || xi > +1) {
                //Intervalle vide pour moi
                return new Interval(1.0,0.0);
            } else {
                if (xi < -1) {
                    xi = -1;

                }
                if (xs > +1) {
                    xs = +1;

                }
                //return new Interval((Utils.nextDn(Math.asin(xi)), Utils.nextUp(Math.asin(xs)));
                return new Interval(Utils.asinDn(xi), Utils.asinUp(xs));
            }
        } else {
            return new Interval(1.0,0.0);
        }
    }


    public static Interval acos(Interval x) {
        if (!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;

            if (xs < -1 || xi > +1) {
                return new Interval(1.0,0.0);
            } else {
                if (xi < -1) {
                    xi = -1;

                }
                if (xs > +1) {
                    xs = +1;

                }
                //return Utils.set(Utils.nextDn(Math.acos(xs)), Utils.nextUp(Math.acos(xi)), d);
                return new Interval(Utils.acosDn(xi), Utils.acosUp(xs));
            }
        } else {
            return new Interval(1.0,0.0);
        }
    }

    public static Interval atan(Interval x) {
        if (!x.isEmpty()) {
            double xi = x.lo;
            double xs = x.hi;
            //double l = Math.nextDown(Math.atan(xi));
            //double u = Math.nextUp(Math.atan(xs));
            double l = Utils.atanDn(xi);
            double u = Utils.atanUp(xs);
            return new Interval(l,u);
        } else {
            return new Interval(1.0,0.0);
        }
    }



}
