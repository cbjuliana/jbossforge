package org.auron.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.auron.entity.Participante;

@Stateless
public class ParticipanteDAO {

    @PersistenceContext(name = "auron")
    private EntityManager em;

    public void inserir(Participante participante) {
        em.persist(participante);
    }

}
