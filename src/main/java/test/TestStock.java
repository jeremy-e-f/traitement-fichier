package test;

import daos.RessourcesDAO;
import entities.Additif;
import entities.Allergene;
import entities.Categorie;
import entities.Ingredient;
import entities.Marque;

public class TestStock {

	public static void main(String[] args) {
		
		RessourcesDAO banqueDonnees= new RessourcesDAO();
		System.out.println(banqueDonnees.getStock().getListeProduits().get(0));
		
		System.out.println("\nListe des allergenes:");
		for(Allergene allergene: banqueDonnees.getStock().getListeAllergenes().values()){
			System.out.println(allergene);
		}
		System.out.println("\nListe des additifs:");
		for(Additif additif: banqueDonnees.getStock().getListeAdditifs().values()){
			System.out.println(additif);
		}
		/*
		System.out.println("\nListe des ingrédients:");
		for(Ingredient ingredient: banqueDonnees.getStock().getListeIngredients().values()){
			System.out.println(ingredient);
		}*/
		System.out.println("\nListe des catégories:");
		for(Categorie categorie: banqueDonnees.getStock().getListeCategories().values()){
			System.out.println(categorie);
		}
		System.out.println("\nListe des marques:");
		for(Marque marque: banqueDonnees.getStock().getListeMarques().values()){
			System.out.println(marque);
		}

	}

}
