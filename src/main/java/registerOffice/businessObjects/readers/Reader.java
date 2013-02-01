package registerOffice.businessObjects.readers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import registerOffice.businessObjects.books.*;
//biblioteki nieimportowane
//import javax.persistence.Transient;
//import registerOffice.Context;



@Entity //tworzenie tabeli z czytelnikami
@Table(name = "Readers")
@NamedQueries({
	@NamedQuery(
			name="Reader.all",
			query="from Reader p"
			),
	@NamedQuery(
			name="Reader.id",
			query="from Reader p where id= :id"
			),
	@NamedQuery(
			name="Reader.delete",
			query="Delete from Reader p where id=:id"
			)
})
public class Reader {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Name") //okreslenie kolumny glownej
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Book> books;
	private String firstname;
	private String pesel;
	private String address;
	private String city;
	
	//konstruktor
	public Reader(String firstname, String name, String pesel, String address, String city)
	{
		//context= Context.getInstance();
		//context.raisenumberOfPeople();
		this.firstname=firstname;
		this.name=name;
		this.address=address;
		this.pesel=pesel;
		this.city=city;
		this.books=new ArrayList<Book>();
	}
	

	//wlasciwosci
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname= firstname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	/*@Transient
	Context context;*/
	
	/*public Reader(String name, String pesel, String address) //wrzucał do SQL
	{
		this(name,pesel);
		this.address=address;
	}*/
	
	/*public Reader(String name) {	
		this(name,"");
	}
	
	public Reader()
	{
		this("","");
	}*/
	
	/*@Override
	protected void finalize() throws Throwable {
		context.reducePeople();
		super.finalize();
	}*/
	
}
