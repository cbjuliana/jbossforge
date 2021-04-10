package org.auron.mb;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.auron.entity.Participante;
import org.auron.entity.Sorteador;
import org.auron.entity.Sorteio;
import org.auron.exception.SorteioException;

@Named
@RequestScoped
public class SorteioMB {

	private Sorteio sorteio = new Sorteio();

	public Sorteio getSorteio() {
		return sorteio;
	}

	public void sortear() {
		List<Participante> participantes = new ArrayList<>();
		
        try {
            Sorteador sorteador = new Sorteador(sorteio, participantes);	
			sorteador.sortear();
		} catch (SorteioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
