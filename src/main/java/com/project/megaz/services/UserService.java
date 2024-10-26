package com.project.megaz.services;

import com.project.megaz.entity.User;
import com.project.megaz.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;
// Serviços aqui é onde você vai interagir com o repositório, ou seja, com o banco de dados
@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
    //Função que não vai servir pra nada
    public void menu(Scanner scanner) {
        Boolean Istrue = true;

        while (Istrue == true) {
            System.out.println("What do you want to do?");
            System.out.println("0 - Back");
            System.out.println("1 - Register a User");
            System.out.println("2 - Update a User");
            System.out.println("3 - View a User");
            System.out.println("4 - View all Users");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Register(scanner);
                    break;
                case 2:
                    Update(scanner);
                    break;
                case 3:
                    view(scanner);
                    break;
                case 4:
                    viewall();
                    break;
                default:
                    Istrue = false;
                    break;
            }
        }
    }
    //Função para testar no banco de dados, mas vai existir futuramente
    public void Register(Scanner scanner) {
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Relacionamento: ");
        String relacionamento = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Password: ");
        String senha = scanner.next();
        User user = new User(nome, email, senha, relacionamento, age);
        this.userRepository.save(user);
        System.out.println("You are Register");

    }
    //Mesma ideia da de cima
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
    public void view(Scanner scanner) {
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();

        Optional<User> optionalUser = this.userRepository.findByEmailAndSenha(email, password);
        if(optionalUser.isPresent()) {
            System.out.println("entrou");
            User user = optionalUser.get();
            System.out.println(user);
        }
    }
    //Função para ver status, usado no controller.
    public Iterable<User> viewall() {
        //bd = banco de dados
        //FindAll Significa que você vai puxar todos os user do bd nesse caso
        Iterable<User> users = this.userRepository.findAll();
        return users;


    }

}
