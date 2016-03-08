package by.topolev.chapter10.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_tel_detail")
public class ContactTelDetail implements Serializable{
	private Long id;
	private String telType;
	private String telNumber;
	private Contact contact;
	
	
	public ContactTelDetail(){	
	}
	
	public ContactTelDetail(String telType, String telNumber){
		this.telType = telType;
		this.telNumber = telNumber;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTelType() {
		return telType;
	}
	public void setTelType(String telType) {
		this.telType = telType;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	@ManyToOne
	@JoinColumn(name="contact_id")
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String toString(){
		return "Id: " + id + " Tel type: " + telType + " Tel number: " + telNumber;
	}
}
