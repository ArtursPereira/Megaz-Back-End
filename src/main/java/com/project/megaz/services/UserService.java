package com.project.megaz.services;

import com.project.megaz.dto.UserLogin;
import com.project.megaz.entity.User;
import com.project.megaz.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;
// Serviços aqui é onde você vai interagir com o repositório, ou seja, com o banco de dados
@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void Update(Scanner scanner) {
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();

        Optional<User> optionalUser = this.userRepository.findByEmailAndSenha(email, password);
        if(optionalUser.isPresent()) {
            Boolean Istrue = true;
            User user = optionalUser.get();

            while (Istrue == true) {
                System.out.println("What do you want to do?");
                System.out.println("0 - Back");
                System.out.println("1 - Trade is Relationship");
                System.out.println("2 - Trade your Password");

                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("New Relationship");
                        String Relationship = scanner.next();
                        user.setRelacionamento(Relationship);
                        break;
                    case 2:
                        System.out.println("New Password");
                        String newPassword = scanner.next();
                        user.setSenha(newPassword);
                        break;
                    default:
                        Istrue = false;
                        break;
                }
            }
            this.userRepository.save(user);
        }
        else{
            System.out.println("Your Email or Password is invalid");
        }
    }
    //Função inutil

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
