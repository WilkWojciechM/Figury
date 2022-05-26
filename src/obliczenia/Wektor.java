package obliczenia;

public class Wektor {

    public static Wektor zlozenie(Wektor u, Wektor v) {
        return new Wektor(u.dx + v.dx, u.dy + v.dy);
    }
    public static Wektor przeciwny(Wektor u) {
        return new Wektor(-u.dx, -u.dy);
    }

    public final double dx, dy;

    public Wektor(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    public Wektor(Punkt p, Punkt q) {
        this.dx = q.x() - p.x();
        this.dy = q.y() - p.y();
    }
}
