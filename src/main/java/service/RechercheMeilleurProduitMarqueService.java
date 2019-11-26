package service;

import java.util.Scanner;

import Exception.FunctionnalException;
import entities.Marque;
import entities.Produit;
import entities.Stock;

public class RechercheMeilleurProduitMarqueService {

	public static void rechercherMeilleurProduit(Stock stock) throws FunctionnalException{
		Scanner saisie= new Scanner(System.in);
		System.out.println("Veuillez saisir la marque de produit: ");
		String nomMarque= saisie.next();
		saisie.close();
		
		if(nomMarque.isEmpty()){
			throw new FunctionnalException("Pas de marque spécifiée!");
		}
		Marque marque= stock.getMarque(nomMarque);
		if(marque== null){
			throw new FunctionnalException("Marque inconnue!");
		}
		for(Produit produit: stock.getListeProduits()){
			if(produit.getMarque().equals(marque) && produit.getScoreNutritionnel()== 'a'){
				System.out.println(produit);
			}
		}
	}
	
}
