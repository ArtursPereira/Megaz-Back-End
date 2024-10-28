package com.project.megaz.services;

import com.project.megaz.dto.UserLogin;
import com.project.megaz.entity.User;
import com.project.megaz.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
// Serviços aqui é onde você vai interagir com o repositório, ou seja, com o banco de dados
@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //Função para ver status, usado no controller.
    public Iterable<User> viewall() {
        //bd = banco de dados
        //FindAll Significa que você vai puxar todos os user do bd nesse caso
        Iterable<User> users = this.userRepository.findAll();
        return users;


    }


    public User login(UserLogin login) {
        Optional<User> optionalUser = this.userRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("Email ou senha incorretos."); // Exceção personalizada
        }
    }

}
