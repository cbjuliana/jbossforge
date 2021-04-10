package org.auron.entity;

import java.util.List;

import org.auron.exception.SorteioException;

public class Sorteador {

	private List<Participante> participantes;
	private int totalDeParticipantes;
	private Sorteio sorteio;

	public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteioException {
		if (participantes == null) {
			new SorteioException("Por favor, insira dois ou mais participantes na lista.");
		}
		this.participantes = participantes;
		this.sorteio = sorteio;
	}

	public void sortear() throws SorteioException {
		int indiceAtual = 0;
		int totalDeParticipantes = participantes.size();
		
		if(totalDeParticipantes < 2) 
            throw new SorteioException("Por favor, insira dois ou mais participantes na lista.");
		
		while (indiceAtual < totalDeParticipantes) {
			if (indiceAtual == totalDeParticipantes - 1) {
				Par par = new Par(participantes.get(indiceAtual), participantes.get(0), sorteio);
				sorteio.adicionaPar(par);
				break;
			}			
			
			Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceAtual + 1), sorteio);
			sorteio.adicionaPar(par);
			indiceAtual++;
		}
	
	}
}
