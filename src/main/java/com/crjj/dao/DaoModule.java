package com.crjj.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import com.crjj.model.Module;
import com.crjj.utils.HibernateUtils;

public class DaoModule implements IDAO<Module> {
	SessionFactory sessionFactory;
	@Override
	public List<Module> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Module").list();
	}

	@Override
	public Module getOne(int id) {
		// TODO Auto-generated method stub
		return (Module)sessionFactory.getCurrentSession().createQuery("from Module where id = :moduleId").setParameter("moduleId", id).uniqueResult();
	}

	@Override
	public boolean save(Module obj) {
		try {
			Session s = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			
			s.save(obj);
			System.out.println("1231");
			t.commit();
			s.close();
			
			return true;
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Module obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Module obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
