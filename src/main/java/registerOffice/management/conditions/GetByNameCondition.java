package registerOffice.management.conditions;

import registerOffice.businessObjects.readers.Reader;

public class GetByNameCondition extends Condition<Reader>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Reader obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
