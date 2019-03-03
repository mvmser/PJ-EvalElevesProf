package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Eleve extends Personne implements Collection {
	
	//---CONSTANTE---
	final int NB_EVALUATIONS = 10; 

	
	//---ATTRIBUTS---
	static private int numIdentifiant;
	private Date dateNaissance;
	private Evaluation evaluation;


	//---CONSTRUCTEURS---
	public Eleve(String nom, String prenom, int numIdentifiant) {
		super(nom, prenom);
		this.numIdentifiant = numIdentifiant;
	}
	public Eleve() {
		super();
	}
	
	
	//---ACCESSEURS : Getteurs--- 
	public int getNumIdentifiant() {
		return numIdentifiant;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	

	//---MOYENNE---
	public double moyenne() {
		double moyenne = 0;
		double total = 0;
		Eleve eleve = new Eleve();
	
		System.out.println("Calcul moyenne de " + eleve.toString());
		
		try {
			if(evaluation.getNote().size() > 0) {
				for (Double note : evaluation.getNote()) {
				    total += note;
				}
				moyenne = total / evaluation.getNote().size();
			}
		}catch(IllegalStateException e) {
			System.out.println(eleve.toString() + " n'a pas de note");
		
		}
		
		return moyenne;
	}
	
	//---MEDIANE---
	public double mediane() {
		double mediane = 0;
		Eleve eleve = new Eleve();
		
		System.out.println("Calcul mediane de " + eleve.toString());
		
		try {
			if(evaluation.getNote().size() > 0) {
				Collections.sort(evaluation.getNote()); //trier les notes
				
				if(evaluation.getNote().size() %2 == 0) 
				{
					int milieu = (evaluation.getNote().size()/2);
					double termeMilieu1 = evaluation.getNote().get(milieu);
					double termeMilieu2 = evaluation.getNote().get(milieu+1);
					mediane = (termeMilieu1 + termeMilieu2)/2;
				}
				else {
					int milieu = (evaluation.getNote().size()/2);
					mediane = evaluation.getNote().get(milieu+1);
				}
			}
		}catch(IllegalStateException e) {
			System.out.println(eleve.toString() + " n'a pas de note");
		}
		return mediane;
	}
	
	//---LISTE CORRECTEUR---
	public Set<Professeur> getCorrecteurs() {
		Professeur correcteur = null;
		
		getCorrecteurs().add(correcteur);
		return null;
		
	}
	
	
	//---TOSTRING---
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") " + "id : " + this.getNumIdentifiant()
		+"\nNotes : " 
		+"\nMoyenne : " + this.moyenne()
		+"\nMediane : " + this.mediane()
		+"\nCorrecteur(s) : ";
	}
	
	
	
	
	
	//---HASHCODE---
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NB_EVALUATIONS;
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((evaluation == null) ? 0 : evaluation.hashCode());
		return result;
	}
	
	//---EQUALS---
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleve other = (Eleve) obj;
		if (NB_EVALUATIONS != other.NB_EVALUATIONS)
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (evaluation == null) {
			if (other.evaluation != null)
				return false;
		} else if (!evaluation.equals(other.evaluation))
			return false;
		return true;
	}
	
	
	
	@Override
	public int size() {
		
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
