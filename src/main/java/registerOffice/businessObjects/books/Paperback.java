package registerOffice.businessObjects.books;

import javax.persistence.Entity;


@Entity
public class Paperback extends Book{

	//pole statyczne
	
	//pola prywatne
	
	
	
	private String mark;
	private String registerNumber;
	
	//pola publiczne
	
	//konstruktory
	public Paperback(String mark, String registerNumber)
	{
		this.mark=mark;
		this.registerNumber=registerNumber;
	}
	
	public Paperback()
	{
		this("","");
	}
	
	//wlasciwosci
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	
	//metody
	

	@Override
	public String getBookDetails() {
		// TODO Auto-generated method stub
		return mark+" "+registerNumber;
	}

	@Override
	public Book Clone() {
		
		Paperback returnValue =new Paperback();
		returnValue.setRegisterNumber(this.registerNumber);
		
		return returnValue;
	}
}
