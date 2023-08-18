package com.obs.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.obs.model.Student;

/**
 * Servlet implementation class HomeServlet
 */

//@WebServlet("/HomeServlet")

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S1","Student 1", 35, "Dep 1"));
        studentList.add(new Student("S1","Student 1", 70, "Dep 1"));
        studentList.add(new Student("S1","Student 1", 60, "Dep 1"));
        studentList.add(new Student("S1","Student 1", 90, "Dep 1"));
        studentList.add(new Student("S2","Student 2", 30, "Dep 2"));
        studentList.add(new Student("S3","Student 3", 32, "Dep 3"));
        studentList.add(new Student("S3","Student 3", 70, "Dep 3"));
        studentList.add(new Student("S3","Student 3", 20, "Dep 3"));
        request.setAttribute("studentList", studentList);

        double passCount1 = 0;
        double passCount2 = 0;
        double passCount3 = 0;
        double totalCount1 = 0;
        double totalCount2 = 0;
        double totalCount3 = 0;
        Map<String, String> mapPassRate = new HashMap<>();
        for(int i = 0; i< studentList.size(); i++){
            Student currStudent = studentList.get(i);
            if (currStudent.getDepartment().equals("Dep 1")) {
                totalCount1++;
                if (currStudent.getMark() >= 40) {
                    passCount1++;
                }
            } else if (currStudent.getDepartment().equals("Dep 2")) {
                totalCount2++;
                if (currStudent.getMark() >= 40) {
                    passCount2++;
                }
            } else if (currStudent.getDepartment().equals("Dep 3")) {
                totalCount3++;
                if (currStudent.getMark() >= 40) {
                    passCount3++;
                }
            }
        }
 
        mapPassRate.put("Dep 1", String.format("%.2f",(passCount1 / totalCount1)*100));
        mapPassRate.put("Dep 2", String.format("%.2f",(passCount2 / totalCount2)*100));
        mapPassRate.put("Dep 3", String.format("%.2f",(passCount3 / totalCount3)*100));
        request.setAttribute("mapPassRate", mapPassRate);


        RequestDispatcher dispatcher = request.getRequestDispatcher("OBSTest2.jsp");
        dispatcher.forward(request, response);
	}

}
