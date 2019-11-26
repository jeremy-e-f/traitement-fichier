package outils;

import java.util.Comparator;
import java.util.Map;

import entities.Additif;

/**
 * Par ordre décroissant
 *
 */
public class ComparatorOccurenceAdditif implements Comparator<Additif>{
	
	private Map<Additif,Integer> map;
	
	public ComparatorOccurenceAdditif(Map<Additif,Integer> map){
		this.map= map;
	}
	
	public int compare(Additif a, Additif b) {
		return -map.get(a).compareTo(map.get(b));
	}

}
