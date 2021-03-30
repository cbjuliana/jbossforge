package org.auron.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.auron.entity.Participante;

@Named
@RequestScoped
public class ParticipanteMB {

    private Participante participante = new Participante();

    public void cadastrar() {
        System.out.println(participante.getNome());
    }

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
}
