//je regroupe juste les morceaux de code qui concernent le add : 

public ClassicInterval add(ClassicInterval x, ClassicInterval y) {
	return checkClassic(impl.add(x, y));
}

// -> ca c'est le impl.add
public SetInterval add(SetInterval x, SetInterval y) {
        if (Utils.isNonemptyInfSupDouble(x) && Utils.isNonemptyInfSupDouble(y)) {
            double xi = x.doubleInf();
            double xs = x.doubleSup();
            double yi = y.doubleInf();
            double ys = y.doubleSup();
            Decoration d = x.getDecoration().min(y.getDecoration());
            return Utils.set(Utils.addDn(xi, yi), Utils.addUp(xs, ys), d);
        } else {
            return super.add(x, y);
        }
}

// -> Utils.isNonempty...
public static boolean isNonemptyInfSupDouble(Interval x) {
        return x instanceof DoubleInterval;
}

// -> Utils.set...
public static SetInterval set(double inf, double sup, Decoration decoration) {
        if (Double.NEGATIVE_INFINITY < inf && sup < Double.POSITIVE_INFINITY) {
            return new DoubleInterval.Bounded(inf, sup, decoration);
        } else {
            return new DoubleInterval.Unbounded(inf, sup, decoration.min(Decoration.DAC));
        }
}

 Bounded(double inf, double sup, Decoration decoration) {
            super(inf, sup, decoration);
            if (!(inf <= sup)) {
                throw new IllegalArgumentException();
            }
            assert Double.NEGATIVE_INFINITY < inf && sup < Double.POSITIVE_INFINITY;
}

public static double addDn(double x, double y) {
        double r = x + y;
        return r - x > y || r - y > x ? nextDn(r) : r;
}

public static double nextDn(double x) {
        return -Math.nextUp(-x);
}

//Decoration ca ressemble à ca : 

public enum Decoration {

    /**
     * ill-formed
     */
    ILL,
    /**
     * trivial
     */
    TRV,
    /**
     * defined
     */
    DEF,
    /**
     * defined & continuous
     */
    DAC,
    /**
     * common
     */
    COM;

    public Decoration min(Decoration that) {
        return this.ordinal() <= that.ordinal() ? this : that;
    }

    public Decoration max(Decoration that) {
        return this.ordinal() >= that.ordinal() ? this : that;
    }

    public boolean possiblyUndefined() {
        return this.ordinal() <= TRV.ordinal();
    }

    public byte enc(boolean isEmpty) {
        byte enc = (byte) (ordinal() << 2);
        if (isEmpty) {
            if (enc == ENC_TRV) {
                enc = ENC_EMPTY;
            } else if (enc > ENC_TRV) {
                throw new IllegalArgumentException();
            }
        } else if (enc == ENC_ILL) {
            throw new IllegalArgumentException();
        }
        return enc;
    }

    public static Decoration byEnc(byte enc) {
        switch (enc) {
            case ENC_ILL:
                return ILL;
            case ENC_EMPTY:
            case ENC_TRV:
                return TRV;
            case ENC_DEF:
                return DEF;
            case ENC_DAC:
                return DAC;
            case ENC_COM:
                return COM;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static final byte ENC_ILL = 0 << 2;
    public static final byte ENC_EMPTY = 2;
    public static final byte ENC_TRV = 1 << 2;
    public static final byte ENC_DEF = 2 << 2;
    public static final byte ENC_DAC = 3 << 2;
    public static final byte ENC_COM = 4 << 2;
}





