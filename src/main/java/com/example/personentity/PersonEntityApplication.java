package com.example.personentity;

import com.example.personentity.entity.Contact;
import com.example.personentity.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PersonEntityApplication {
    @PersistenceContext
    private EntityManager entityManager;

        public static void main(String[] args) {

        SpringApplication.run(PersonEntityApplication.class, args);
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Persons persons = new Persons();
        persons.setName("Stepan");
        persons.setSurname("Kalavshin");
        persons.setAge(33);
        persons.setPhoneNumber("89567419658");
        persons.setCityOfLiving("Ykutsk");
        Contact contact = new Contact();
        contact.setStreet("Dubinina");
        contact.setNumber(14);
        persons.setContact(contact);


        List<Persons> people = List.of(persons);

        people.forEach(entityManager::persist);

        Persons persons1 = new Persons();
        persons1.setName("Dima");
        persons1.setSurname("Pupkin");
        persons1.setAge(28);
        persons1.setPhoneNumber("89567417623");
        persons1.setCityOfLiving("Moskov");
        Contact contact1 = new Contact();
        contact1.setStreet("Lenina");
        contact1.setNumber(3 / 4);
        persons1.setContact(contact1);


        List<Persons> people1 = List.of(persons1);

        people1.forEach(entityManager::persist);

        Persons persons2 = new Persons();
        persons2.setName("Kosty");
        persons2.setSurname("Dorojin");
        persons2.setAge(44);
        persons2.setPhoneNumber("89564489155");
        persons2.setCityOfLiving("Omsk");
        Contact contact2 = new Contact();
        contact2.setStreet("Habarova");
        contact2.setNumber(25);
        persons2.setContact(contact2);


        List<Persons> people2 = List.of(persons2);

        people2.forEach(entityManager::persist);
    }

}
