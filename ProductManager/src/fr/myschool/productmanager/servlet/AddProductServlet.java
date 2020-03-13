package fr.myschool.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.CategoryDao;
import fr.myschool.productmanager.dao.DaoFactory;
import fr.myschool.productmanager.dao.ProductDao;
import fr.myschool.productmanager.entity.Category;
import fr.myschool.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

	private ProductDao productDao;
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		productDao = DaoFactory.getProductDao();
		categoryDao = DaoFactory.getCategoryDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Product product = new Product(req.getParameter("name"), req.getParameter("description"), Float.valueOf(req.getParameter("price")));
		Long categoryId = Long.valueOf(req.getParameter("category"));		
		Category category = categoryDao.findCategoryById(categoryId);
		product.setCategory(category);
		productDao.addProduct(product);
				
		resp.sendRedirect(req.getContextPath() + "/showProduct?id=" + product.getId());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		List<Category> categoryList = categoryDao.getAllCategories();
		
		req.setAttribute("categoryList", categoryList);
		req.getRequestDispatcher("/auth/addProduct.jsp").forward(req, resp);
	}
}
