package by.topolev.chapter10.repository;

import java.util.List;

import by.topolev.chapter10.domain.Contact;

public interface ContactService {
	public List<Contact> findAll();
	public List<Contact> findByFirstName(String firstName);
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
