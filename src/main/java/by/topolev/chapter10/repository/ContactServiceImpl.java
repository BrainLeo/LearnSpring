package by.topolev.chapter10.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import by.topolev.chapter10.domain.Contact;

@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}
	
	@Transactional(readOnly = true)
	public List<Contact> findByFirstName(String firstName) {
		return Lists.newArrayList(contactRepository.findByFirstName(firstName));
	}
	
	@Transactional(readOnly = true)
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
		return Lists.newArrayList(contactRepository.findByFirstNameAndLastName(firstName, lastName));
	}

}
