package entities;

public class Allergene {
	
	private String libelle;

	public Allergene(String libelle) {
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
		if(!(o instanceof Allergene))
			return false;
		return libelle.equals(((Allergene)o).libelle);
	}

}
