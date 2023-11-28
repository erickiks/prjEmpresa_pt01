package com.erick.PrjEmpresa.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.PrjEmpresa.Entities.Funcionario;
import com.erick.PrjEmpresa.Repositories.FunReposiory;


@Service
public class FunService {
	private final FunReposiory funReposiory;

	@Autowired
	public FunService(FunReposiory funReposiory) {
		this.funReposiory = funReposiory;
	}

	public Funcionario getFuncionarioById(Long funCodigo) {
		return funReposiory.findById(funCodigo).orElse(null);
	}

	public List<Funcionario> getAllFuncionario() {
		return funReposiory.findAll();
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funReposiory.save(funcionario);
	}

	public void deleteFuncionario(Long funCodigo) {
		funReposiory.deleteById(funCodigo);
	}
	
		public Funcionario updateFuncionario(Long funCodigo, Funcionario novofuncionario) {
			Optional<Funcionario> funcionarioOptional = funReposiory.findById(funCodigo);
	        if (funcionarioOptional.isPresent()) {
	        	Funcionario funcionarioExistente = funcionarioOptional.get();
	        	funcionarioExistente.setfunNome(novofuncionario.getfunNome());
	        	funcionarioExistente.setfunNascimento(novofuncionario.getfunNascimento());     
	        	funcionarioExistente.setfunSalario(novofuncionario.getfunSalario());     
	            return funReposiory.save(funcionarioExistente); 
	        } else {
	            return null; 
	        }
	    }
}
