package by.topolev.chapter10.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.topolev.chapter10.domain.Contact;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private Log log = LogFactory.getLog(ContactServiceImpl.class);

	@PersistenceContext
	private EntityManager emf;

	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		List<Contact> contacts = emf.createNamedQuery("Contact.findAll", Contact.class).getResultList();
		return contacts;
	}

	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = emf.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

	public Contact findById(Long id) {
		TypedQuery<Contact> query = emf.createNamedQuery("Contact.findById", Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			log.info("Insert contact");
			emf.persist(contact);
		} else {
			log.info("Update contact");
			emf.merge(contact);
		}
		log.info("Contact saved with id: " + contact.getId());
		return contact;
	}

	public void delete(Contact contact) {
		log.info("Remove the record with id: " + contact.getId());
		Contact mergeContact = emf.merge(contact);
		emf.remove(mergeContact);

	}

}
