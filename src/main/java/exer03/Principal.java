package exer02;

import java.util.Scanner;

import exer02.DAO;
import exer02.Usuario;

public class Principal {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		int op = 1;
		int codigo;
		String login;
		String senha;
		char sexo;
		
		while (op != 0 ) {
			System.out.println("(1)Listar Usuarios");
			System.out.println("(2)Inserir Usuario");
			System.out.println("(3)Excluir Usuario");
			System.out.println("(4)Atualizar Usuario");
			System.out.println("(0)Sair");
			op = sc.nextInt();
			
			if (op == 1) {
				//Mostrar usuários
				Usuario[] usuarios;
				usuarios = dao.getUsuarios();
				System.out.println("==== Mostrar usuários === ");		
				for(int i = 0; i < usuarios.length; i++) {
					System.out.println(usuarios[i].toString());
				}
			} else if (op == 2) {
				//Inserir um elemento na tabela
				System.out.println("----- INSERIR -----");
				System.out.println("Insira o codigo");
				codigo = sc.nextInt();
				System.out.println("Insira o login");
				login = sc.next();
				System.out.println("Insira a senha");
				senha = sc.next();
				System.out.println("Insira o sexo");
			    sexo = sc.next().charAt(0);
				Usuario usuario = new Usuario(codigo, login, senha, sexo);
				if(dao.inserirUsuario(usuario) == true) {
					System.out.println("Inserção com sucesso -> " + usuario.toString());
				}
			} else if (op == 3) {
				//Excluir usuário
				System.out.println("----- EXCLUIR -----");
				System.out.println("Insira o codigo");
				codigo = sc.nextInt();
				System.out.println("Insira o login");
				login = sc.next();
				System.out.println("Insira a senha");
				senha = sc.next();
				System.out.println("Insira o sexo");
			    sexo = sc.next().charAt(0);
				Usuario usuario = new Usuario(codigo, login, senha, sexo);
				dao.excluirUsuario(usuario.getCodigo());
			} else if (op == 4) {
				//Atualizar usuário
				System.out.println("----- ATUALIZAR -----");
				System.out.println("Insira o codigo");
				codigo = sc.nextInt();
				System.out.println("Insira o login");
				login = sc.next();
				System.out.println("Insira a nova senha");
				senha = sc.next();
				System.out.println("Insira o sexo");
			    sexo = sc.next().charAt(0);
				Usuario usuario = new Usuario(codigo, login, senha, sexo);
				usuario.setSenha(senha);
				dao.atualizarUsuario(usuario);
			}
		}
		dao.close();
	}
}


