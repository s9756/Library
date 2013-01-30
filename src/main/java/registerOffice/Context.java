/*package registerOffice;

public final class Context {

	private int quantityOfBooks;
	private int quantityOfPeople;
	
	private Context() {
	}

	private static Context instance;

	public static Context getInstance() {
		
		if (instance == null)
			synchronized (Context.class) {
				if (instance == null)
					instance = new Context();
			}
		return instance;
	}
	
	public void reduceBooks()
	{
		this.quantityOfBooks--;
	}
	
	public void reducePeople()
	{
		this.quantityOfPeople--;
	}
	public void raiseNumberOfBooks()
	{
		this.quantityOfBooks++;
	}

	public void raisenumberOfPeople()
	{
		this.quantityOfPeople++;
	}
	
	public int getQuantityOfPeople()
	{
		return this.quantityOfPeople;
	}
	public int getQuantity()
	{
		return this.quantityOfBooks;
	}
}
*/