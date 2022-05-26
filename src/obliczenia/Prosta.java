package obliczenia;

public class Prosta {

    public final double a, b, c;

    public static boolean prostopadle(Prosta p, Prosta q) {
        return p.a * q.a == (-1) * p.b * q.b;
    }

    public static boolean rownolegle(Prosta p, Prosta q) {
        return p.a * q.b - q.a * p.b == 0;
    }

    public static Punkt przeciecie(Prosta p, Prosta q) {
        double d = p.a * q.b - q.a * p.b;
        if (d == 0) return null;
        else return new Punkt((p.b * q.c - q.b * p.c) / d, -(p.a * q.c - q.a * p.c) / d);
    }

    public Prosta(double a, double b, double c) {
        if (a == 0 && b == 0) throw new IllegalArgumentException("Błędne współczynniki równania prostej.");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Prosta(Punkt p, Punkt q) {
        if (p.equals(q)) throw new IllegalArgumentException("Para takich samych punktów nie wyznaczy prostej.");
        a = q.y() - p.y();
        b = p.x() - q.x();
        c = q.x() * p.y() - p.x() * q.y();
    }
}
