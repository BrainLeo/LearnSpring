package by.topolev.chapter10.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("contactSummuryUntype")
@Repository
@Transactional
public class ContactSummuryUntypeImpl {
	@PersistenceContext
	EntityManager emf;

	@Transactional(readOnly=true)
	public void displayAllContactSummary(){
		List result = emf.createQuery("select c.firstName, c.lastName, c.firstName, t.telNumber from Contact c left join c.contactTelDetails t where t.telType='Home'").getResultList();
		int count = 0;
		for (Iterator i =result.iterator(); i.hasNext();){
			Object[] values = (Object[]) i.next();
			System.out.println(++count + ": " + values[0] + " "+ values[1] + " " + values[2]);
		}
	}
}

