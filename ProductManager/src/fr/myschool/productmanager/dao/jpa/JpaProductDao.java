package fr.myschool.productmanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.myschool.productmanager.dao.ProductDao;
import fr.myschool.productmanager.entity.Product;

public class JpaProductDao implements ProductDao {
	
	private EntityManager em;
	
	public JpaProductDao(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}
	
	@Override
	public Product addProduct(Product product) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(product);
			t.commit();
		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}
		return product;
	}
	
	@Override
	public Product findProductById(Long id) {
		return em.find(Product.class, id);
	}
	
	@Override
	public List<Product> getAllProducts() {
		Query query = em.createQuery("SELECT p FROM Product AS p");
		return query.getResultList();
	}
	
	@Override
	public void updateProduct(Product product) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.merge(product);
			t.commit();
		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}
	}
	
	@Override
	public void removeProduct(Product product) {
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.remove(product);
			t.commit();
		} finally {
			if (t.isActive())
				t.rollback();
			em.close();
		}
	}
}
