package entities;

public class Categorie {
	
	private String libelle;
	
	public Categorie(String libelle) {
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
		if(!(o instanceof Categorie))
			return false;
		return libelle.equals(((Categorie)o).libelle);
	}

}
