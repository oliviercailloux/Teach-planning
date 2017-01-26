package teach_planning.teaching;

public class Assignment {

	private String nomEnseignant;
	private String prenomEnseignant;
	private String matière;
	private String typeEnseignement;
	private String promotion;
	
	public Assignment(){
		nomEnseignant="";
		prenomEnseignant="";
		matière="";
		typeEnseignement="";
		promotion="";
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}

	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}

	public String getMatière() {
		return matière;
	}

	public void setMatière(String matière) {
		this.matière = matière;
	}

	public String getTypeEnseignement() {
		return typeEnseignement;
	}

	public void setTypeEnseignement(String typeEnseignement) {
		this.typeEnseignement = typeEnseignement;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	@Override
	public String toString() {
		return "Assignment [nomEnseignant=" + nomEnseignant + ", prenomEnseignant=" + prenomEnseignant + ", matière="
				+ matière + ", typeEnseignement=" + typeEnseignement + ", promotion=" + promotion + "]"+"\n";
	}
}
