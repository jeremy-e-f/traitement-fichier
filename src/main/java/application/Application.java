package application;

import java.util.Scanner;

import Exception.FunctionnalException;
import daos.RessourcesDAO;
import service.RechercheAdditifPlusCourant;
import service.RechercheAllergenePlusCourant;
import service.RechercheMeilleurProduitCategorieService;
import service.RechercheMeilleurProduitMarqueCategorieService;
import service.RechercheMeilleurProduitMarqueService;

public class Application {

	public static void main(String[] args) {
		
		RessourcesDAO banqueDonnees= new RessourcesDAO();
		
		Scanner saisie= new Scanner(System.in);
		String choix;
		byte option= 99;
		do{
			afficherMenu();
			try{
				choix= saisie.nextLine();
				option= Byte.parseByte(choix);
				if(option<0 || option>5){
					throw new FunctionnalException();
				}
			}catch(Exception e){
				System.err.println("Un entier parmi les choix précisés était attendu...");
			}
			
			switch(option){
				case(1):
					try {
						RechercheMeilleurProduitMarqueService.rechercherMeilleurProduit(banqueDonnees.getStock());
					} catch (FunctionnalException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
				break;
				case(2):
					try {
						RechercheMeilleurProduitCategorieService.rechercherMeilleurProduit(banqueDonnees.getStock());
					} catch (FunctionnalException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
				break;
				case(3):
					try {
						RechercheMeilleurProduitMarqueCategorieService.rechercherMeilleurProduit(banqueDonnees.getStock());
					} catch (FunctionnalException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
				break;
				case(4):
					RechercheAllergenePlusCourant.rechercherAllergenePlusCourant(banqueDonnees.getStock());
				break;
				case(5):
					RechercheAdditifPlusCourant.rechercherAdditifPlusCourant(banqueDonnees.getStock());
				break;
			}
		}while(option!= 0);
		saisie.close();
	}
	
	public static void afficherMenu(){
		System.out.println("\nTapez :"+
				"\n1. Pour rechercher les meilleurs produits pour une Marque donnée."+
				"\n2. Pour rechercher les meilleurs produits pour une Catégorie donnée."+
				"\n3. Pour rechercher les meilleurs produits par Marque et par Catégorie."+
				"\n4. Pour afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent"+
				"\n5. Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent"+
				"\n0. Pour terminer.");
	}

}
