package com.project.megaz.repository;

import com.project.megaz.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
// Os repositórios são as classes onde você acessa o banco de dados
//No extends CrudRepository você basicamente passa a qual classe você se refere e o tipo da chave primária
// findby é outra anotação do spring, nesse caso para buscar no banco o email e senha.
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmailAndSenha(String email, String senha);

}
