package test;

import jsonDao.*;
import metier.*;

import java.util.Date;

public class Test2 {
    /**
     * Test pour MongoDB
     */
    public static void testSymptome() {
        System.out.println("Hello World!");

        Symptome s = new Symptome(new Date(), "description de fou", 2, true);

        System.out.println(s);

        JsonDaoSymptome jds = JsonDaoSymptome.getInstance();
        Symptome s2 = jds.create(s);


        System.out.println(s2);

        Symptome s3 = jds.find(s2.getId());
        System.out.println(s3);
    }

    public static void testRepas() {
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

        JsonDaoRepas jdr = JsonDaoRepas.getInstance();
        Repas newRepas = jdr.create(repas);

        System.out.println(newRepas);
    }

    public static void main(String[] args) {
        testSymptome();
        testRepas();
    }
}
