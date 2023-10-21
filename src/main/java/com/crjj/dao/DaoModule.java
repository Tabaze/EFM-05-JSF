package com.crjj.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.crjj.model.Module;
import com.crjj.utils.HibernateUtils;

public class DaoModule implements IDAO<Module> {
	@Override
	public List<Module> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<Module> commande = s.createQuery("from Module").list();

		t.commit();
		s.close();

		return commande;
	}

	@Override
	public Module getOne(int id) {

		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Module commande = session.get(Module.class, id);

		t.commit();
		session.close();

		return commande;
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
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Module obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
