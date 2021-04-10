package org.auron.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.auron.exception.SorteioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SorteadorTest {
	
	private Participante p1;
	
	private Participante p2;
	
	private Participante p3;
	
	private List<Participante> participantes;
	
	private Sorteio sorteio;
	

	@BeforeEach
	void setUp() throws Exception {
		
		p1 = new Participante();
		p1.setNome("Maria");
		
		p2 = new Participante();
		p2.setNome("João");
		
		p3 = new Participante();
		p3.setNome("Pedro");
		
		participantes = Arrays.asList(p1, p2, p3);
		sorteio = new Sorteio();
		
	}
	
	@Test
	public void aQuantidadeDeParesEParticipantesDeveSerAMesma() throws SorteioException {
		int quantidadeDeParticipantes = participantes.size();
		
		Sorteador sorteador = new Sorteador(sorteio, participantes);
		sorteador.sortear();
		
		int quantidadesDePares = sorteio.getQuantidadesDePares();
		
		assertTrue(quantidadesDePares == quantidadeDeParticipantes);		
	}
	
	@Test
	public void naoDeveAceitarUmaListaDeParticipantesComMenosDeDoisParticipantes() throws SorteioException { 
	    Sorteador sorteador = new Sorteador(sorteio, new ArrayList());
	    sorteador.sortear();
	}
	
	@Test
	public void naoDeveRepetirUmAmigo() throws SorteioException {
	    Sorteador sorteador = new Sorteador(sorteio, participantes);
	    sorteador.sortear();

	    Set<Par> pares = sorteio.getPares();
	    Iterator<Par> it = pares.iterator();

	    Par par = it.next();
	    Par par2 = it.next();
	    Par par3 = it.next();

	    Participante amigo1 = par.getAmigo();
	    Participante amigo2 = par2.getAmigo();
	    Participante amigo3 = par3.getAmigo();

	    assertFalse(amigo1.equals(amigo2));
	    assertFalse(amigo2.equals(amigo3));
	    assertFalse(amigo3.equals(amigo1));
	}

}
