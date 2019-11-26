package service;

import java.util.HashMap;
import java.util.TreeMap;

import entities.Additif;
import entities.Produit;
import entities.Stock;
import outils.ComparatorOccurenceAdditif;

public class RechercheAdditifPlusCourant {
	
	public static void rechercherAdditifPlusCourant(Stock stock){
		HashMap<Additif,Integer> occurencesAdditif= new HashMap<Additif,Integer>();
		for(Produit p : stock.getListeProduits()){
			for(Additif a : p.getListeAdditifs()){
				if(!occurencesAdditif.containsKey(a)){
					occurencesAdditif.put(a, 1);
				}else{
					occurencesAdditif.put(a, occurencesAdditif.get(a)+1);
				}
			}
		}
		ComparatorOccurenceAdditif co= new ComparatorOccurenceAdditif(occurencesAdditif);
		// On trie la liste par ordre décroissant
		TreeMap<Additif,Integer> listeTriee= new TreeMap<Additif, Integer>(co);
		listeTriee.putAll(occurencesAdditif);
		
		System.out.println("Additif : nombre d'occurences");
		for(Additif a : listeTriee.keySet()){
			System.out.println(a+" : "+listeTriee.get(a));
		}
	}

}
