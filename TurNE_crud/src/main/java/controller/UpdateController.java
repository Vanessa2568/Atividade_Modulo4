package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public UpdateController() {
        super(); 
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			ClienteDAO cDAO = new ClienteDAO();
			Cliente cliente = cDAO.findCliente(id);
			
			request.setAttribute ("cliente", cliente);
			
			RequestDispatcher rd = request.getRequestDispatcher("atualizar.jsp");		
			rd.forward(request, response);
			
			response.sendRedirect("ReadController");
		}catch (SQLException e) {			
			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(request.getParameter("id")));
			cliente.setNome(request.getParameter("nome"));
			cliente.setLogin(request.getParameter("login"));
			cliente.setSenha(request.getParameter("senha"));
			cliente.setDataNasc(LocalDate.parse(request.getParameter("datanasc")));
			
			ClienteDAO cDAO = new ClienteDAO();
			cDAO.updateCliente(cliente);
			
			
		} catch (Exception e ) {
			e.printStackTrace();
			
		}
		
		
		

	}

}
