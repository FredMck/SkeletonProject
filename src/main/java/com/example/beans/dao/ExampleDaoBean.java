package com.example.beans.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.entity.TblEmployee;

/*This is where interactions with the database will take place. Change the PersisrenceContext unitName to be the name of your database*/
@Stateless
@LocalBean
public class ExampleDaoBean {
	
	@PersistenceContext(unitName = "office_phone_list")
	private EntityManager em;

	
	
	
	public List<TblEmployee> readAllEmployeesWithFirstName(String first_name) {
		
		Query query = em.createQuery("from TblEmployee e where first_name = :first_name", TblEmployee.class);
		query.setParameter("first_name", first_name);
		List<TblEmployee> employees = query.getResultList();
		
		return employees;
	}
}
