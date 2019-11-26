package entities;

public class Additif {
	
	private String libelle;

	public Additif(String libelle) {
		super();
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setAdditif(String libelle) {
		this.libelle = libelle;
	}
	
	public String toString(){
		return this.libelle;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Additif))
			return false;
		return libelle.equals(((Additif)o).libelle);
	}

}
