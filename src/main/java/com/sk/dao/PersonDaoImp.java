package com.sk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sk.model.Person;

@Repository
public class PersonDaoImp implements PersonDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
//	public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactory=sessionFactory;
//    }

	@Override
	public List<Person> getPersonList() {
		 Session session=this.sessionFactory.getCurrentSession();
	        List<Person> list=session.createQuery("from Person").list();
	        return list;
	}

	@Override
	public void delete(String id) {
		 Session session=this.sessionFactory.getCurrentSession();
		 Person person=(Person)session.get(Person.class,new Integer(id));
	        if(person!=null){ 
	        session.delete(person);
	        }
		
	}

	@Override
	public void insertData(Person person) {
		
		 Session session=this.sessionFactory.getCurrentSession();
	       session.save(person);
		
	}


	@Override
	public Person getPerson(String id) {
		
		Session session=this.sessionFactory.getCurrentSession();
		 Person person=(Person)session.get(Person.class,new Integer(id));
	     return person;
		
		
	}
	
	@Override
	public void updatePerson(Person person) {
		
		 Session session=this.sessionFactory.getCurrentSession();
	      session.update(person);
		
	}


}
