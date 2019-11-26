package daos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import entities.Additif;
import entities.Allergene;
import entities.Categorie;
import entities.Ingredient;
import entities.Marque;
import entities.Produit;
import entities.Stock;
import outils.ComparatorProduit;

public class RessourcesDAO extends Ressources{
	
	private Stock stock;
	
	public RessourcesDAO(){
		super();
		extraireProduitsDAO();
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void extraireProduitsDAO(){
		
		this.stock= new Stock();
		
		File file = new File("D:/Work/Programmation/JAVA/traitement-fichier/src/main/resources/open-food-facts.csv");
		try {
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			for(int i= 1; i< lignes.size(); i++){
				//System.out.println(lignes.get(i));
				String elements[]= lignes.get(i).split("\\|");
				String nomProduit= elements[0].trim();
				char scoreNutritionnel= elements[1].trim().charAt(0);
				Categorie categorie= stock.addCategorie(elements[2].trim());
				Marque marque= stock.addMarque(elements[3].trim());
				String libellesIngredient= elements[4].trim();
				double energie= 0;
				double graisse= 0;
				double graisseSaturee= 0;
				double hydratesCarbones= 0;
				double sucres= 0;
				double fibres= 0;
				double proteines= 0;
				double sel= 0;
				
				try{
					energie= ((elements[5].trim().equals(""))?0:Double.parseDouble(elements[5].trim()));
					graisse= ((elements[6].trim().equals(""))?0:Double.parseDouble(elements[6].trim()));
					graisseSaturee= ((elements[7].trim().equals(""))?0:Double.parseDouble(elements[7].trim()));
					hydratesCarbones= ((elements[8].trim().equals(""))?0:Double.parseDouble(elements[8].trim()));
					sucres= ((elements[9].trim().equals(""))?0:Double.parseDouble(elements[9].trim()));
					fibres= ((elements[10].trim().equals(""))?0:Double.parseDouble(elements[10].trim()));
					proteines= ((elements[11].trim().equals(""))?0:Double.parseDouble(elements[11].trim()));
					sel= ((elements[12].trim().equals(""))?0:Double.parseDouble(elements[12].trim()));
				}catch(Exception e){
					System.err.println("\n"+e.getMessage());
					e.printStackTrace();
				}
				
				/* ... */
				String libellesAllergene= elements[30].trim();
				String libellesAdditif= elements[31].trim();
				
				Produit produit= new Produit(nomProduit, categorie, marque, scoreNutritionnel, traitementIngredient(libellesIngredient), traitementAllergene(libellesAllergene), traitementAdditif(libellesAdditif), energie, graisse, graisseSaturee, hydratesCarbones, sucres, fibres, proteines, sel);
				stock.addProduit(produit);
			}
			System.out.println("Nombre de lignes :" + lignes.size());
			stock.getListeProduits().sort(new ComparatorProduit());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Allergene> traitementAllergene(String libellesAllergene){
		ArrayList<Allergene> listeAllergenes= new ArrayList<Allergene>();
		String[] listeLibelles= null;
		listeLibelles= libellesAllergene.replaceAll("\\[|\\]|fr:\\s*|\\*","").replace(", ",",").split(",");
		for(int i= 0; i< listeLibelles.length; i++){
			listeAllergenes.add(this.stock.addAllergene(listeLibelles[i].trim().toLowerCase()));
		}
		return listeAllergenes;
	}
	
	public ArrayList<Additif> traitementAdditif(String libellesAdditif){
		ArrayList<Additif> listeAdditifs= new ArrayList<Additif>();
		String[] listeLibelles= null;
		listeLibelles= libellesAdditif.replaceAll("\\[|\\]","").replace(", ",",").split(",");
		for(int i= 0; i< listeLibelles.length; i++){
			listeAdditifs.add(this.stock.addAdditif(listeLibelles[i].trim().toLowerCase()));
		}
		return listeAdditifs;
	}
	
	public ArrayList<Ingredient> traitementIngredient(String libellesIngredient){
		ArrayList<Ingredient> listeIngredients= new ArrayList<Ingredient>();
		String[] listeLibelles= null;
		listeLibelles= libellesIngredient.replaceAll("\\[|\\]|\\.|_|\\*|[0-9]+\\s*%|\\s*\\(\\s*|\\s*\\)\\s*","").split(",|;|\\s+-\\s+");
		for(int i= 0; i< listeLibelles.length; i++){
			listeIngredients.add(this.stock.addIngredient(listeLibelles[i].replaceAll("\\s+[0-9]+$","").trim().toLowerCase()));
		}
		return listeIngredients;
	}
	
}
