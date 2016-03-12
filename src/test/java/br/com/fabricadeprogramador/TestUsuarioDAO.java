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
		// Excluindo o usu�rio.
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt("5"));

		// Excluindo o usu�rio no banco.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluido com Sucesso.");
	}
	
	public static void testCadastrar() {
		// Criando o usu�rio.
		Usuario usu = new Usuario();
		usu.setNome("J�oj�o");
		usu.setLogin("jzao");
		usu.setSenha("123");

		// Cadastrando o usu�rio no banco.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com Sucesso.");
	}

	public static void testAlterar() {
		// Alterando o usu�rio.
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt("5"));
		usu.setNome("J�oj�o da Silva");
		usu.setLogin("jzaoss");
		usu.setSenha("12345678");

		// Alterando o usu�rio no banco.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com Sucesso.");
	}

}
