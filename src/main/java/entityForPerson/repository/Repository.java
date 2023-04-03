package entityForPerson.repository;

import entityForPerson.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository
@Transactional
public class Repository {
    @PersistenceContext
    public EntityManager entityManager;

    public List getPersons(String city) {
        Query query = entityManager.createQuery("select p from Persons p  where p.city_of_living = :city", Persons.class);
        query.setParameter("city", city);

        return query.getResultList();
    }
}
