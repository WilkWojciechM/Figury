package obliczenia;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Trojkat implements Przeksztalcenia {
    private Punkt a;
    private Punkt b;
    private Punkt c;


    public Trojkat(Punkt a, Punkt b, Punkt c) {
        if (a == null || b == null || c == null)
            throw new IllegalArgumentException("Któryś z wierzchołków jest nullem");
        if (a.equals(b) || a.equals(c) || b.equals(c)) throw new IllegalArgumentException("Wierzchołki pokrywają się");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double dlugoscAB() {
        double dx = b.x() - a.x(), dy = b.y() - a.y();
        return sqrt(dx * dx + dy * dy);
    }

    private double dlugoscAC() {
        double dacx = c.x() - a.x(), dacy = c.y() - a.y();
        return sqrt(pow(dacx, 2) + pow(dacy, 2));
    }

    private double dlugoscBC() {
        double dbcx = c.x() - b.x(), dbcy = c.y() - b.y();
        return sqrt(pow(dbcx, 2) + pow(dbcy, 2));
    }


    public double obwod() {
        return dlugoscAB() + dlugoscAC() + dlugoscBC();
    }

    public double pole() {
        double p = obwod() / 2;
        return sqrt(p * (p - dlugoscAC()) * (p - dlugoscBC()) * (p - dlugoscAB()));
    }

    @Override
    public String toString() {
        return String.format("[%s; %s; %s]", a, b, c);
    }


    @Override
    public void translacja(Wektor v) {
        a.translacja(v);
        b.translacja(v);
        c.translacja(v);
    }

    @Override
    public void obrot(Punkt p, double kat) {
        a.obrot(p, kat);
        b.obrot(p, kat);
        c.obrot(p, kat);
    }

    @Override
    public void symetria(Punkt p) {
        a.symetria(p);
        b.symetria(p);
        c.symetria(p);
    }

    @Override
    public void symetria(Prosta p) {
        a.symetria(p);
        b.symetria(p);
        c.symetria(p);
    }
}
