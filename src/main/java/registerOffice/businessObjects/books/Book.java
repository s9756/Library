package registerOffice.businessObjects.books;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import registerOffice.businessObjects.readers.Reader;
//import javax.persistence.Transient;
//import registerOffice.Context;

@Entity
public abstract class Book implements BookInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Reader owner; //alias wewnatrz klasy
	
	
	public void printData()
	{
		System.out.println("Reader: "+owner.getName());
		System.out.println(getBookDetails());
	}
	
	public abstract String getBookDetails();
	
	
	public void setOwner(Reader owner)
	{
		this.owner=owner;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*@Override
	protected void finalize() throws Throwable {
		context.reduceBooks();
		super.finalize();
	}*/

	/*@Transient
	Context context;
	public Book(){
		context =Context.getInstance(); //licznik produktow w pamieci
		context.raiseNumberOfBooks();
	}*/
	
}
