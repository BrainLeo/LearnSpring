package by.topolev.chapter10.repository;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import by.topolev.chapter10.domain.Contact;
import by.topolev.chapter10.domain.ContactTelDetail;

public class Test {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-data-app-context.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);

		List<Contact> contacts = contactService.findAll();
		
		listContacts(contacts);
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
