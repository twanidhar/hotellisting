package Hotel.hotellisting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional


public class HotelDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Hotel> findAll(String city, Integer pricePerNight) {
		return em.createQuery("FROM Hotel", Hotel.class).getResultList();
	}
	
	public List<Hotel>findByCity(String city){
		return em.createQuery("FROM Hotel WHERE city =:city", Hotel.class)
				.setParameter("city", city).getResultList();
	}

	public Object findCityList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}