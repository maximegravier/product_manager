package fr.myschool.productmanager.dao;

import fr.myschool.productmanager.dao.jpa.JpaProductDao;
import fr.myschool.productmanager.dao.jpa.JpaCategoryDao;
import fr.myschool.productmanager.utils.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	public static ProductDao getProductDao() {
		return new JpaProductDao(PersistenceManager.getEmf());
	}
	
	public static CategoryDao getCategoryDao() {
		return new JpaCategoryDao(PersistenceManager.getEmf());
	}
}
