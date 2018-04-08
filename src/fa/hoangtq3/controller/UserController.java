
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fa.hoangtq3.dao.UserDao;
import fa.hoangtq3.model.UserModel;

public class UserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse reps)
			throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int idus = Integer.parseInt(req.getParameter("idus"));
			dao.deleteUser(idus);
			forward = LIST_USER;
			req.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int idus = Integer.parseInt(req.getParameter("idus"));
			UserModel user = dao.getUserById(idus);
			req.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			req.setAttribute("users", dao.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, reps);
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 UserModel userModel=new UserModel();
		 
		 userModel.setFullname(req.getParameter("fullname"));
		 userModel.setGender(req.getParameter("gender"));
		 userModel.setEmail(req.getParameter("email"));
		 userModel.setUsername(req.getParameter("username"));
		 userModel.setPassword(req.getParameter("password"));
		 userModel.setRole(req.getParameter("role"));
		 
		  String idus = req.getParameter("idus");
	        if(idus == null || idus.isEmpty())
	        {
	            dao.addUser(userModel);
	        }
	        else
	        {
	        	userModel.setIdus(Integer.parseInt(idus));
	            dao.updateUser(userModel);
	        }
	        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
	        req.setAttribute("users", dao.getAllUsers());
	        view.forward(req, resp);
		 
		
	}

}
