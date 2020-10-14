package br.com.gerenciamentoprojetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciamentoprojetos.model.Permissao;
import br.com.gerenciamentoprojetos.model.Usuario;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

	public List<Permissao> findByUsuariosIn(Usuario ...usuarios);

}
