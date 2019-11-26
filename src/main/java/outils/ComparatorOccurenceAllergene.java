package outils;

import java.util.Comparator;
import java.util.Map;

import entities.Allergene;

/**
 * Par ordre décroissant
 *
 */
public class ComparatorOccurenceAllergene implements Comparator<Allergene>{
	
	private Map<Allergene,Integer> map;
	
	public ComparatorOccurenceAllergene(Map<Allergene,Integer> map){
		this.map= map;
	}
	
	public int compare(Allergene a, Allergene b) {
		return -map.get(a).compareTo(map.get(b));
	}

}
