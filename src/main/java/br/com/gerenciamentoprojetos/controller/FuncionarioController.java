package br.com.gerenciamentoprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.gerenciamentoprojetos.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionarios")
	public String getFuncionarios(Model model) {
		
		model.addAttribute("funcionarios", funcionarioRepository.findAll());
		return "funcionarios";
	}

}
