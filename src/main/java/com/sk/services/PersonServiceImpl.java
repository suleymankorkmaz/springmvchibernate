package com.sk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.dao.PersonDao;
import com.sk.model.Person;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
    PersonDao personDao;
  
//	public void setPersonDao(PersonDao personDao) {
//		this.personDao = personDao;
//	}
	
	@Override
	@Transactional
	public List<Person> getPersonList() {
		
		
		return personDao.getPersonList();
	}

	@Override
	public void deletePerson(String id) {
		personDao.delete(id);
		
	}

	@Override
	public void insertData(Person person) {
		personDao.insertData(person);
		
	}

	@Override
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
		
	}

	@Override
	public Person getPerson(String id) {
		return personDao.getPerson(id);
	}


}
