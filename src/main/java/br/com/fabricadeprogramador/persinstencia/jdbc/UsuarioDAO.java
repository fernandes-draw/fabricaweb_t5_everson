package br.com.fabricadeprogramador.persinstencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConection();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario(nome, login, senha) values (?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, usu.getNome());
			pst.setString(2, usu.getLogin());
			pst.setString(3, usu.getSenha());

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, usu.getNome());
			pst.setString(2, usu.getLogin());
			pst.setString(3, usu.getSenha());
			pst.setInt(4, usu.getId());

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, usu.getId());

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}

	/**
	 * Busca de um registro no banco de dados pelo numero de id do usuário.
	 * 
	 * @param id
	 *            - é um número inteiro que representa o id do usuário à ser
	 *            buscado.
	 * @return - Um objeto usuário quando encontra e nulo quando não encontra.
	 */
	public Usuario buscaPorId(Integer id) {
		String sql = "Select * from usuario where id=?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));

				return usuario;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Realiza a busca de todos os registros da tabela usuários.
	 * 
	 * @return - Uma lista de objetos Usuários contendo zero elemntos quando não
	 *         encontrar ou n elementos quando tiver resultado.
	 */
	public List<Usuario> buscarTodos() {
		String sql = "Select * from usuario";

		List<Usuario> lista = new ArrayList<Usuario>();
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));

				lista.add(usuario);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

	public Usuario autenticar(Usuario usuConsulta) {
		String sql = "Select * from usuario where login=? and senha=?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, usuConsulta.getLogin());
			pst.setString(2, usuConsulta.getSenha());
			ResultSet resultado = pst.executeQuery();

			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

}
