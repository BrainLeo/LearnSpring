package by.topolev.chapter10.service;

import java.util.List;

import by.topolev.chapter10.domain.Contact;

public interface ContactService {
	public List<Contact> findAll();
	public List<Contact> findAllWithDetail();
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public void delete(Contact contact);
}
