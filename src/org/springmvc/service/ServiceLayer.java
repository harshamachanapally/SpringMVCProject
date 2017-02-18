package org.springmvc.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.SerializableBlobProxy;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springmvc.controller.Address;
import org.springmvc.controller.Skill;
import org.springmvc.controller.Student;

@Service
public class ServiceLayer implements Serializable{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addAddress(Address address){
		Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(address);
			session.getTransaction().commit();
			session.close();
	}
	public List<Address> checkAddress(Address address){
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("Address.check");
		query.setParameter(0, address.getStreet());
		query.setParameter(1, address.getCity());
		query.setParameter(2, address.getCountry());
		query.setParameter(3, address.getPincode());
		List<Address> list = query.list();
		session.close();
		
		return list;
	}
	
	public Skill getSkill(String skill){
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("Skill.byskill");
		query.setParameter(0, skill);
		List<Skill> list = query.list();
		session.close();
		return list.get(0);
	}
	public void addstudent(Student student){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		Hibernate.initialize(student.getStudentSkill());
		session.getTransaction().commit();
		session.close();
	}
	
	
	/*public void addstudent(Student student){
		
		ArrayList<Skill> coll = new ArrayList<Skill>();
		coll = (ArrayList<Skill>) student.getStudentSkill();
		Iterator<Skill> it = coll.iterator();
		Session session = sessionFactory.openSession();
		int reach = coll.size();
		int count=0;
		while(it.hasNext()){
			session.beginTransaction();
			Skill skillobj=null;
			//skillobj =  it.next();
			Query query =  session.getNamedQuery("Skill.byskill");
			query.setParameter(0, it.next().getSkill());
			List<Skill> list = (List<Skill>) query.list();
			skillobj = list.get(0);
			skillobj.getStudent().add(student);
			session.update(skillobj);
			System.out.println(skillobj.getStudent().size());
			if(count==reach)
			session.save(student);
			System.out.println(student.getStudentSkill().size());
			session.getTransaction().commit();
			System.out.println("comit");
			count++;
		}
		session.close();
	}*/
	
	public boolean studentcheck(Student student){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query =  session.getNamedQuery("Student.bystudentName");
		query.setParameter(0, student.getstudentName());
		query.setParameter(1, student.getDate());
		List<Student> list = query.list();
		session.close();
		if(list.isEmpty())
		return true;
		else
		return false;
	}
	
}
