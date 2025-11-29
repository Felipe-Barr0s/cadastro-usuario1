package com.projetopessoal.cadastro_usuario.infrastructure.repository;

import com.projetopessoal.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Como o findByEmail nao existe no JpaRepository, criei ele a parte
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

    List<Usuario> id(UUID id);
}
