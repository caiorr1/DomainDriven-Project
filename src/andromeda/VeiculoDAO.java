package andromeda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoDAO {

	private Connection conexao;
	
	public VeiculoDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Veiculo veiculo) {
		String sqlInsert = "INSERT INTO veiculo (cpfCnpj, numeroApolice, tipoVeiculo, modeloVeiculo, anoVeiculo, pesoVeiculo, corVeiculo, combustivelVeiculo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setString(1, veiculo.getUsuario());
			comandoDeInsercao.setInt(2, veiculo.getNumeroApolice());
			comandoDeInsercao.setInt(3, veiculo.getTipoVeiculo());
			comandoDeInsercao.setString(4, veiculo.getModeloVeiculo());
			comandoDeInsercao.setString(5, veiculo.getAnoVeiculo());
			comandoDeInsercao.setInt(6, veiculo.getPesoVeiculo());
			comandoDeInsercao.setString(7, veiculo.getCorVeiculo());
			comandoDeInsercao.setString(8, veiculo.getCombustivelVeiculo());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
