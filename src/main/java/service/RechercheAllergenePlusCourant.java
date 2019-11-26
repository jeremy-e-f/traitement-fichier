package service;

import java.util.HashMap;
import java.util.TreeMap;

import entities.Allergene;
import entities.Produit;
import entities.Stock;
import outils.ComparatorOccurenceAllergene;

public class RechercheAllergenePlusCourant {
	
	public static void rechercherAllergenePlusCourant(Stock stock){
		HashMap<Allergene,Integer> occurencesAllergene= new HashMap<Allergene,Integer>();
		for(Produit p : stock.getListeProduits()){
			for(Allergene a : p.getListeAllergenes()){
				if(!occurencesAllergene.containsKey(a)){
					occurencesAllergene.put(a, 1);
				}else{
					occurencesAllergene.put(a, occurencesAllergene.get(a)+1);
				}
			}
		}
		ComparatorOccurenceAllergene co= new ComparatorOccurenceAllergene(occurencesAllergene);
		// On trie la liste par ordre décroissant et affiche les 10 premières occurences
		TreeMap<Allergene,Integer> listeTriee= new TreeMap<Allergene, Integer>(co);
		listeTriee.putAll(occurencesAllergene);
		
		System.out.println("Allergene : nombre d'occurences");
		for(Allergene a : listeTriee.keySet()){
			System.out.println(a+" : "+listeTriee.get(a));
		}
	}

}
