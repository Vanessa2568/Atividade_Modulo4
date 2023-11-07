package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Cliente;

	


public class ClienteDAO {	
	private Connection connection;
	
	public ClienteDAO() throws SQLException {
		connection = DatabaseConnection.createConnection();
	}
	
	public void closeConnection() {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createClient(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, login, senha, dataNasc) VALUES (?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement (sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getLogin());
			stmt.setString(3, cliente.getSenha());
			
			Date data = Date.valueOf(cliente.getDataNasc());
			
			stmt.setDate(4, data);			
			stmt.executeUpdate();			
			System.out.println("Cliente criado com sucesso!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cliente findCliente (int id) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE id=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			
			if(r.next());
			cliente = new Cliente();
			cliente.setId(r.getInt("id"));
			cliente.setNome(r.getString("nome"));
			cliente.setLogin(r.getString("login"));
			cliente.setSenha(r.getString("senha"));
			cliente.setDataNasc(r.getDate("dataNasc").toLocalDate());			
			
			}catch(Exception e) {
				e.printStackTrace();
		}
		
		return cliente;
	}
	
	public List<Cliente> findClientes(){
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
try(PreparedStatement stmt = connection.prepareStatement(sql)){
						
			ResultSet r = stmt.executeQuery();
			
			if(r.next());
			Cliente cliente = new Cliente();
			cliente.setId(r.getInt("id"));
			cliente.setNome(r.getString("nome"));
			cliente.setLogin(r.getString("login"));
			cliente.setSenha(r.getString("senha"));
			cliente.setDataNasc(r.getDate("dataNasc").toLocalDate());	
			
			clientes.add(cliente);						

			} catch(Exception e) {
				e.printStackTrace();
			}

			return clientes;

	}
	
	
	
	public void updateCliente(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, login = ?, senha = ?, dataNasc = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getLogin());
			stmt.setString(3, cliente.getSenha());
			
			Date sqlDate = Date.valueOf(cliente.getDataNasc());
			
			stmt.setDate(4, sqlDate);
			stmt.setInt(5, cliente.getId());
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteClient(int id) {
		String sql = "DELETE FROM cliente WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println("Cliente deletado com sucesso!");
			
		}catch (SQLException e) {
		e.printStackTrace();
		
		}
	}
}
