package registerOffice.management;

import java.util.List;

import org.hibernate.Session;

import registerOffice.businessObjects.readers.Reader;

public class HibernatePersonManager 
	implements ManagerInterface<Reader>{

	Session session;
	
	public HibernatePersonManager(Session session)
	{
		this.session=session;
	}
	
	@Override
	public Reader get(int id) {
		
		List<Reader> result = 
				session.getNamedQuery("Reader.id")
					.setInteger("id", id).list();
		if(result.size()==0)
			return null;
		
		Reader returnValue = new Reader(
				result.get(0).getFirstname(), 
				result.get(0).getName(), 
				result.get(0).getPesel(),
				result.get(0).getAddress());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	@Override
	public List<Reader> getAll() {
		List<Reader> result =
				session.getNamedQuery("Reader.all")
				.list();
		return result;
	}

	@Override
	public boolean save(Reader obj) {
		
		try{
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){}
		
		return false;
	}

	@Override
	public boolean delete(Reader obj) {
		
		try
		{
			session.beginTransaction();
			session.getNamedQuery("Reader.delete")
			.setInteger("id", obj.getId())
			.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}catch(Exception ex)
		{}
		
		return false;
	}

}
