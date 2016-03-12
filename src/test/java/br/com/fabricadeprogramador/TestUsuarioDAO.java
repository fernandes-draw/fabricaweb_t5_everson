package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persinstencia.jdbc.UsuarioDAO;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		// testCadastrar();
		// testAlterar();
		testExcluir();

	}

	public static void testExcluir() {
		// Excluindo o usuário.
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt("5"));

		// Excluindo o usuário no banco.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluido com Sucesso.");
	}
	
	public static void testCadastrar() {
		// Criando o usuário.
		Usuario usu = new Usuario();
		usu.setNome("Jãojão");
		usu.setLogin("jzao");
		usu.setSenha("123");

		// Cadastrando o usuário no banco.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com Sucesso.");
	}

	public static void testAlterar() {
		// Alterando o usuário.
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt("5"));
		usu.setNome("Jãojão da Silva");
		usu.setLogin("jzaoss");
		usu.setSenha("12345678");

		// Alterando o usuário no banco.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com Sucesso.");
	}

}
