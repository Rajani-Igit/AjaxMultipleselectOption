package com.select.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class SelectController
 */
@WebServlet("/SelectController")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Properties  prop;
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
    	FileInputStream fis=null;
    	String filepath=null;
    	prop=new Properties();
    	// TODO Auto-generated method stub
    	System.out.println("Servlet initialization");
    	System.out.println(config.getServletContext().getRealPath("//WEB-INF//districts.properties"));
    	 filepath=config.getServletContext().getRealPath("//WEB-INF//districts.properties");
    	 try {
			fis=new FileInputStream(new File(filepath));
			prop.load(fis);
			System.out.println(prop.getProperty("ArunachalPradesh"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("name"));
		String state=request.getParameter("name");
		 PrintWriter out=response.getWriter();
		 List<String> al=new ArrayList<String>();
		 al.add("AndhraPradesh");
		 al.add("AndhraPradesh");
		 al.add("Assam");
		 al.add("Bihar");
		 al.add("Chhattisgarh");
		 al.add("Delhi");
		 al.add("Goa");
		 al.add("Gujarat");
		 al.add("Haryana");
		 al.add("HimachalPradesh");
		 al.add("JammuandKashmir");
		 al.add("Jhharkhand");
		 al.add("Karnatak");
		 al.add("Kerala");
		 al.add("Madhyapradesh");
		 al.add("Maharstra");
		 al.add("Manipur");
		 al.add("Meghalaya");
		 al.add("Mizoram");
		 al.add("Nagaland");
		 al.add("Odisha");
		 al.add("Punjab");
		 al.add("Rajstan");
		 al.add("Sikim");
		 al.add("Tamilnadu");
		 al.add("Telengana");
		 al.add("Tripura");
		 al.add("Uttarakhand");
		 al.add("Uttarpradesh");
		 al.add("WestBengal");
	
		 out.write(new Gson().toJson(al));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state=request.getParameter("state");
		System.out.println(state);
		PrintWriter out=response.getWriter();
		 List<String> al=new ArrayList<String>();
			String[] districts=prop.getProperty(state).split(",");
			al=Arrays.asList(districts);
		 out.write(new Gson().toJson(al));
		//doGet(request, response);
	}

}
