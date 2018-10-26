package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerEAO {
	
	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;
	
	public void registrerDeltager(Deltager deltager) {
		em.persist(deltager);
	}
	
	public List<Deltager> hentDeltagere() {
		return (List<Deltager>) em.createNativeQuery("SELECT * FROM dat108oblig3.deltager", Deltager.class).getResultList();
	}
	
	public Deltager hentDeltager(String mobil) {
		return em.find(Deltager.class, mobil); 
	}
	
	public boolean erMobilLedig(String mobil) {
		return hentDeltager(mobil) == null;
	}
}
