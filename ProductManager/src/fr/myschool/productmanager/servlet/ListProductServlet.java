package fr.myschool.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.DaoFactory;
import fr.myschool.productmanager.dao.ProductDao;
import fr.myschool.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/listProduct")
public class ListProductServlet extends HttpServlet {
	
	private ProductDao productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getProductDao(); 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		List<Product> productList = productDao.getAllProducts();
		req.setAttribute("productList", productList);
		
		req.getRequestDispatcher("/listProduct.jsp").forward(req, resp);
	}
}
