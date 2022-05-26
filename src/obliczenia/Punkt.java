package obliczenia;


public class Punkt implements Przeksztalcenia {

    public static final Punkt ZERO = new Punkt();
    private double x, y;

    public Punkt() {
    }

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%.3f; %.3f)", x, y);
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == null) throw new IllegalArgumentException("Obiekt do porównania jest nullem");
        Punkt p = (Punkt) ob;
        return x == p.x && y == p.y;

    }

    @Override
    public void translacja(Wektor v) {
        x += v.dx;
        y += v.dy;
    }

    @Override
    public void obrot(Punkt p, double kąt) {
        double radians = Math.toRadians(kąt);
        x = (((x - p.x()) * Math.cos(radians)) - ((y - p.y()) * Math.sin(radians))) + p.x();
        y = (((x - p.x()) * Math.sin(radians)) - ((y - p.y()) * Math.cos(radians))) + p.y();
    }

    @Override
    public void symetria(Punkt p) {
        translacja(new Wektor(p, ZERO));
        x = -x;
        y = -y;
        translacja(new Wektor(ZERO, p));
    }

    @Override
    public void symetria(Prosta p) {
        double temp = -2 * (p.a * x + p.b * y + p.c) /
                (p.a * p.a + p.b * p.b);
        x = temp * p.a + x;
        y = temp * p.b + y;
    }
}
