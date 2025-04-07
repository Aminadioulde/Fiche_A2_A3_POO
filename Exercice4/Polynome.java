package Exercice4;
import java.util.*;

public class Polynome {
    private List<Integer> coefficients;

    public Polynome(Integer... coefficients) {
        this.coefficients = new ArrayList<>(Arrays.asList(coefficients));
    }

    public static Polynome additionner(Polynome p, Polynome p2) {
        int maxDeg = Math.max(p.coefficients.size(), p2.coefficients.size());
        List<Integer> nouveauCoeff = new ArrayList<>(Collections.nCopies(maxDeg, 0));

        for (int i = 0; i < p.coefficients.size(); i++) {
            nouveauCoeff.set(i, p.coefficients.get(i));
        }
        for (int i = 0; i < p2.coefficients.size(); i++) {
            nouveauCoeff.set(i, nouveauCoeff.get(i) + p2.coefficients.get(i));
        }

        return new Polynome(nouveauCoeff.toArray(new Integer[0]));
    }
    
    //2x^2 + 3x + 4 est représenté par [4,3,2]

    public static Polynome derivee(Polynome p) {
        if (p.coefficients.size() <= 1) return new Polynome(0);
        List<Integer> deriveeCoeff = new ArrayList<>();

        for (int i = 1; i < p.coefficients.size(); i++) {
            deriveeCoeff.add(p.coefficients.get(i) * i);
        }

        return new Polynome(deriveeCoeff.toArray(new Integer[0]));
    }

    public static double evaluer(Polynome p, double x) {
        double resultat = 0;
        for (int i = 0; i < p.coefficients.size(); i++) {
            resultat += p.coefficients.get(i) * Math.pow(x, i);
        }
        return resultat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            int coef = coefficients.get(i);
            if (coef != 0) {
                if (!sb.isEmpty()) sb.append(" + ");
                sb.append(coef).append(i > 0 ? "x^" + i : "");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {


        List<Integer> facteurs = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (true) {
            System.out.print("Entrer le facteur pour x exposant " + i + ": ");
            try {
                int x = scan.nextInt();
                facteurs.add(x);
                i++;
                System.out.println();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                break;
            }
        }

        Polynome p = new Polynome(facteurs.toArray(new Integer[0]));
        System.out.println("P =" + p.toString());

        Polynome additionP = Polynome.additionner(p, new Polynome(2, 0, -3, 0, 1));
        System.out.println("Pa =" + additionP.toString());

        Polynome deriveP = Polynome.derivee(p);
        System.out.println("Pd =" + deriveP.toString());

    }
}

