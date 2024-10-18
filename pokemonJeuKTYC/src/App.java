import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner =  new Scanner(System.in);
        Scanner scannerText = new Scanner(System.in);
        Random random = new Random();

        final int POINT_POUVOIR_JOUEUR = 60;
        final int POINT_VIE_JOUEUR = 100;
        final int ATTAQUE_GRIFFE_DEGAT = 10;
        final int ATTAQUE_GRIFFE_COUT = 0;
        final int ATTAQUE_FLEMMECHE_DEGAT = 20;
        final int ATTAQUE_FLEMMECHE_COUT = 10;
        final int ATTAQUE_DRACO_SOUFFLE_DEGAT = 35;
        final int ATTAQUE_DRACO_SOUFFLE_COUT = 20;
        final int ATTAQUE_FEU_ENFER_DEGAT = 80;
        final int ATTAQUE_FEU_ENFER_COUT = 40;
        final String NOM_ATTAQUE_1 = "Griffe";
        final String NOM_ATTAQUE_2 = "Flammèche";
        final String NOM_ATTAQUE_3 = "Draco-Souffle";
        final String NOM_ATTAQUE_4 = "Feu d'enfer";

        Boolean proceder = false;
        Boolean valeurFuite = false;

        String nomPokemon = "";
        String reponseRejouer = "";
        String nomAttaque = "";
        int choixMenuJoueur = 0;
        int choixAttaqueJoueur = 0;
        int nombreVictoireJoueur = 0;
        int pvPokemonJoueur = 0;
        int ppPokemonJoueur = 0;
        int paPokemonAdversaire = 0;
        int pvPokemonAdverse = 0;
        int degatAttaqueChoisit = 0;
        int coutChoixAttaque = 0;
        int probabiliteAttaque = 0;
        int probaFuiteJoueur = 0;

        System.out.println("Bienvenue dans le Pokemon Revolution HUB");
        System.out.println();
        System.out.print("Veuillez entrer le nom de votre pokemon: ");
        nomPokemon = scanner.nextLine();
        System.out.println();
        System.out.println();
        do {
            nombreVictoireJoueur = 0;
            pvPokemonJoueur = POINT_VIE_JOUEUR;
            ppPokemonJoueur = POINT_POUVOIR_JOUEUR;
            do {
                paPokemonAdversaire = random.nextInt(5, 20);
                pvPokemonAdverse = random.nextInt(50, 100);

                String separator4 = "+-----------------------------------------------+";
                do {
                    valeurFuite = false;
                    String separator = "+------------------------+----------------------+";
                    System.out.println(separator);
                    System.out.println("|          STATISTIQUES DU COMBAT               |");
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PV DE " + nomPokemon, pvPokemonJoueur);
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PP DE " + nomPokemon, ppPokemonJoueur);
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PV ADVERSAIRE ", pvPokemonAdverse);
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PA ADVERSAIRE", paPokemonAdversaire);
                    System.out.println(separator);
                    System.out.printf("| %-25s  %18d |\n", "Nombre de victoire de " + nomPokemon, nombreVictoireJoueur);
                    System.out.println(separator);
                    System.out.println();

                    Thread.sleep(1500);
                    
                    String separator2 = "+----------------------------+";
                    System.out.println();
                    System.out.println(separator2);
                    System.out.printf("| %-26s |\n","     OPTION DE COMBAT");
                    System.out.println(separator2);
                    System.out.printf("| %-26s |\n", "1 - ATTAQUER");
                    System.out.println(separator2);
                    System.out.printf("| %-26s |\n", "2 - FUIR");
                    System.out.println(separator2);
                    System.out.printf("| %-26s |\n", "3 - NE RIEN FAIRE");
                    System.out.println(separator2);
                    System.out.println();

                    //Verification
                    do {
                        System.out.print("Veuillez choisir une action (1, 2 ou 3): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Saisie invalide. Veuillez choisir une valeur de type entier (1, 2 ou 3): ");
                            scanner.next();
                        }
                        choixMenuJoueur = scanner.nextInt();
                    } while (choixMenuJoueur < 1 || choixMenuJoueur > 3);

                    
                    if (choixMenuJoueur==1) {
                        System.out.println();
                        System.out.println();
                        String separator3 = "+-------------------------------------------------------------------------------------+";
                        System.out.println(separator3);
                        System.out.printf("| %-83s |\n", "                                 LISTE DES ATTAQUES");
                        System.out.println(separator3);
                        System.out.printf("| %-25s  %-25s  %-16s  %-11s |\n", "Numero de l'attaque", "Nom de l'attaque", "Dégats", "Cout(PP)");
                        System.out.println(separator3);
                        System.out.printf("| %-28s %-25s  %-20d  %-4d  |\n", "1", NOM_ATTAQUE_1, ATTAQUE_GRIFFE_DEGAT, ATTAQUE_GRIFFE_COUT);
                        System.out.println(separator3);
                        System.out.printf("| %-28s %-25s  %-20d  %-4d  |\n", "2", NOM_ATTAQUE_2, ATTAQUE_FLEMMECHE_DEGAT, ATTAQUE_FLEMMECHE_COUT);
                        System.out.println(separator3);
                        System.out.printf("| %-28s %-25s  %-20d  %-4d  |\n", "3", NOM_ATTAQUE_3, ATTAQUE_DRACO_SOUFFLE_DEGAT, ATTAQUE_DRACO_SOUFFLE_COUT);
                        System.out.println(separator3);
                        System.out.printf("| %-28s %-25s  %-20d  %-4d  |\n", "4", NOM_ATTAQUE_4, ATTAQUE_FEU_ENFER_DEGAT, ATTAQUE_FEU_ENFER_COUT);
                        System.out.println(separator3);

                        do {
                            System.out.print("Veuillez choisir le numero d'attaque(1, 2, 3, ou 4): ");
                            while (!scanner.hasNextInt()) {
                                System.out.print("Saisie invalide. Veuillez choisir le numero d'attaque(1, 2, 3, ou 4): ");
                                scanner.next();
                            }
                            choixAttaqueJoueur =  scanner.nextInt();
                        } while (choixAttaqueJoueur < 1 || choixAttaqueJoueur > 4);
                        System.out.println();
                        switch (choixAttaqueJoueur) {
                            case 1:
                                degatAttaqueChoisit = ATTAQUE_GRIFFE_DEGAT;
                                coutChoixAttaque = ATTAQUE_GRIFFE_COUT;
                                nomAttaque = NOM_ATTAQUE_1;
                                break;
                            case 2:
                                degatAttaqueChoisit = ATTAQUE_FLEMMECHE_DEGAT;
                                coutChoixAttaque = ATTAQUE_FLEMMECHE_COUT;
                                nomAttaque = NOM_ATTAQUE_2;
                                break;
                            case 3:
                                degatAttaqueChoisit = ATTAQUE_DRACO_SOUFFLE_DEGAT;
                                coutChoixAttaque = ATTAQUE_DRACO_SOUFFLE_COUT;
                                nomAttaque = NOM_ATTAQUE_3;
                                break;
                            case 4:
                                degatAttaqueChoisit = ATTAQUE_FEU_ENFER_DEGAT;
                                coutChoixAttaque = ATTAQUE_FEU_ENFER_COUT;
                                nomAttaque = NOM_ATTAQUE_4;
                                break;
                            default:
                                break;
                        }
                        
                        if (ppPokemonJoueur < coutChoixAttaque) {
                            System.out.println("Vous n'avez pas assez de points de pouvoir pour l'attaque "+nomAttaque+"!");
                        } else if (ppPokemonJoueur >= coutChoixAttaque){
                            probabiliteAttaque = random.nextInt(100);
                            if(probabiliteAttaque >= 0 && probabiliteAttaque <= 20){
                                ppPokemonJoueur -= coutChoixAttaque;
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator2);
                                System.out.printf("| %-26s |\n","     MESSAGE DU JEU");
                                System.out.println(separator2);
                                System.out.printf("| %-26s |\n", "ATTAQUE "+nomAttaque+" RATER !");
                                System.out.println(separator2);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                //Ennemi Attaque 
                                probabiliteAttaque = random.nextInt(100);
                                if (probabiliteAttaque >= 0 && probabiliteAttaque <= 20) {
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator2);
                                    System.out.printf("| %-26s |\n","     MESSAGE DU JEU");
                                    System.out.println(separator2);
                                    System.out.printf("| %-26s |\n", "L'ADVERSAIRE A RATER SON ATTAQUE !");
                                    System.out.println(separator2);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                } else if(probabiliteAttaque > 20 && probabiliteAttaque <= 95){
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator4);
                                    System.out.printf("| %-45s |\n","     L'ADVERSAIRE A REUSSI SON ATTAQUE !");
                                    System.out.println(separator4);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                    pvPokemonJoueur -= paPokemonAdversaire;
                                }
                                else if (probabiliteAttaque > 95 && probabiliteAttaque <= 100){
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator4);
                                    System.out.printf("| %-45s |\n","     COUT CRITIQUE DE L'ADVERSAIRE REUSSI !");
                                    System.out.println(separator4);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                    pvPokemonJoueur -= (paPokemonAdversaire*2);
                                }
                            } else if(probabiliteAttaque > 20 && probabiliteAttaque <= 95){
                                ppPokemonJoueur -= coutChoixAttaque;
                                pvPokemonAdverse -= degatAttaqueChoisit;
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator2);
                                System.out.printf("| %-26s |\n","     MESSAGE DU JEU");
                                System.out.println(separator2);
                                System.out.printf("| %-26s |\n", "ATTAQUE "+nomAttaque+" REUSSI !");
                                System.out.println(separator2);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                //Attaque de l'ennemi
                                probabiliteAttaque = random.nextInt(100);
                                if (probabiliteAttaque >= 0 && probabiliteAttaque <= 20) {
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator2);
                                    System.out.printf("| %-26s |\n","     MESSAGE DU JEU");
                                    System.out.println(separator4);
                                    System.out.printf("| %-26s |\n", "L'ADVERSAIRE A RATER SON ATTAQUE !");
                                    System.out.println(separator2);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);
                                } else if(probabiliteAttaque > 20 && probabiliteAttaque <= 95){
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator4);
                                    System.out.printf("| %-45s |\n","     L'ADVERSAIRE A REUSSI SON ATTAQUE !");
                                    System.out.println(separator4);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                    pvPokemonJoueur -= paPokemonAdversaire;
                                }
                                else if (probabiliteAttaque > 95 && probabiliteAttaque <= 100){
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator4);
                                    System.out.printf("| %-45s |\n","     COUT CRITIQUE DE L'ADVERSAIRE REUSSI !");
                                    System.out.println(separator4);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                    pvPokemonJoueur -= (paPokemonAdversaire*2);
                                }

                            } else if(probabiliteAttaque > 95 && probabiliteAttaque <= 100){
                                ppPokemonJoueur -= coutChoixAttaque;
                                pvPokemonAdverse -= (coutChoixAttaque*2);
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     COUT CRITIQUE REUSSI !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                pvPokemonJoueur -= (paPokemonAdversaire*2);
                                

                                //Ennemi Attaque
                                probabiliteAttaque = random.nextInt(100);
                                if (probabiliteAttaque >= 0 && probabiliteAttaque <= 20) {
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator2);
                                    System.out.printf("| %-26s |\n","     MESSAGE DU JEU");
                                    System.out.println(separator2);
                                    System.out.printf("| %-26s |\n", "L'ADVERSAIRE A RATER SON ATTAQUE !");
                                    System.out.println(separator2);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);
                                } else if(probabiliteAttaque > 20 && probabiliteAttaque <= 95){
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator4);
                                    System.out.printf("| %-45s |\n","     L'ADVERSAIRE A REUSSI SON ATTAQUE !");
                                    System.out.println(separator4);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                    pvPokemonJoueur -= paPokemonAdversaire;

                                }
                                else if (probabiliteAttaque > 95 && probabiliteAttaque <= 100){
                                    Thread.sleep(2300);
                                    System.out.println();
                                    System.out.println(separator4);
                                    System.out.printf("| %-45s |\n","     COUT CRITIQUE DE L'ADVERSAIRE REUSSI !");
                                    System.out.println(separator4);
                                    System.out.println();
                                    System.out.println();
                                    Thread.sleep(1500);

                                    pvPokemonJoueur -= (paPokemonAdversaire*2);
                                }
                            }
                        }
                    } else if (choixMenuJoueur==2){
                        probaFuiteJoueur =  random.nextInt(100);
                        if(probaFuiteJoueur >= 0 && probaFuiteJoueur <= 30){
                            Thread.sleep(2300);
                            System.out.println();
                            System.out.println(separator4);
                            System.out.printf("| %-45s |\n","     VOUS AVEZ FUIT !");
                            System.out.println(separator4);
                            System.out.println();
                            System.out.println();

                            pvPokemonAdverse = 0;
                            valeurFuite = true;
                            Thread.sleep(1500);
                        } else{
                            //Adversaire attaque

                            probabiliteAttaque = random.nextInt(100);
                            if (probabiliteAttaque >= 0 && probabiliteAttaque <= 20) {
                                Thread.sleep(2300);

                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     TENTATIVE DE FUITE ECHOUER !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();

                                pvPokemonAdverse = 0;
                                valeurFuite = true;
                                Thread.sleep(1500);
                                System.out.println();
                                System.out.println(separator2);
                                System.out.printf("| %-26s |\n","     MESSAGE DU JEU");
                                System.out.println(separator2);
                                System.out.printf("| %-26s |\n", "L'ADVERSAIRE A RATER SON ATTAQUE !");
                                System.out.println(separator2);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                            } else if(probabiliteAttaque > 20 && probabiliteAttaque <= 95){
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     TENTATIVE DE FUITE ECHOUER !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     L'ADVERSAIRE A REUSSI SON ATTAQUE !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                pvPokemonJoueur -= paPokemonAdversaire;

                            }
                            else if (probabiliteAttaque > 95 && probabiliteAttaque <= 100){
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     TENTATIVE DE FUITE ECHOUER !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     COUT CRITIQUE DE L'ADVERSAIRE REUSSI !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                pvPokemonJoueur -= (paPokemonAdversaire*2);
                            }
                        }
                    } else if (choixMenuJoueur == 3){
                        Thread.sleep(2300);
                        System.out.println();
                        System.out.println(separator2);
                        System.out.printf("| %-26s |\n", nomPokemon+"  NE FAIT RIEN !");
                        System.out.println(separator2);
                        System.out.println();
                        System.out.println();

                        //Attaque de l'adversaire
                        probabiliteAttaque = random.nextInt(100);
                            if (probabiliteAttaque >= 0 && probabiliteAttaque <= 20) {
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","       MESSAGE DU JEU");
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n", "L'ADVERSAIRE A RATER SON ATTAQUE !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                            } else if(probabiliteAttaque > 20 && probabiliteAttaque <= 95){
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     L'ADVERSAIRE A REUSSI SON ATTAQUE !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                pvPokemonJoueur -= paPokemonAdversaire;

                            }
                            else if (probabiliteAttaque > 95 && probabiliteAttaque <= 100){
                                Thread.sleep(2300);
                                System.out.println();
                                System.out.println(separator4);
                                System.out.printf("| %-45s |\n","     COUT CRITIQUE DE L'ADVERSAIRE REUSSI !");
                                System.out.println(separator4);
                                System.out.println();
                                System.out.println();
                                Thread.sleep(1500);

                                pvPokemonJoueur -= (paPokemonAdversaire*2);
                            }
                    }

                } while (pvPokemonJoueur > 0 && pvPokemonAdverse > 0 && (ppPokemonJoueur >= coutChoixAttaque));
                if(pvPokemonJoueur > 0 && pvPokemonAdverse <= 0 && valeurFuite.equals(Boolean.FALSE)){
                    nombreVictoireJoueur += 1;

                    System.out.println();
                    System.out.println(separator4);
                    System.out.printf("| %-45s |\n","       MESSAGE DU JEU");
                    System.out.println(separator4);
                    System.out.printf("| %-45s |\n", "  COMBAT REMPORTÉ !");
                    System.out.println(separator4);
                    System.out.println();
                    System.out.println();

                    proceder = true;
                } else if(pvPokemonJoueur <= 0){
                    System.out.println(nomPokemon+" S'EST EVANOUI !");
                    System.out.println();
                    System.out.println();
                    Thread.sleep(1000);
                    String separator = "+------------------------+----------------------+";
                    System.out.println(separator);
                    System.out.println("|          STATISTIQUES DU COMBAT               |");
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PV DE " + nomPokemon, pvPokemonJoueur);
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PP DE " + nomPokemon, ppPokemonJoueur);
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PV ADVERSAIRE ", pvPokemonAdverse);
                    System.out.println(separator);
                    System.out.printf("| %-23s  %20d |\n", "PA ADVERSAIRE", paPokemonAdversaire);
                    System.out.println(separator);
                    System.out.printf("| %-25s  %18d |\n", "Nombre de victoire de " + nomPokemon, nombreVictoireJoueur);
                    System.out.println(separator);
                    System.out.println();

                    proceder = false;
                } else if(pvPokemonJoueur > 0 && valeurFuite.equals(Boolean.TRUE)){
                    proceder = false;
                }
            } while (proceder);

            System.out.println();
            System.out.println();

            System.out.print("Voulez vous rejouer ? (O/N): ");
            reponseRejouer = scannerText.nextLine();
            
        } while (reponseRejouer.equalsIgnoreCase("O"));
    }
}
