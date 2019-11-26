package entities;

public class Ingredient {
	
	private String libelle;

	public Ingredient(String libelle) {
		super();
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String toString(){
		return this.libelle;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Ingredient))
			return false;
		return libelle.equals(((Ingredient)o).libelle);
	}

}
