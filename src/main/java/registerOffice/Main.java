package registerOffice;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import registerOffice.businessObjects.books.Audiobook;
import registerOffice.businessObjects.books.Book;
import registerOffice.businessObjects.books.Magazine;
import registerOffice.businessObjects.books.Paperback;
import registerOffice.businessObjects.readers.*;
import registerOffice.management.*;
//biblioteki nieimplementowane
//import java.sql.SQLPermission;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import registerOffice.management.conditions.Condition;
//import registerOffice.management.conditions.GetByAddressCondition;
//import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Reader> hib= 
				new HibernatePersonManager(session);

		//tworzenie czytelnikow
		Reader marek = new Reader("Marek","Wolski", "85121125447", "Klonowa 2","Sopot");
		Reader basia = new Reader("Barbara","Sowka", "65112249874", "Kameliowa 2","Gdynia");
		Reader andrzej = new Reader("Andrzej","Bezgacki", "87051155412", "Stawna 16","Gdynia");

		//dodawanie ksiazek papierowych
		Book sniad = new Paperback("Sniadanie mistrzow","AAC555");
		Book rok = new Paperback("Rok 1984","BBF487");
		
		//dodawanie audiobookow
		Book disc = new Audiobook("Discworld","PPD555",15);
		
		//dodawanie magazynow
		Book play = new Magazine("Playboy","SdC741",2012);
		
		//przypisanie czytelnikow do wypozyczonych ksiazek
		sniad.setOwner(marek);
		disc.setOwner(basia);
		play.setOwner(andrzej);
		rok.setOwner(andrzej);
		
		//przypisanie ksiazek do czytelnikow
		marek.getBooks().add(sniad);
		basia.getBooks().add(disc);
		andrzej.getBooks().add(play);
		andrzej.getBooks().add(rok);
		
		//uzycie hibernate do zapisania danych w tabelach
		hib.save(marek);
		hib.save(basia);
		hib.save(andrzej);
		
		List<Reader>results = hib.getAll();
		
		for(Reader p :results)
		{
			System.out.println(p.getName());
		}
			
	}

}
