package entities;

import java.util.ArrayList;

public class Produit implements Comparable<Produit>{
	
	private String nom;
	
	private Categorie categorie;
	private Marque marque;
	private char scoreNutritionnel;
	private ArrayList<Ingredient> listeIngredients;
	private ArrayList<Allergene> listeAllergenes;
	private ArrayList<Additif> listeAdditifs;
	
	private double energie;
	private double graisse;
	private double graisseSaturee;
	private double hydratesCarbones;
	private double sucres;
	private double fibres;
	private double proteines;
	private double sel;
	
	public Produit(String nom, Categorie categorie, Marque marque, char scoreNutritionnel, ArrayList<Ingredient> listeIngredients,
			ArrayList<Allergene> listeAllergenes, ArrayList<Additif> listeAdditifs, double energie, double graisse,
			double graisseSaturee, double hydratesCarbones, double sucres, double fibres, double proteines,
			double sel) {
		this.nom= nom;
		this.categorie = categorie;
		this.marque = marque;
		this.scoreNutritionnel = scoreNutritionnel;
		this.listeIngredients = listeIngredients;
		this.listeAllergenes = listeAllergenes;
		this.listeAdditifs = listeAdditifs;
		this.energie = energie;
		this.graisse = graisse;
		this.graisseSaturee = graisseSaturee;
		this.hydratesCarbones = hydratesCarbones;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public char getScoreNutritionnel() {
		return scoreNutritionnel;
	}

	public void setScoreNutritionnel(char scoreNutritionnel) {
		this.scoreNutritionnel = scoreNutritionnel;
	}

	public ArrayList<Ingredient> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(ArrayList<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	public ArrayList<Allergene> getListeAllergenes() {
		return listeAllergenes;
	}

	public void setListeAllergenes(ArrayList<Allergene> listeAllergenes) {
		this.listeAllergenes = listeAllergenes;
	}

	public ArrayList<Additif> getListeAdditifs() {
		return listeAdditifs;
	}

	public void setListeAdditifs(ArrayList<Additif> listeAdditifs) {
		this.listeAdditifs = listeAdditifs;
	}

	public double getEnergie() {
		return energie;
	}

	public void setEnergie(double energie) {
		this.energie = energie;
	}

	public double getGraisse() {
		return graisse;
	}

	public void setGraisse(double graisse) {
		this.graisse = graisse;
	}

	public double getGraisseSaturee() {
		return graisseSaturee;
	}

	public void setGraisseSaturee(double graisseSaturee) {
		this.graisseSaturee = graisseSaturee;
	}

	public double getHydratesCarbones() {
		return hydratesCarbones;
	}

	public void setHydratesCarbones(double hydratesCarbones) {
		this.hydratesCarbones = hydratesCarbones;
	}

	public double getSucres() {
		return sucres;
	}

	public void setSucres(double sucres) {
		this.sucres = sucres;
	}

	public double getFibres() {
		return fibres;
	}

	public void setFibres(double fibres) {
		this.fibres = fibres;
	}

	public double getProteines() {
		return proteines;
	}

	public void setProteines(double proteines) {
		this.proteines = proteines;
	}

	public double getSel() {
		return sel;
	}

	public void setSel(double sel) {
		this.sel = sel;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", categorie=" + categorie + ", marque=" + marque + ", scoreNutritionnel="
				+ scoreNutritionnel + ", listeIngredients=" + listeIngredients + ", listeAllergenes=" + listeAllergenes
				+ ", listeAdditifs=" + listeAdditifs + ", energie=" + energie + ", graisse=" + graisse
				+ ", graisseSaturee=" + graisseSaturee + ", hydratesCarbones=" + hydratesCarbones + ", sucres=" + sucres
				+ ", fibres=" + fibres + ", proteines=" + proteines + ", sel=" + sel + "]";
	}

	public int compareTo(Produit p) {
		return ((Character)p.getScoreNutritionnel()).compareTo(this.getScoreNutritionnel());
	}

}
