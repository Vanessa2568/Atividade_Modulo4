package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setNome(req.getParameter("nome"));
		cliente.setLogin(req.getParameter("login"));
		cliente.setSenha(req.getParameter("senha"));
		cliente.setDataNasc(LocalDate.parse(req.getParameter("dataNasc")));
		    
						
		try {
			ClienteDAO clienteDAO = new ClienteDAO();		
			clienteDAO.createClient(cliente);
			
			
			res.sendRedirect("ReadController");			
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	}

}
