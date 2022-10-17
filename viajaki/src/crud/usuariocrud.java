package crud;

import java.util.Scanner;

import dao.usuariodao;
import model.usuario;

public class usuariocrud {

public static void main(String[] args) {
        
        usuariodao usuariodao = new usuariodao();
        
        Scanner input = new Scanner(System.in);
        
        int opcao = 0;
        int posicao = 0;
        
        int id_usuario = 0;
        String nome_usuario = "";
        String email = "";
        String senha = "";
        
        do {
            System.out.println("--- Usuário ---");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Consultar Usuário");
            System.out.println("3 - Atualizar Usuário");
            System.out.println("4 - Deletar Usuários");
            System.out.println("5 - Buscar por id");
            System.out.println("0 - Sair");
            
            opcao = input.nextInt();
            input.nextLine();
            
            switch (opcao) {
            
            case 1:
                System.out.println("--- Cadastrar Usuário ---");
                System.out.println("Digite o nome de Usuário: ");
                nome_usuario = input.next();
                System.out.println("Digite o email de Usuário: ");
                email = input.next();
                System.out.println("Digite a senha do Usuário: ");
                senha = input.next();
                
                usuario usuario = new usuario(id_usuario, nome_usuario, email, senha);
                usuariodao.save(usuario);
                
                System.out.println("--- Usuário Cadastrado ---\n");
                break;
                
            case 2: 
                System.out.println("--- Consultar Usuários ---");
                for (usuario a : usuariodao.getusuario()) {
                    System.out.println("id: " + a.getId_usuario() + "\n"
                                        + "Nome: " + a.getNome_usuario() + "\n"
                                        + "Email: " + a.getEmail() + "\n"
                                        + "Senha: " + a.getSenha());
                }
                
                System.out.println("--- Consulta Realizada ---\n");
                break;
                
            case 3: 
                System.out.println("--- Atualizar ---");
                System.out.println("Digite o id do Usuário: ");
                posicao = input.nextInt();
                System.out.println("Digite o nome do Usuário: ");
                nome_usuario = input.next();
                System.out.println("Digite o email do Usuário: ");
                email = input.next();
                System.out.println("Digite a senha do Usuário:");
                senha = input.next();
                
                usuario usuarios = new usuario(posicao, nome_usuario, email, senha);
                usuariodao.update(usuarios);
                
                System.out.println("--- Usuário Atualizado ---\n");
                break;                
            
            case 4: 
                System.out.println("--- Deletar Administrador ---");
                System.out.println("Informe o Id para Deletar o Usuário: ");
                posicao = input.nextInt();
                
                usuariodao.deleteById(posicao);
                System.out.println("--- Usuário Excluido ---\n");
                break;
                
            case 5:
                System.out.println("--- Buscar Usuário pelo id ---");
                System.out.println("Digite o id do Usuário: ");
                posicao = input.nextInt();
                usuario usuarios1 = usuariodao.getusuarioById(posicao);
                System.out.println("Id: " + usuarios1.getId_usuario() + "\n" 
                                    + "Nome: " + usuarios1.getNome_usuario() + "\n"
                                    + "Email: " + usuarios1.getEmail() + "\n"
                                    + "Senha: " + usuarios1.getSenha());
                System.out.println("--- Busca Realizada ---\n");
                
            default:
                System.out.println(opcao != 0 ? "Escolha uma opção válida" : "");
                break;
            }
        } while (opcao != 0);
        input.close();
        System.out.println("Operação Finalizada pelo Usuário");
    }
}
