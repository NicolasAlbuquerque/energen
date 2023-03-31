package com.generation.energen.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.energen.model.Usuario;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {

        usuarioRepository.deleteAll();

        usuarioRepository.save(new Usuario(0L, "João da Silva", "13465278", "192.634.747-12", "(11) 93526-8374", "joao@email.com.br",  "https://i.imgur.com/FETvs2O.jpg"));

        usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "13465278", "156.666.984-84", "(11) 9256-8776", "manuela@email.com.br",  "https://i.imgur.com/NtyGneo.jpg"));

        usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "13465278", "182.726.377-00", "(12) 98723-9834", "adriana@email.com.br",  "https://i.imgur.com/mB3VM2N.jpg"));

        usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "13465278", "288.288.763-13", "(11) 98374-9458", "paulo@email.com.br", "https://i.imgur.com/JR7kUFU.jpg"));
    }

    @Test
    @DisplayName("Retorna 1 usuario")
    public void deveRetornarUmUsuario() {

        Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");

        assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
    }

    @Test
    @DisplayName("Retorna 3 usuarios")
    public void deveRetornarTresUsuarios() {

        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");

        assertEquals(3, listaDeUsuarios.size());

        assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
    }

    @AfterAll
    public void end() {
        usuarioRepository.deleteAll();
    }

}