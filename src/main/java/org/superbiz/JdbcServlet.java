package org.superbiz;

import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.sql.*;
import java.sql.*;

public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 8229511817604046163L;
	
	@Resource(name = "Derby Database")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();


		try(final Connection connection = dataSource.getConnection()){
			
			boolean valid = connection.isValid(1000);
			writer.print("\n JDBC Connection is " + (valid==true?"valid":"NOT valid") + " @ timestamp = "+ System.currentTimeMillis());
			
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.print("\n Unable to Connect");

	}
}