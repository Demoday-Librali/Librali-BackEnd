// Classes que permite a leitura e escrita no banco de dados e interação com os objetos

package com.librali.repository;

import com.librali.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //<tipos Entidade e tipo Chave Primaria>

}
