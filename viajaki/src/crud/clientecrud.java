package crud;

import java.util.Scanner;

import dao.clientedao;
import dao.usuariodao;
import model.cliente;
import model.usuario;

public class clientecrud {
public static void main(String[] args) {
        
        clientedao clientesdao = new clientedao();
        usuariodao usuariosdao = new usuariodao();
        
        Scanner input = new Scanner(System.in);
        
        int opcao = 0;
        int posicao = 0;
        
        int id_cliente = 0;
        String nome = "";
        int cpf = 0;
        int telefone = 0;
        int id_usuario = 0;
        
        
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
                System.out.println("--- Cadastrar Cliente ---");
                System.out.println("Digite o nome de Cliente: ");
                nome = input.next();
                System.out.println("Digite o CPF de Cliente: ");
                cpf = input.nextInt();
                System.out.println("Digite o Telefone do Cliente: ");
                telefone = input.nextInt();
                System.out.println("Digite o id do Usuário: ");
                id_usuario = input.nextInt();
                input.nextLine();
                usuario usuarios = usuariosdao.getusuarioById(id_usuario);
                cliente clientes = new cliente(id_cliente, nome, cpf, telefone, usuarios);
                clientesdao.save(clientes);
                
                System.out.println("--- Usuário Cadastrado ---\n");
                break;
                
            case 2: 
                System.out.println("--- Consultar Usuários ---");
                for (cliente a : clientesdao.getcliente()) {
                    System.out.println("id: " + a.getId_cliente() + "\n"
                                        + "Nome: " + a.getNome() + "\n"
                                        + "CPF: " + a.getCpf() + "\n"
                                        + "Telefone: " + a.getTelefone());
                }
                
                System.out.println("--- Consulta Realizada ---\n");
                break;
                
            case 3: 
                System.out.println("--- Atualizar ---");
                System.out.println("Digite o id do Usuário: ");
                posicao = input.nextInt();
                System.out.println("Digite o nome do Cliente: ");
                nome = input.next();
                System.out.println("Digite o CPF do Cliente: ");
                cpf = input.nextInt();
                System.out.println("Digite a Telefone do Cliente:");
                telefone = input.nextInt();                
                usuario usuario1 = usuariosdao.getusuarioById(id_usuario);
                cliente cliente1 = new cliente(posicao, nome, cpf, telefone, usuario1);
                clientesdao.update(cliente1);
                
                System.out.println("--- Cliente Atualizado ---\n");
                break;                
            
            case 4: 
                System.out.println("--- Deletar Administrador ---");
                System.out.println("Informe o Id para Deletar o Cliente: ");
                posicao = input.nextInt();
                
                clientesdao.deleteById(posicao);
                System.out.println("--- Cliente Excluido ---\n");
                break;
                
            case 5:
                System.out.println("--- Buscar Cliente pelo id ---");
                System.out.println("Digite o id do Cliente: ");
                posicao = input.nextInt();
                cliente clientes1 = clientesdao.getClienteById(posicao);
                System.out.println("Id: " + clientes1.getId_cliente() + "\n" 
                                    + "Nome: " + clientes1.getNome() + "\n"
                                    + "CPF: " + clientes1.getCpf() + "\n"
                                    + "Telefone: " + clientes1.getTelefone());
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
