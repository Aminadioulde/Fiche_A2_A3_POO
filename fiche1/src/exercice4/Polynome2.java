//package fiche1.src.exercice4;

public class Polynome2 extends Polynome {
    int a, b, c;

    public Polynome2(int c, int b, int a) {
        super(b, c, a);
        this.c = c;
        this.b = b;
        this.a = a;
    }

    public void resoudreEquation() {
        double delta = Math.pow(b, 2) - 4 * a * c;
        double x1, x2, x0;
        if (delta > 0) {
            x1 = -(b + Math.sqrt(delta)) / (2 * a);
            x2 = -(b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Les solution de l'équation sont x1 = " + x1 + " x2 = " + x2);
        } else if (delta < 0) {
            x0 = (double) (-b) / (2 * a);
            System.out.println("La solution double de l'équation est: " + x0);
        } else {
            System.out.println("La solution de cette équation est dans le domaine Complexe");
        }
    }
}