package fr.myschool.productmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.DaoFactory;
import fr.myschool.productmanager.dao.ProductDao;
import fr.myschool.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/basicInsert")
public class BasicInsertServlet extends HttpServlet {	
	
	private ProductDao productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getProductDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {			
		Product product = new Product("Product inserted", "This is the description of the inserted product", 1.5F);
		productDao.addProduct(product);
		resp.getWriter().println("Product inserted with id: " + product.getId());
	}	
}
