package andromeda;

import java.util.ArrayList;
import java.util.List;

public class CadastroLogin {
    private List<Usuario> usuarios;

    public CadastroLogin() {
        usuarios = new ArrayList<>();
    }

    // Método para cadastrar um usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }


    // Método para realizar o login de um usuário
    public boolean realizarLogin(String nome, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpfCnpj().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("\nLogin bem-sucedido! Bem-vindo, " + nome + "!");
                return true;
            }
        }
        System.out.println("\nDados incorretos. Tente novamente.\n");
        return false;
    }

    public Usuario obterUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpfCnpj().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    
}


