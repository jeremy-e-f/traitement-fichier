package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {
	
	private ArrayList<Produit> listeProduits;
	private HashMap<String,Additif> listeAdditifs;
	private HashMap<String,Ingredient> listeIngredients;
	private HashMap<String,Allergene> listeAllergenes;
	private HashMap<String,Categorie> listeCategories;
	private HashMap<String,Marque> listeMarques;
	
	public Stock() {
		listeProduits= new ArrayList<Produit>();
		listeAdditifs= new HashMap<String, Additif>();
		listeIngredients= new HashMap<String, Ingredient>();
		listeAllergenes= new HashMap<String, Allergene>();
		listeCategories= new HashMap<String, Categorie>();
		listeMarques= new HashMap<String, Marque>();
	}

	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(ArrayList<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public HashMap<String, Additif> getListeAdditifs() {
		return listeAdditifs;
	}

	public void setListeAdditifs(HashMap<String, Additif> listeAdditifs) {
		this.listeAdditifs = listeAdditifs;
	}

	public HashMap<String, Ingredient> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(HashMap<String, Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	public HashMap<String, Allergene> getListeAllergenes() {
		return listeAllergenes;
	}

	public void setListeAllergenes(HashMap<String, Allergene> listeAllergenes) {
		this.listeAllergenes = listeAllergenes;
	}
	
	public HashMap<String, Categorie> getListeCategories() {
		return listeCategories;
	}

	public void setListeCategories(HashMap<String, Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}

	public HashMap<String, Marque> getListeMarques() {
		return listeMarques;
	}

	public void setListeMarques(HashMap<String, Marque> listeMarques) {
		this.listeMarques = listeMarques;
	}
	
	/** Fonctions d'ajout */
	
	/**
	 * Ajouter un produit
	 */
	public Produit addProduit(Produit produit){
		listeProduits.add(produit);
		return produit;
	}
	

	/**
	 * Ajoute et renvoie un Allergène
	 * @param libelle
	 */
	public Allergene addAllergene(String libelle){
		Allergene element= getAllergene(libelle);
		if(element!= null){
			return element;
		}
		element= new Allergene(libelle);
		listeAllergenes.put(libelle, element);
		return element;
	}
	
	public Allergene getAllergene(String libelle){
		return listeAllergenes.get(libelle);
	}
	
	
	/**
	 * Ajoute et renvoie une Categorie
	 * @param libelle
	 */
	public Categorie addCategorie(String libelle){
		Categorie element= getCategorie(libelle);
		if(element!= null){
			return element;
		}
		element= new Categorie(libelle);
		listeCategories.put(libelle, element);
		return element;
	}
	
	public Categorie getCategorie(String libelle){
		return listeCategories.get(libelle);
	}
	
	/**
	 * Ajoute et renvoie une Ingredient
	 * @param libelle
	 */
	public Ingredient addIngredient(String libelle){
		Ingredient element= getIngredient(libelle);
		if(element!= null){
			return element;
		}
		element= new Ingredient(libelle);
		listeIngredients.put(libelle, element);
		return element;
	}
	
	public Ingredient getIngredient(String libelle){
		return listeIngredients.get(libelle);
	}
	
	/**
	 * Ajoute et renvoie une Additif
	 * @param libelle
	 */
	public Additif addAdditif(String libelle){
		Additif element= getAdditif(libelle);
		if(element!= null){
			return element;
		}
		element= new Additif(libelle);
		listeAdditifs.put(libelle, element);
		return element;
	}
	
	public Additif getAdditif(String libelle){
		return listeAdditifs.get(libelle);
	}
	
	/**
	 * Ajoute et renvoie une Marque
	 * @param nom
	 */
	public Marque addMarque(String nom){
		Marque element= getMarque(nom);
		if(element!= null){
			return element;
		}
		element= new Marque(nom);
		listeMarques.put(nom, element);
		return element;
	}
	
	public Marque getMarque(String nom){
		return listeMarques.get(nom);
	}
	
}
