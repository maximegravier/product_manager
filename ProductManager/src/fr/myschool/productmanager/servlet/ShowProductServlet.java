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
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {
	
	private ProductDao productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getProductDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Long productId = Long.valueOf(req.getParameter("id"));
		Product product = productDao.findProductById(productId);
		
		req.setAttribute("productShown", product);		
		req.getRequestDispatcher("showProduct.jsp").forward(req, resp);		
	}
}
