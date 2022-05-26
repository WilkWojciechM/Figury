package test;

import obliczenia.*;
import java.util.Scanner;

//Wojciech Wilk grD nr indeksu 6877
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        int temp1;
        do {
            System.out.println("W celu wybrania figury wpisz\n Dla Trójkąta - 1 \n Dla Odcinka - 2 \n Dla Punktu - 3 \n Dla Prostej - 4 \n Dla Wektora - 5 \n wyjście z programu - 0");
            result = Integer.parseInt(scanner.nextLine());

            if (result == 1) {
                System.out.println("Wpisz współrzędne wierzchołków trójkąta \n Wierzchołek A \n X:");
                double ax = Double.parseDouble(scanner.nextLine());
                System.out.println(" Y:");
                double ay = Double.parseDouble(scanner.nextLine());
                Punkt a = new Punkt(ax, ay);
                System.out.println("Wierzchołek B: \n X:");
                double bx = Double.parseDouble(scanner.nextLine());
                System.out.println(" Y:");
                double by = Double.parseDouble(scanner.nextLine());
                Punkt b = new Punkt(bx, by);
                System.out.println("Wierzchołek C: \n X:");
                double cx = Double.parseDouble(scanner.nextLine());
                System.out.println(" Y:");
                double cy = Double.parseDouble(scanner.nextLine());
                Punkt c = new Punkt(cx, cy);
                Trojkat trojkat = new Trojkat(a, b, c);
                System.out.println("Utworzyłeś trójkąt o wierzchołkach A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ") C(" + c.x() + ',' + c.y() + ")");

                do {
                    System.out.println("\n Działania na trójkącie \n Obliczanie pola powierzchni wpisz - 1 \n Obliczanie obwodu wpisz - 2 \n W celu dokonania translacji o wektor v wpisz - 3 \n W celu obrotu względem punktu o zadany kąt wpisz - 4 \n Symetria względem punktu wpisz - 5 \n Symetria względem prostej wpisz - 6 \n Powrót do menu wpisz - 0 \n");
                    temp1 = Integer.parseInt(scanner.nextLine());
                    if (temp1 == 1) {
                        System.out.println("Pole trójkąta to:" + trojkat.pole());
                    } else if (temp1 == 2) {
                        System.out.println("Obwód trójkąta to: " + trojkat.obwod());
                    } else if (temp1 == 3) {
                        System.out.println("Przyjmuje w celach testowych wektor v o współrzędnych w pkt X(1,0) oraz Y(0,1)");
                        Punkt pkt1 = new Punkt(1, 0);
                        Punkt pkt2 = new Punkt(0, 1);
                        Wektor v = new Wektor(pkt1, pkt2);
                        trojkat.translacja(v);
                        System.out.println("Trójkąt po translacji o wektor ma wierzchołki o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ") C(" + c.x() + "," + c.y() + ")");
                    } else if (temp1 == 4) {
                        System.out.println("W celach testowych przyjmujemy, że pkt P wokół, którego nastąpi obrót ma współrzędne P(3,4) oraz kąt 45 stopni");
                        Punkt P = new Punkt(3, 4);
                        int kat = 45;
                        trojkat.obrot(P, kat);
                        System.out.println("Trójkąt po obrocie  ma wierzchołki o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ") C(" + c.x() + "," + c.y() + ")");
                    } else if (temp1 == 5) {
                        System.out.println("W celach testowych przyjmujemy, że pkt P względem, którego nastapi symetria ma współrzędne P(5,6)");
                        Punkt P = new Punkt(5, 6);
                        trojkat.symetria(P);
                        System.out.println("Trójkąt po symetrii względem pkt P ma wierzchołki o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ") C(" + c.x() + "," + c.y() + ")");
                    } else if (temp1 == 6) {
                        System.out.println("W celach testowych przyjmujemy, że prosta względem, której nastapi symetria ma równanie ogólne 5x + 6y + 7 = 0");
                        Prosta pr = new Prosta(5, 6, 7);
                        trojkat.symetria(pr);
                        System.out.println("Trójkąt po symetrii względem prostej pr ma wierzchołki o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ") C(" + c.x() + "," + c.y() + ")");
                    }
                } while (temp1 != 0);
            } else if (result == 2) {
                System.out.println("Wypisz współrzędne między którymi znajduje się odcinek \n Pkt A \n x:");
                double ax = Double.parseDouble(scanner.nextLine());
                System.out.println(" Y:");
                double ay = Double.parseDouble(scanner.nextLine());
                Punkt a = new Punkt(ax, ay);
                System.out.println("Wierzchołek B: \n X:");
                double bx = Double.parseDouble(scanner.nextLine());
                System.out.println(" Y:");
                double by = Double.parseDouble(scanner.nextLine());
                Punkt b = new Punkt(bx, by);
                Odcinek odcinek = new Odcinek(a, b);
                System.out.println("Utworzyłeś odcinek między punktmi A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ")");

                do {
                    System.out.println("\n Działania na odcinku: \n Sprawdzenie długości odcinka wpisz - 1 \n W celu dokonania translacji o wektor v wpisz - 2 \n W celu obrotu względem punktu o zadany kąt wpisz - 3 \n Symetria względem punktu wpisz - 4 \n Symetria względem prostej wpisz - 5 \n Powrót do menu wpisz - 0 \n");
                    temp1 = Integer.parseInt(scanner.nextLine());
                    if(temp1 == 1){
                        System.out.println("Odcinek ma długośc : " + odcinek.dlugosc());
                    }else if(temp1 == 2){
                        System.out.println("Przyjmuje że wektor v ma współrzędne w pkt X(1,0) oraz Y(0,1)");
                        Punkt pkt1 = new Punkt(1, 0);
                        Punkt pkt2 = new Punkt(0, 1);
                        Wektor v = new Wektor(pkt1, pkt2);
                        odcinek.translacja(v);
                        System.out.println("Odcinek po translacji o wektor ma pkt o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ")");
                    }else if(temp1 == 3){
                        System.out.println("W celach testowych przyjmujemy, że pkt P wokół, którego nastąpi obrót ma współrzędne P(3,4) oraz kąt 45 stopni");
                        Punkt P = new Punkt(3, 4);
                        int kat = 45;
                        odcinek.obrot(P, kat);
                        System.out.println("Odcinek po obrocie ma pkt o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ")");
                    }else if(temp1 == 4){
                        System.out.println("W celach testowych przyjmujemy, że pkt P względem, którego nastapi symetria ma współrzędne P(5,6)");
                        Punkt P = new Punkt(5, 6);
                        odcinek.symetria(P);
                        System.out.println("Odcinek po symetrii wzgl pkt P ma końce o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ")");
                    }else if(temp1 == 5){
                        System.out.println("W celach testowych przyjmujemy, że prosta względem, której nastapi symetria ma równanie ogólne 5x + 6y + 7 = 0");
                        Prosta pr = new Prosta(5, 6, 7);
                        odcinek.symetria(pr);
                        System.out.println("Odcinek po symetrii wzgl prostej pr ma końce o współrzędnych A(" + a.x() + "," + a.y() + ") B(" + b.x() + "," + b.y() + ")");
                    }
                } while (temp1 != 0);
            } else if (result == 3) {
                System.out.println("Wpisz współrzędne punktu \n X:");
                double ax = Double.parseDouble(scanner.nextLine());
                System.out.println(" Y:");
                double ay = Double.parseDouble(scanner.nextLine());
                Punkt punkt = new Punkt(ax, ay);
                System.out.println("Utworzyłeś punkt o współrzędnych A(" + punkt.x() + "," + punkt.y() + ")");
                do{
                    System.out.println("\n Działania na odcinku: \n W celu dokonania translacji o wektor v wpisz - 1 \n W celu obrotu względem punktu o zadany kąt wpisz - 2 \n Symetria względem punktu wpisz - 3 \n Symetria względem prostej wpisz - 4 \n Powrót do menu wpisz - 0");
                    temp1 = Integer.parseInt(scanner.nextLine());
                    if(temp1 == 1){
                        System.out.println("Przyjmuje że wektor v ma współrzędne w pkt X(1,0) oraz Y(0,1)");
                        Punkt pkt1 = new Punkt(1, 0);
                        Punkt pkt2 = new Punkt(0, 1);
                        Wektor v = new Wektor(pkt1, pkt2);
                        punkt.translacja(v);
                        System.out.println("Punkt po translacji o wektor ma współrzędne A(" + punkt.x() + "," + punkt.y() + ")");
                    }else if(temp1 == 2){
                        System.out.println("W celach testowych przyjmujemy, że pkt P wokół, którego nastąpi obrót ma współrzędne P(3,4) oraz kąt 45 stopni");
                        Punkt P = new Punkt(3, 4);
                        int kat = 45;
                        punkt.obrot(P, kat);
                        System.out.println("Punkt po obrocie ma współrzędne A(" + punkt.x() + "," + punkt.y() + ")");
                    }else if(temp1 == 3){
                        System.out.println("W celach testowych przyjmujemy, że pkt P względem, którego nastapi symetria ma współrzędne P(5,6)");
                        Punkt P = new Punkt(5, 6);
                        punkt.symetria(P);
                        System.out.println("Punkt po symetrii wzgl pkt P ma współrzędne A(" + punkt.x() + "," + punkt.y() + ")");
                    }else if(temp1 == 4){
                        System.out.println("W celach testowych przyjmujemy, że prosta względem, której nastapi symetria ma równanie ogólne 5x + 6y + 7 = 0");
                        Prosta pr = new Prosta(5, 6, 7);
                        punkt.symetria(pr);
                        System.out.println("Punkt po symetrii wzgl prostej pr ma współrzędne A(" + punkt.x() + "," + punkt.y() + ")");
                    }
                }while (temp1 != 0);
            }else if(result == 4){
                System.out.println("Wpisz równanie ogólne pierwszej prostej \n A=");
                double a1 = Double.parseDouble(scanner.nextLine());
                System.out.println(" B=");
                double b1 = Double.parseDouble(scanner.nextLine());
                System.out.println(" C=");
                double c1 = Double.parseDouble(scanner.nextLine());
                Prosta p = new Prosta(a1,b1,c1);
                System.out.println("Wpisz równanie ogólne drugiej prostej \n A=");
                double a2 = Double.parseDouble(scanner.nextLine());
                System.out.println(" B=");
                double b2 = Double.parseDouble(scanner.nextLine());
                System.out.println(" C=");
                double c2 = Double.parseDouble(scanner.nextLine());
                Prosta q = new Prosta(a2,b2,c2);
                System.out.println("Proste są prostopadłe ? = " + Prosta.prostopadle(p,q)  +"\n Proste są równoległe? = " + Prosta.rownolegle(p,q) + "\n Proste przecinają się ? = " + Prosta.przeciecie(p,q));
            }else if(result == 5){
                System.out.println("W celach testowych przyjumje dwa wektory v=AB(1,0)(1,1) oraz u=CD(2,2)(3,5)");
                Punkt A = new Punkt(1,0);
                Punkt B = new Punkt(1,1);
                Punkt C = new Punkt(2,2);
                Punkt D = new Punkt(3,5);
                Wektor v = new Wektor(A,B);
                Wektor u = new Wektor(C,D);
                Wektor wektor1 = Wektor.przeciwny(v);
                System.out.println("Wektor przeciwny do wektora v to wektor o dx =" + wektor1.dx + " i " + " dy= " + wektor1.dy);
                Wektor wektor =  Wektor.zlozenie(u,v);
                System.out.println("Złożenie wektora u i v to Wektor o dx =" + wektor.dx + " i dy= " + wektor.dy);
            }
        } while (result != 0);
    }
}
