package registerOffice.businessObjects.books;

import javax.persistence.Entity;

@Entity
public class Audiobook extends Book{

		
	@Override
	public String getBookDetails() {
		// TODO Auto-generated method stub
		return "This is an audiobook.";
	}

	private double length;
	private String title;
	private String signature;

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

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	//konstruktory
		public Audiobook(String title, String signature, double length)
		{
			this.title=title;
			this.signature=signature;
			this.length=length;
		}
	
}

