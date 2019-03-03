package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
	
	
	//---TOSTRING---
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") ";
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
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
