package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.books.Audiobook;
import registerOffice.businessObjects.books.Book;
import registerOffice.businessObjects.books.Paperback;
import registerOffice.businessObjects.readers.*;
import registerOffice.management.*;
import registerOffice.management.conditions.Condition;
import registerOffice.management.conditions.GetByAddressCondition;
import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Reader> hib= 
				new HibernatePersonManager(session);
				
		
		Reader arek = new Reader("Arek", "1234", "Klonow 2");
		Book sniad = new Paperback("Sniadanie mistrzow","AAC555");
		Book disc = new Audiobook("Discworld","PPD555",15);
		sniad.setOwner(arek);
		disc.setOwner(arek);
		arek.getBooks().add(sniad);
		arek.getBooks().add(disc);
		
		hib.save(arek);
		
		List<Reader>results = hib.getAll();
		
		for(Reader p :results)
		{
			System.out.println(p.getName());
		}
		
		
		
//		ManagerInterface<Person> mgr= new HsqlPersonManager();
//		
////		ManagerInterface<Person> mgr= new PersonManager();
////		
//		mgr.save(new Person("Adam","1234","Gdańsk"));
//		mgr.save(new Person("Paweł","12345","Elbląg"));
//		mgr.save(new Person("Michał","12344","Gdańsk"));
//		mgr.save(new Person("Ola","1234534","Gdynia"));
//		mgr.save(new Person("Ania","1236544","Sopot"));
//		mgr.save(new Person("Adam","12342","Sopot"));
//		mgr.save(new Person("Adam","12344","Gdańsk"));
//		mgr.save(new Person("Adam","12354","Gdynia"));
////		
//		for(Person p: mgr.getAll())
//			System.out.println(p.getName());
//		
//		Condition<Person> byname=new GetByNameCondition("Adam");
//		Condition<Person> byaddress=new GetByAddressCondition("Sopot");
//		Condition<Person> mainCondition=new Condition<Person>()
//				{
//					@Override
//					protected boolean check(Person obj) {
//						return true;
//					}};
//		
//		byname.setCondition(byaddress);
//		mainCondition.setCondition(byname);
//		for(Person p:mgr.getAll(mainCondition))
//		{
//			System.out.println(p.getName()
//					+" "
//					+p.getAddress()
//					+" "+ p.getPesel());
//		}
//		
	}

}
