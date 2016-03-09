package by.topolev.chapter10.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import by.topolev.chapter10.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	public List<Contact> findByFirstName(String firstName);
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
