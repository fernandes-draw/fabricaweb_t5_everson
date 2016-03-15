package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persinstencia.jdbc.UsuarioDAO;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		// testCadastrar();
		// testAlterar();
		// testExcluir();
		// testSalvar();
		// testBuscarPorid();
		// testBuscarTodos();
		testAutenticar();

	}

	private static void testAutenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Usuario usu = new Usuario();
		usu.setLogin("ef");
		usu.setSenha("123");

		Usuario usuRetorno = usuarioDAO.autenticar(usu);
		System.out.println(usuRetorno);

	}

	private static void testBuscarPorid() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscaPorId(4);

		System.out.println(usuario);

	}

	private static void testBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		for (Usuario u : lista) {
			System.out.println(u);
		}
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

	public static void testSalvar() {
		Usuario usuario = new Usuario();
		// usuario.setId(2);
		usuario.setNome("Junior");
		usuario.setLogin("jr");
		usuario.setSenha("369");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);

		System.out.println("Salvo com sucesso.");
	}

}
