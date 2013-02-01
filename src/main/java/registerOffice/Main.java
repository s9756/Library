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
		Reader basia = new Reader("Barbara","Sowka", "82112249874", "Kameliowa 2","Gdynia");
		Reader andrzej = new Reader("Andrzej","Bezgacki", "87051155412", "Stawna 16","Gdynia");
		Reader ania = new Reader("Anna","Smolska", "91011126479", "Polna 1","Gdansk");
				
		//dodawanie ksiazek papierowych
		Book sniad = new Paperback("Sniadanie mistrzow","PAP555");
		Book rok = new Paperback("Rok 1984","PAP487");
		Book carr = new Paperback("Carrie","PAP852");
		Book mort = new Paperback("Mort","PAP987");
		
		//dodawanie audiobookow
		Book disc = new Audiobook("Discworld","AUD555",360);
		Book most = new Audiobook("Most","AUD551",200);
		Book lsnie = new Audiobook("Lsnienie","AUD884",250);
		Book ulica = new Audiobook("Ulica","AUD145",180);
		
		//dodawanie magazynow
		Book play = new Magazine("Playboy","MAG741",2012);
		Book wprost = new Magazine("Wprost","MAG654",2011);
		Book nauka = new Magazine("Nauka","MAG321",2013);
		Book dom = new Magazine("Dom","MAG222",2010);
		
		//przypisanie czytelnikow do wypozyczonych ksiazek
		sniad.setOwner(marek);
		carr.setOwner(marek);
		most.setOwner(marek);
		ulica.setOwner(marek);
		disc.setOwner(basia);
		mort.setOwner(basia);
		dom.setOwner(basia);
		lsnie.setOwner(basia);
		nauka.setOwner(basia);
		play.setOwner(andrzej);
		rok.setOwner(andrzej);
		wprost.setOwner(andrzej);
		
		//przypisanie ksiazek do czytelnikow
		marek.getBooks().add(sniad);
		marek.getBooks().add(carr);
		marek.getBooks().add(ulica);
		marek.getBooks().add(most);
		basia.getBooks().add(disc);
		basia.getBooks().add(mort);
		basia.getBooks().add(lsnie);
		basia.getBooks().add(nauka);
		basia.getBooks().add(dom);
		andrzej.getBooks().add(play);
		andrzej.getBooks().add(rok);
		andrzej.getBooks().add(wprost);
		
		//uzycie hibernate do zapisania danych w tabelach
		hib.save(marek);
		hib.save(basia);
		hib.save(andrzej);
		hib.save(ania);
		
		List<Reader>results = hib.getAll();
		
		for(Reader p :results)
		{
			System.out.println(p.getName());
		}
			
	}

}
