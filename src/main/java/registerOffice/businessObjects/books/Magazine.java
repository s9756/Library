package registerOffice.businessObjects.books;

import javax.persistence.Entity;

@Entity
public class Magazine extends Book{

		
	@Override
	public String getBookDetails() {
		// TODO Auto-generated method stub
		return "This is a magazine.";
	}

	private String title;
	private String signature;
	private int year;
	
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

	public double getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	//konstruktory
		public Magazine(String title, String signature, int year)
		{
			this.title=title;
			this.signature=signature;
			this.year=year;
		}
	
	/*@Override
	public Book Clone() {
		// TODO Auto-generated method stub
		return null;
	}*/
}

