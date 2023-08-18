package com.obs.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class OBSservlet
 */

//@WebServlet("/OBSservlet")
public class OBSservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OBSservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("OBSTest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userID = request.getParameter("userID");
	    String password = request.getParameter("password");
	    
    	Map<String, String>responseMap = new HashMap<>();
	    
	    // validasi hardcoded
	    if ("admin".equals(userID) && "123".equals(password)) {
	       	responseMap.put("success", "true");
	    } else {
	       	responseMap.put("success", "false");
	    }
    	StringBuilder jsonLikeString = new StringBuilder("{");
    	boolean isFirst = true;

    	for (Map.Entry<String, String> entry : responseMap.entrySet()) {
    	    if (!isFirst) {
    	        jsonLikeString.append(", ");
    	    }
    	    
    	    jsonLikeString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\"");
    	    isFirst = false;
    	}

    	jsonLikeString.append("}");
    	response.setContentType("application/json");
    	response.getWriter().write(jsonLikeString.toString());
	}


}
