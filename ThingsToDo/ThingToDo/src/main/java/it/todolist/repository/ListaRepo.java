package it.todolist.repository;

import it.todolist.model.Lista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ListaRepo extends CrudRepository<Lista, Long> {

}
