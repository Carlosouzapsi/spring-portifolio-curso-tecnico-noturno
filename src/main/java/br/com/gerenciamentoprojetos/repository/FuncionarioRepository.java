package br.com.gerenciamentoprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciamentoprojetos.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
