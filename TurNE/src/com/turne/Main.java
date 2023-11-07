package com.turne;

import java.sql.SQLException;
import java.time.LocalDate;

import com.turne.dao.ClienteDAO;
import com.turne.model.Cliente;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ClienteDAO cDAO = new ClienteDAO();			
		Cliente cliente = new Cliente();
//		
//		cliente.setNome("Bruna");
//		cliente.setLogin ("Bruna568");
//		cliente.setSenha("658977777");
//		cliente.setDataNasc (LocalDate.of(1970, 10, 5));
//		
//		cDAO.createCliente(cliente);
//		
//		cliente.setId(1);
//		cliente.setNome("Ricardo");
//		cliente.setLogin("Ricardo@com");
//		cliente.setSenha("SenhaRicardo");
//		cliente.setDataNasc(LocalDate.of(1986, 05, 16));
//		
//		cDAO.updateCliente(cliente);
				
		System.out.println("ID: " + cDAO.findCliente(2).getId() + "\nNome: " + cDAO.findCliente(2).getNome());
		
//		cDAO.deleteClient(1);
		

	}

}
