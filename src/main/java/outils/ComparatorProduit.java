package outils;

import entities.Produit;
import java.util.Comparator;

public class ComparatorProduit implements Comparator<Produit>{

	public int compare(Produit p1, Produit p2) {
		return -((Character)p1.getScoreNutritionnel()).compareTo(p2.getScoreNutritionnel());
	}

}
