package com.projetopessoal.cadastro_usuario.business;

import com.projetopessoal.cadastro_usuario.infrastructure.entitys.Usuario;
import com.projetopessoal.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    //Injeção de dependencia construtor padrão
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //aplicando método save
    public void save(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }
    //aplicando método de buscar usuario por email
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("Email não encontrado")
        );
    }
    //Método deletar email
    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }
    //Método atualizar usuario por email
    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.save(usuarioAtualizado);
    }
}