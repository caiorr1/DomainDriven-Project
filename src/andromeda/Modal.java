package andromeda;

public class Modal {

	private String usuario;
	private int numeroApolice;
	private String enderecoOcorrencia;
	private String telefoneContato;
	private String descricao;
	private int acessoVeiculo;
	private int cargaVeiculo;
	
	public Modal(String usuario, int numeroApolice, String enderecoOcorrencia, String telefoneContato, String descricao, int acessoVeiculo, int cargaVeiculo) {
    	this.usuario = usuario;
    	this.numeroApolice = numeroApolice;
        this.enderecoOcorrencia = enderecoOcorrencia;
        this.telefoneContato = telefoneContato;
        this.descricao = descricao;
        this.acessoVeiculo = acessoVeiculo;
        this.cargaVeiculo = cargaVeiculo;
	}
	
}