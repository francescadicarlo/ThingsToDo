package it.todolist.repository;

import it.todolist.model.Dettaglio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DettaglioRepo extends CrudRepository <Dettaglio, Long> {

}
