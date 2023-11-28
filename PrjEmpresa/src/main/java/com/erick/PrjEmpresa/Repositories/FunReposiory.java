package com.erick.PrjEmpresa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.PrjEmpresa.Entities.Funcionario;


public interface FunReposiory extends JpaRepository<Funcionario, Long>{

}
