package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*This is just an example class that works with my local setup. Change for new projects.*/
/*This class is configured as a Builder Pattern*/
@Entity
@Table(name = "employee_phonelist")
@NamedQueries({
@NamedQuery(name="TblEmployee.getFirstnameById", query="select e.firstName from TblEmployee e where e.id = :id"),
})
public class TblEmployee implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	
	private TblEmployee(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		
	}
	
	private TblEmployee() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

    public static TblEmployeeBuilder builder() {
        return new TblEmployeeBuilder();
    }

	
	public static class TblEmployeeBuilder {
		//private final int id;
		private String firstName;
		private String lastName;
		private String phoneNumber;
		
		
		public TblEmployeeBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public TblEmployeeBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public TblEmployeeBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public TblEmployee build () {
			return new TblEmployee(firstName, lastName, phoneNumber);
		}
	}
}
