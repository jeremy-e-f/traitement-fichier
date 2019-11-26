package service;

import java.util.Scanner;

import Exception.FunctionnalException;
import entities.Categorie;
import entities.Produit;
import entities.Stock;

public class RechercheMeilleurProduitCategorieService {

	public static void rechercherMeilleurProduit(Stock stock) throws FunctionnalException{
		Scanner saisie= new Scanner(System.in);
		System.out.println("Veuillez saisir la categorie de produit: ");
		String nomCategorie= saisie.next();
		saisie.close();
		
		if(nomCategorie.isEmpty()){
			throw new FunctionnalException("Pas de categorie spécifiée!");
		}
		Categorie categorie= stock.getCategorie(nomCategorie);
		if(categorie== null){
			throw new FunctionnalException("Categorie inconnue!");
		}
		for(Produit produit: stock.getListeProduits()){
			if(produit.getCategorie().equals(categorie) && produit.getScoreNutritionnel()== 'a'){
				System.out.println(produit);
			}
		}
	}
	
}