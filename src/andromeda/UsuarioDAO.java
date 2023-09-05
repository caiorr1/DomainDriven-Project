package andromeda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

	private Connection conexao;
	
	public UsuarioDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario (cpfCnpj, nome, endereco, senha) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setString(1, usuario.getCpfCnpj());
			comandoDeInsercao.setString(2, usuario.getNome());
			comandoDeInsercao.setString(3, usuario.getEndereco());
			comandoDeInsercao.setString(4, usuario.getSenha());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
