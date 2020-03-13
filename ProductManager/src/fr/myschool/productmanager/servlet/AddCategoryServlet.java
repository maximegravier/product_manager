package fr.myschool.productmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.CategoryDao;
import fr.myschool.productmanager.dao.DaoFactory;
import fr.myschool.productmanager.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {	
	
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		categoryDao = DaoFactory.getCategoryDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {						
		Category category = new Category(req.getParameter("name"));
		categoryDao.addCategory(category);
		resp.getWriter().println("Category inserted with id: " + category.getId());		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/auth/addCategory.jsp").forward(req, resp);
	}
}
