package registerOffice.businessObjects.books;

import javax.persistence.Entity;


@Entity
public class Paperback extends Book{

	
	private String title;
	private String signature;
	

	//konstruktory
	public Paperback(String title, String signature)
	{
		this.title=title;
		this.signature=signature;
	}
	
	
	//wlasciwosci
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	//metody
	
	@Override
	public String getBookDetails() {
		// TODO Auto-generated method stub
		return title+" "+signature;
	}

}
