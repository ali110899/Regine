package it.polito.tdp;

import java.util.ArrayList;
import java.util.List;

public class RisolviRegine {
	
	public List<List<Integer>> trovaRegine(int N) {
		List<Integer> parziale = new ArrayList<Integer>();
		List<List<Integer>> soluzioni = new ArrayList<List<Integer>>() ;
		cercaRegine(N, parziale, 0, soluzioni) ;
		return soluzioni ;
//		System.out.println(soluzioni) ;
	}
	
	/* posiziona una regina alla riga 'riga' compatibilmente con le regine
	 * già presenti nelle righe precedenti ('parziale')
	 */
	private void cercaRegine(int N, List<Integer>parziale, int riga, 
			List<List<Integer>> soluzioni) {
		if(riga==N) {
//			System.out.println(parziale) ;
			soluzioni.add(new ArrayList<Integer>(parziale));
			return;
		}
		
		// Genera le soluzioni possibili per questa riga
		for(int col=0; col<N; col++) {
			if(reginaCompatibile(parziale, riga, col) ) {
//				aggiungi la regina alla colonna 'col' nella
//					soluzione parziale ;
				parziale.add(col) ;
				cercaRegine(N, parziale, riga+1, soluzioni) ;
				parziale.remove(parziale.size()-1);
			}
		}
	}
	
	// mettere la regina nella colonna 'col' è compatibile con le regine precedenti
	private boolean reginaCompatibile(List<Integer>parziale, int riga, int col) {

		for(int rigaR=0; rigaR<parziale.size(); rigaR++) {
			int colR = parziale.get(rigaR) ;
			
			if (rigaR==riga)
				return false ;
			if (colR==col)
				return false ;
			if(rigaR-colR == riga-col)
				return false ;
			if(rigaR+colR == riga+col)
				return false ;
		}
		
		return true ;
	}

}
