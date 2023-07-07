package it.polito.tdp;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	
	public List<Integer> trovaRegine(int N) {
		
		//N numero regine ma anche matrice(i,j)
		//List<List<Integer>> solParziale = new ArrayList<List<Integer>>(); //col a qui è associata una riga
		List<Integer> parziale = new ArrayList<Integer>(); //popolato da "colonne"
		
		//CASO INIZIALE
		cercaRegine(N, parziale, 0);
		
		return parziale;
	}
	
	public void cercaRegine(int N, List<Integer> parziale, int riga) {
		
		//CASO FINALE
		if(riga==N) {
			System.out.print(parziale);
		}
		
		for(int col=0; col<N; col++) { //la colonna va da 0 a N
			//la posizione in col èla mia j, la posizione da riga è la mia i
			if(posizioneConsentita(parziale, riga, col)) { //ritorna ture se posso inserirla
				parziale.add(col); //assegno solo colonna, tanto so che riga sarà solo 1-2-3-4
				//se posso aggiungere passo alla regina successiva e ritono su
				cercaRegine(N, parziale, riga+1); 
				parziale.remove(parziale.size()-1);
				
			}
		}
	}
	
	//passo parziale e col perchè oltre hai valori voglio sapere a che col mi trovo
	public boolean posizioneConsentita(List<Integer> parziale, int riga, int col) {
		//riga(ipotetica posizione)
		//col(ipotetica posizione)
		//RigaR(riga della mia regina aggiunta)
		//ColR(col della mia regina aggiunta) data dal valore della lista parziale in posizione RigaR
		
		for(int rigaR=0; rigaR<parziale.size(); rigaR++) { 
			//rigaR<parziale.size() -->per smettere prima e non andare fino a N
			int colR=parziale.get(rigaR); //quando assegna regina il valore "col" lo inserisce in "parziale"
		
			//CHECK STESSA RIGA-COLONNA
			if(rigaR==riga) {
				return false;
			}
			if(colR==col) {
				return false;
			}
			//CHECK DIAGONALE
			//la somma/differenza dei val rigaR-colR devono essere gli stessi di riga-col --> nella stessa diagonale
			if(rigaR-colR==riga-col) { 
				return false;
			}
			if(rigaR+colR==riga+col) {
				return false;
			}
		}
		
		
		return true;
	}
	
}
