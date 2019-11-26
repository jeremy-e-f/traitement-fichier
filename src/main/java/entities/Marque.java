package entities;

public class Marque {
	
	private String nom;

	public Marque(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString(){
		return this.nom;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Marque))
			return false;
		return nom.equals(((Marque)o).nom);
	}

}
