package service;

import java.util.Scanner;

import Exception.FunctionnalException;
import entities.Categorie;
import entities.Marque;
import entities.Produit;
import entities.Stock;

public class RechercheMeilleurProduitMarqueCategorieService {

	public static void rechercherMeilleurProduit(Stock stock) throws FunctionnalException{
		Scanner saisie= new Scanner(System.in);
		System.out.println("Veuillez saisir la categorie de produit: ");
		String nomCategorie= saisie.next();
		
		if(nomCategorie.isEmpty()){
			throw new FunctionnalException("Pas de categorie spécifiée!");
		}
		Categorie categorie= stock.getCategorie(nomCategorie);
		if(categorie== null){
			throw new FunctionnalException("Categorie inconnue!");
		}
		
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
		
		saisie.close();
		
		for(Produit produit: stock.getListeProduits()){
			if(produit.getCategorie().equals(categorie) && produit.getMarque().equals(marque) && produit.getScoreNutritionnel()== 'a'){
				System.out.println(produit);
			}
		}
	}
	
}