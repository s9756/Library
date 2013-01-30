package registerOffice.management.conditions;

import registerOffice.businessObjects.readers.Reader;

public class GetByPeselCondition extends Condition<Reader>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Reader obj) {
		
		return obj.getPesel().equalsIgnoreCase(pesel);
	}

}
