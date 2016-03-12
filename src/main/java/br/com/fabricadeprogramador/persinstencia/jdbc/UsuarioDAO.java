package br.com.fabricadeprogramador.persinstencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConection();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario(nome, login, senha) values (?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(sql)){
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
		try (PreparedStatement pst = con.prepareStatement(sql)){
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
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, usu.getId());

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
