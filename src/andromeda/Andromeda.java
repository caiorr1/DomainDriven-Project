package andromeda;

import java.util.Scanner;
import java.util.Random;

public class Andromeda {

	public static void main(String[] args) {
	    CadastroLogin cadastroLogin = new CadastroLogin();
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
	
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Bem vindo ao Sistema Andrômeda, o serviço de suporte virtual da Porto!");
		System.out.println("----------------------------------------------------------------------\n");
	    boolean finalizar = false;
	    boolean logado = false;
	    String usuarioLogado = "";     
	    Veiculo veiculo = new Veiculo(1, 1,"", "", 1, "", "", "");
	    
	
        while (!finalizar) {
       	 if (!logado) {
       		 System.out.println("Selecione a opção desejada:\n1 - Cadastro\n2 - Login\n3 - Solicitar um Guincho\n0 - Sair");
				
				int resposta = scanner.nextInt();
				scanner.nextLine(); 
			
	            switch (resposta) {
		            case 1:
		            	System.out.println("\nOlá, aqui você pode adicionar uma nova conta!");

						String senhaPf = null, nomePf = null, enderecoPf = null, cpfCnpj = null;
						System.out.println("Digite o seu CPF ou CNPJ (Apenas Números):");
						cpfCnpj = scanner.nextLine();
						System.out.println("Digite o seu primeiro e último nome:");
						nomePf = scanner.nextLine();
						System.out.println("Informe o seu endereço atual:");
						enderecoPf = scanner.nextLine();
						System.out.println("Digite uma senha de acesso:");
						senhaPf = scanner.nextLine();
						Usuario usuario = new Usuario(senhaPf, nomePf, enderecoPf, cpfCnpj);
						UsuarioDAO  usuarioDao = new UsuarioDAO();
						System.out.println("\nUsuário cadastrado com sucesso!");
						usuarioDao.adicionar(usuario);
						break;

		            case 2: {
                       System.out.println("\nDigite o CPF ou CNPJ:");
                       String nomeLogin = scanner.nextLine();
                       System.out.println("Digite a senha do usuário:");
                       String senhaLogin = scanner.nextLine();
                       UsuarioDAO  usuarioLogin = new UsuarioDAO();
                       logado = usuarioLogin.realizarLogin(nomeLogin, senhaLogin);
                       usuarioLogado = nomeLogin;
                       break; } 
		            
		            case 3: {
		            	
		            	System.out.println("\nPara continuarmos com a solicitação, digite o seu CPF ou CNPJ:");
		            	String nomeLogin = scanner.nextLine();
		            	System.out.println("Digite o número da apólice:");
		            	String senhaLogin = scanner.nextLine();
		            	logado = cadastroLogin.realizarLogin(nomeLogin, senhaLogin);
		            	usuarioLogado = nomeLogin;
		            	break; } 
		            
		            case 0:
		                finalizar = true;
		                break;
		            default:
		                System.out.println("\nOpção inválida. Tente novamente.\n");
		                break;

	            }} else {
	        	
	                System.out.println("\nSelecione uma opção:");
	                System.out.println("1 - Realizar cadastro de um veículo no Sistema");
	                System.out.println("2 - Verificar veículos cadastrados");
	                System.out.println("3 - Fazer logout");
	                System.out.println("0 - Sair");
	
	                int opcao = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                switch (opcao) {
	                case 1:
	                    boolean cadastrarOutroVeiculo = true;
	                    while (cadastrarOutroVeiculo) {
	                        System.out.println("\nPara continuarmos, precisamos de algumas informações sobre o veículo:");
	                        System.out.println("Em qual categoria o veículo se enquadra melhor?");
	                        System.out.println("1 - Motocicletas");
	                        System.out.println("2 - Carros");
	                        System.out.println("3 - Vans, Trailers");
	                        System.out.println("4 - Caminhões de Carga Leve");
	                        System.out.println("5 - Caminhões de Carga Pesada");
	                        int tipoVeiculo = 0;
	                        boolean categoriaTrue = false;
	                        while (!categoriaTrue) {
	                            System.out.print("Digite o número correspondente ao tipo de veículo: ");
	                            tipoVeiculo = scanner.nextInt();
	                            scanner.nextLine();
	                            if (tipoVeiculo >= 1 && tipoVeiculo <= 5) {
	                                categoriaTrue = true;
	                            } else {
	                                System.out.println("Por favor, digite um número de 1 a 5.");
	                            }
	                        }
	                        System.out.println("Agora precisamos de algumas informações para completar o cadastro.");
	                        System.out.println("Qual o ano do Veículo?");
	                        String anoVeiculo = scanner.nextLine();
	                        System.out.println("Qual o modelo do Veículo?");
	                        String modelVeiculo = scanner.nextLine();
	                        System.out.println("Qual o peso aproximado do Veiculo?");
	                        int pesoVeiculo = scanner.nextInt();
	                        scanner.nextLine();
	                        System.out.println("Qual a cor do Veiculo?");
	                        String corVeiculo = scanner.nextLine();
	                        System.out.println("Qual o tipo de Combustível do Veiculo?");
	                        String combustivelVeiculo = scanner.nextLine();
	                        int numeroApolice = random.nextInt(9000000) + 1000000;
	                        System.out.println("Número da Apólice: " + numeroApolice);
	                        veiculo = new Veiculo(numeroApolice, tipoVeiculo, modelVeiculo, anoVeiculo, pesoVeiculo, corVeiculo, combustivelVeiculo, usuarioLogado);
	                        VeiculoDAO  veiculoDao = new VeiculoDAO();
	                        veiculoDao.adicionar(veiculo);

	                        boolean opcaoValida = false;
	                        while (!opcaoValida) {
	                            System.out.println("\nDeseja cadastrar outro veículo?");
	                            System.out.println("1 - Sim");
	                            System.out.println("2 - Não");
	                            int opcaoCadastrarOutro = scanner.nextInt();
	                            scanner.nextLine();

	                            if (opcaoCadastrarOutro == 2) {
	                            	cadastrarOutroVeiculo = false;
	                                opcaoValida = true;
	                            } else if (opcaoCadastrarOutro == 1) {
	                                opcaoValida = true;
	                            } else {
	                                System.out.println("\nOpção inválida. Digite 1 para Sim ou 2 para Não.\n");
	                            }
	                        }
	                    }
	                    break;

		                    
		                case 2:
		                    veiculo.exibirVeiculosDoUsuario(usuarioLogado);
		                    break;
		                    
	                    case 3:
	                        logado = false;
	                        usuarioLogado = "";
	                        break;

	                        
	                    case 0:
	                        finalizar = true;
	                        break;
	                        
	                    default:
	                        System.out.println("\nOpção inválida. Tente novamente.\n");
	                        break;            
}}}
        scanner.close();
}}
