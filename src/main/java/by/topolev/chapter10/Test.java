package by.topolev.chapter10;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import by.topolev.chapter10.domain.Contact;
import by.topolev.chapter10.domain.ContactTelDetail;
import by.topolev.chapter10.service.ContactService;
import by.topolev.chapter10.service.ContactSummuryUntypeImpl;

public class Test {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

		// List without ContactTelDetail
		System.out.println("----BLOCK 1----List without detailes'");
		List<Contact> contacts = contactService.findAll();
		listContacts(contacts);

		// List with ContactTelDetail
		System.out.println("----BLOCK 2----List withDetail");
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);

		// Return the record with defined id
		System.out.println("----BLOCK 3----The record find by Id");
		Contact contact = contactService.findById(1l);
		System.out.println("\n" + contact);
		System.out.println(contact.getContactTelDetails());

		// Summury
		System.out.println("----BLOCK 4--- Test contactSummary");
		ContactSummuryUntypeImpl contactSummary = ctx.getBean("contactSummuryUntype", ContactSummuryUntypeImpl.class);
		contactSummary.displayAllContactSummary();
		
		//Insert record
		System.out.println("----BLOCK 5---- Insert record");
		contact = new Contact();
		contact.setFirstName("Eugeniy");
		contact.setLastName("Kalenchuk");
		contact.setBirthDate(new Date());
		
		ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "111111111");
		contact.addContactTelDetail(contactTelDetail);
		contactTelDetail = new ContactTelDetail("Mob", "222222222");
		contact.addContactTelDetail(contactTelDetail);
		
		contactService.save(contact);
		
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);
		
		//Update record
		System.out.println("----BLOCK 6---- Update record");
		contact = contactService.findById(6l);
		contact.setLastName("TEST UPDATE");
		
		System.out.println(contact);
		System.out.println("----BLOCK 7---- Remove record");
		contactService.delete(contact);
		
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);
		

		
		//Remove record
		
		contactService.save(contact);
		contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);
		
	}

	private static void listContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

	private static void listContactsWithDetail(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("   " + contactTelDetail);
				}
			}
		}
	}
}
