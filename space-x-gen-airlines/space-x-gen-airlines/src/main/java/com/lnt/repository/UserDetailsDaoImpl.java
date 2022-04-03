package com.lnt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lnt.domain.UserDetails;

@Repository //It is one of @component annotation and it is used to indicate storage mechanism 
public class UserDetailsDaoImpl implements UserDetailsDao {

	@PersistenceContext //It keeps track of any changes made to entity manager 
	private EntityManager em;

	@Override
	public List<UserDetails> searchAllUsers() {
		// TODO Auto-generated method stub
		return em.createQuery("select u from UserDetails u", UserDetails.class).getResultList();
	}

	@Override
	public void addNewUser(UserDetails u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@Override
	public UserDetails searchUserById(int id) {
		// TODO Auto-generated method stub
		return em.find(UserDetails.class, id);
	}

	@Override
	public void updateUserDetails(UserDetails u, int id) {
		// TODO Auto-generated method stub
		UserDetails managedCopy = searchUserById(id);
		managedCopy.setFirstName(u.getFirstName());
		managedCopy.setLastName(u.getLastName());
		managedCopy.setEmail(u.getEmail());
		managedCopy.setPhoneNo(u.getPhoneNo());
		managedCopy.setPassword(u.getPassword());
		managedCopy.setDateOfBith(u.getDateOfBirth());
		System.out.println("Updated!!!");

	}

}
