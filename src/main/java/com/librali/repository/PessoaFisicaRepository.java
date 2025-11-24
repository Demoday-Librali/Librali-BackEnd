package com.librali.repository;

import com.librali.model.PessoaFisica;
import com.librali.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {
    //<tipos>

}

