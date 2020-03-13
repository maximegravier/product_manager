package fr.myschool.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.entity.Product;


@SuppressWarnings("serial")
public class CheaperProductServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Product AS p WHERE p.price < 100");
		List<Product> cheaperProductsList = query.getResultList();
		
		req.setAttribute("cheaperProductsList", cheaperProductsList);		
		req.getRequestDispatcher("/listProduct.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		if (emf != null && emf.isOpen())
			emf.close();
	}
}
