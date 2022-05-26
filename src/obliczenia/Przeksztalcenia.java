package obliczenia;

public interface Przeksztalcenia {
    void translacja(Wektor v);
    void obrot(Punkt p, double kąt);
    void symetria(Punkt p);
    void symetria(Prosta p);
}
