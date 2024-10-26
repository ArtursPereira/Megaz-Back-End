package com.project.megaz.repository;
import com.project.megaz.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// Os repositórios são as classes onde você acessa o banco de dados
//No extends CrudRepository você passa basicamente a qual classe você se refere e o tipo da chave primária
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
