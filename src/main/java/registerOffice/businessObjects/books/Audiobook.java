package registerOffice.businessObjects.books;

public class Audiobook extends Book{

	@Override
	public String getBookDetails() {
		// TODO Auto-generated method stub
		return "This is an audiobook.";
	}

	@Override
	public Book Clone() {
		// TODO Auto-generated method stub
		return null;
	}
}

