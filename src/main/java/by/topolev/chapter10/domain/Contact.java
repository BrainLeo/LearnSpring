package by.topolev.chapter10.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@NamedQueries({ 
	@NamedQuery(name = "Contact.findAll", query = "select c from Contact c"),
	@NamedQuery(name = "Contact.findById", query = "select distinct c from Contact c left join fetch c.contactTelDetails t where c.id=:id"),
	@NamedQuery(name = "Contact.findAllWithDetail", query = "select distinct c from Contact c left join fetch c.contactTelDetails t")
})
public class Contact implements Serializable {
	private Long id;
	private String lastName;
	private String firstName;
	private Date birthDate;
	private List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval=true)
	public List<ContactTelDetail> getContactTelDetails() {
		return contactTelDetails;
	}

	public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
		this.contactTelDetails = contactTelDetails;
	}

	public void addContactTelDetail(ContactTelDetail contactTelDetail){
		contactTelDetail.setContact(this);
		getContactTelDetails().add(contactTelDetail);
	}
	
	public String toString(){
		return "Id: " + id + " First name: " + firstName + " Last name: " + lastName + "Birt Day: " + birthDate; 
	}

}
