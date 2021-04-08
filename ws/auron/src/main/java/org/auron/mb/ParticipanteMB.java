package org.auron.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.auron.dao.ParticipanteDAO;
import org.auron.entity.Participante;

@Named
@RequestScoped
public class ParticipanteMB {

    private Participante participante = new Participante();
    
    @Inject
    private ParticipanteDAO participanteDao;


    public void cadastrar() {
    	participanteDao.inserir(participante);
    }

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
}
