package test;

import metier.*;

import java.util.Date;

public class Test1 {
    /**
     * Test de la couche métier
     */
    public static void main(String[] args) {
        System.out.println("Hello World");

        TypeRepas t1 = new TypeRepas("Petit déjeuner");
        TypeRepas t2 = new TypeRepas("Déjeuner");
        TypeRepas t3 = new TypeRepas("Dîner");

        Date now = new Date();

        Repas repas = new Repas(t1, now);

        Boisson b1 = new Boisson("Jus d'orange bio");
        Plat p1 = new Plat("Tartiflette");

        repas.addBoisson(b1);
        repas.addPlat(p1);

        System.out.println(repas);

        Symptome s = new Symptome(now, "Mal de tête", 2, true);

        System.out.println(s);
    }
}
