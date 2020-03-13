package fr.myschool.productmanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.myschool.productmanager.dao.CategoryDao;
import fr.myschool.productmanager.entity.Category;

public class JpaCategoryDao implements CategoryDao {

	private EntityManager em;
	
	public JpaCategoryDao(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}
	
	@Override
	public Category addCategory(Category category) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(category);
			t.commit();
		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}
		return category;
	}
	
	@Override
	public Category findCategoryById(Long id) {
		return em.find(Category.class, id);
	}
	
	@Override
	public List<Category> getAllCategories() {
		Query query = em.createQuery("SELECT c FROM Category AS c");
		return query.getResultList();
	}
	
	@Override
	public void updateCategory(Category category) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.merge(category);
			t.commit();
		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}
	}
	
	@Override
	public void removeCategory(Category category) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.remove(category);
			t.commit();
		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}
	}
}
