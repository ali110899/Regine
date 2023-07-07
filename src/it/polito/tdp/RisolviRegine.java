package it.polito.tdp;

import java.util.ArrayList;
import java.util.List;

public class RisolviRegine {
	
	/*
	 * PARZIALE lista(inizialmente vuota) delle colonne già occupate compatibile con num COL
	 * 
	 * 
	 */
	
	public List<List<Integer>> trovaRegine(int N) {
		
		//CASO INIZIALE
		List<Integer> parziale = new ArrayList<Integer>();
		List<List<Integer>> soluzioni = new ArrayList<List<Integer>>();
		cercaRegine(soluzioni, N, parziale, 0); 
		//System.out.println(soluzioni);
		
		return soluzioni;
	
	}
	
	//SOLUZIONE PARZIALE 
	public void cercaRegine(List<List<Integer>> soluzioni, int N, List<Integer> parziale, int riga) {
		
		//CASO TERMINALE (quandosolParziale ha 4 elementi
		if(riga==N) {
			//System.out.println(parziale);
			//soluzioni.add(parziale); -->mi stosalvando una reference a una lista che viene eliminata
			soluzioni.add(new ArrayList<Integer>(parziale));
			return;
		}
		
		/**
		 * Cerca di posizionare alla riga "riga"
		 * compatibilmente con le righe già presenti 
		 * nelle righe precedenti.
		 * 
		 * solParziale sono le colonne possibili dove inserirla
		 */
		
		
		for(int col=0; col<N; col++) { //colonna passatami
			if(reginaCompatibile(parziale,col,riga)) {
				//metto reg nella colonna "col"
				parziale.add(col);				//se si faccio per la regina dopo
				cercaRegine(soluzioni, N, parziale, riga+1); 
				parziale.remove(parziale.size()-1);
			}
		}
		
	}
	
	private boolean reginaCompatibile(List<Integer> parziale, int col, int riga) {
		/*
		 * (col - riga) è compatibile?
		 * List<Integer> parziale -> date queste regine(col)
		 */
		
		//Chek riga-colonna
		//per ogni riga(ciclo for) della colonna al posto 1,2...(parziale.get(rigaR) 
		for(int rigaR=0; rigaR<parziale.size(); rigaR++) {
			int colR=parziale.get(rigaR);
			
			if(rigaR==riga) {
				return false;
			}
			if(colR==col) {
				return false;
			}
			
			//Check diagonale
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
