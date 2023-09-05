package andromeda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

	public class Veiculo {
	
	    private static List<Veiculo> veiculoCadastrado = new ArrayList<>();
	
	    private int numeroApolice;
	    private int tipoVeiculo;
	    private String modeloVeiculo;
	    private String anoVeiculo;
	    private int pesoVeiculo;
	    private String corVeiculo;
	    private String combustivelVeiculo;
	    private String usuario;
	    
	    public Veiculo(int numeroApolice, int tipoVeiculo, String modeloVeiculo, String anoVeiculo, int pesoVeiculo, String corVeiculo, String combustivelVeiculo, String usuario) {
	    	this.numeroApolice = numeroApolice;
	    	this.tipoVeiculo = tipoVeiculo;
	        this.modeloVeiculo = modeloVeiculo;
	        this.anoVeiculo = anoVeiculo;
	        this.pesoVeiculo = pesoVeiculo;
	        this.corVeiculo = corVeiculo;
	        this.combustivelVeiculo = combustivelVeiculo;
	        this.usuario = usuario;
	    }
	    
	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }
	    
	    public String getUsuario() {
	        return usuario;

	    }
	    
	    public String getModeloVeiculo() {
	        return modeloVeiculo;
	    }
	    
	    public int getTipoVeiculo() {
	        return tipoVeiculo;
	    }
	    
	    public int getNumeroApolice() {
	        return numeroApolice;
	    }

	    public String getAnoVeiculo() {
	        return anoVeiculo;
	    }
	    
	    public int getPesoVeiculo() {
	        return pesoVeiculo;
	    }
	    
	    public String getCorVeiculo() {
	        return corVeiculo;
	    }
	    
	    public String getCombustivelVeiculo() {
	        return combustivelVeiculo;
	    }
	    
	    public void cadastrarVeiculo(Veiculo veiculo, String usuario) {
	        veiculo.setUsuario(usuario);
	        veiculoCadastrado.add(veiculo);
	        System.out.println("\nVeículo cadastrado com sucesso!\n");
	    }
	    
	    public void exibirVeiculosDoUsuario(String usuario) {
	        boolean encontrou = false;
	        for (Veiculo veiculo : veiculoCadastrado) {
	            if (veiculo.getUsuario().equals(usuario)) {
	                encontrou = true;
	                System.out.println("\nNúmero da Apólice: " + veiculo.getNumeroApolice());
	                System.out.println("Modelo do Veículo: " + veiculo.getModeloVeiculo());
	                System.out.println("Ano: " + veiculo.getAnoVeiculo());
	                System.out.println("Cor: " + veiculo.getCorVeiculo());
	                System.out.println("Combustível: " + veiculo.getCombustivelVeiculo());
	                System.out.println("Peso: " + veiculo.getPesoVeiculo());
	            }
	        }
	        if (!encontrou) {
	            System.out.println("\nVocê ainda não cadastrou nenhum veículo.\n");
	        }
	    }
}
	
	