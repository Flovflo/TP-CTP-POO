import dao.DaoRepas;
import jsonDao.JsonDaoRepas;
import metier.Boisson;
import metier.Plat;
import metier.Repas;
import metier.TypeRepas;

import java.util.*;

public class Main {
    public static String choixBase = "json";

    public static DaoRepas getDaoRepas() {
        if (choixBase == "json") {
            return JsonDaoRepas.getInstance();
        } else {
            return null;
        }
    }

    public static String recupererReponse() {
        // Récupére ce que l'utilisateur a tapé
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        return reponse;
    }

    public static void afficherMenuPrincipal() {
        System.out.println("Menu");
        System.out.println("1. Ajouter un repas");
        System.out.println("2. Ajouter un symptôme");
        System.out.println("3. Afficher les repas");
        System.out.println("0. Quitter");
    }

    public static void afficherTypesRepas() {
        System.out.println("Types de repas");
        System.out.println("1. Petit déjeuner");
        System.out.println("2. Déjeuner");
        System.out.println("3. Goûter");
        System.out.println("4. Dîner");
    }

    public static void ajouterRepas() {
        System.out.println("Saisissez la date du repas (jj/mm/aaaa) : ");
        String date = recupererReponse();

        System.out.println("Saisissez l'heure du repas (hh:mm) : ");
        String heure = recupererReponse();

        String typeRepasSaisi = "";
        while (!Objects.equals(typeRepasSaisi, "1") && !Objects.equals(typeRepasSaisi, "2") && !Objects.equals(typeRepasSaisi, "3") && typeRepasSaisi != "4") {
            afficherTypesRepas();
            typeRepasSaisi = recupererReponse();
        }

        String res = "tmp";
        List<String> plats = new ArrayList<>();

        while (!Objects.equals(res, "")) {
            System.out.println("Saisissez un plat : ");
            res = recupererReponse();
            if (!Objects.equals(res, "")) {
                plats.add(res);
            }
        }


        res = "tmp";
        List<String> boissons = new ArrayList<>();

        while (!Objects.equals(res, "")) {
            System.out.println("Saisissez une boisson : ");
            res = recupererReponse();
            if (!Objects.equals(res, "")) {
                boissons.add(res);
            }
        }

        TypeRepas typeRepas = null;

        if (Objects.equals(typeRepasSaisi, "1")) {
            typeRepas = new TypeRepas("Petit déjeuner");
        } else if (Objects.equals(typeRepasSaisi, "2")) {
            typeRepas = new TypeRepas("Déjeuner");
        } else if (Objects.equals(typeRepasSaisi, "3")) {
            typeRepas = new TypeRepas("Goûter");
        } else if (Objects.equals(typeRepasSaisi, "4")) {
            typeRepas = new TypeRepas("Dîner");
        } else {
            throw new IllegalArgumentException("Type de repas inconnu");
        }

        // TODO: Utiliser les informations saisies pour remplir la date
        Repas repas = new Repas(typeRepas, new Date());
        for (String plat : plats) {
            repas.addPlat(new Plat(plat));
        }

        for (String boisson : boissons) {
            repas.addBoisson(new Boisson(boisson));
        }

        JsonDaoRepas jdr = (JsonDaoRepas) getDaoRepas();
        jdr.create(repas);

        menu();
    }

    public static void ajouterSymptome() {
        menu();
    }

    public static void afficherRepas() {
        JsonDaoRepas jdr = (JsonDaoRepas) getDaoRepas();

        List<Repas> repas = jdr.findAll();

        // TODO: Ordonner par ordre décroissant de date
        for (Repas repa : repas) {
            System.out.println(repa);
        }

        menu();
    }

    public static void menu() {
        String res = null;
        while(!Objects.equals(res, "1") && !Objects.equals(res, "2") && !Objects.equals(res, "3") && !Objects.equals(res, "0")) {
            afficherMenuPrincipal();
            res = recupererReponse();
            System.out.println("<" + res + ">");
            System.out.println(!Objects.equals(res, "0"));
        }

        if (res.equals("1")) {
            ajouterRepas();
        } else if (res.equals("2")) {
            ajouterSymptome();
        } else if (res.equals("3")) {
            afficherRepas();
        }
    }

    public static void main(String[] args) {
        System.out.println("Début application!");

        menu();
    }
}
