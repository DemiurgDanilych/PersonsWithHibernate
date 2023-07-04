package com.example.personentity.repository;

import com.example.personentity.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, String> {
    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByAgeLessThanOrderByAge(Integer age);

    Optional<Persons> findByNameAndSurname(String name, String surname);

    @Query(value = "select street from persons p  join contact c on c.street = p.contact_id where p.name = :name", nativeQuery = true)
    List<String> findIdsNameNative(String name);
}
