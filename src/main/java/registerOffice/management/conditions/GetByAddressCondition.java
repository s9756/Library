package registerOffice.management.conditions;

import registerOffice.businessObjects.readers.Reader;

public class GetByAddressCondition extends Condition<Reader>{

	private String address;
	
	public GetByAddressCondition(String address)
	{
		this.address=address;
	}
	@Override
	protected boolean check(Reader obj) {
		// TODO Auto-generated method stub
		return obj.getAddress().equalsIgnoreCase(address);
	}

}
