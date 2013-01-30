package registerOffice.businessObjects.books;

import registerOffice.businessObjects.readers.Reader;

public interface BookInterface {

	public void printData();
	public void setOwner(Reader owner);
}
