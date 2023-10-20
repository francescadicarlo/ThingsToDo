package it.todolist.repository;

import it.todolist.dto.UtenteDTO;
import it.todolist.model.Utente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UtenteRepo extends CrudRepository<Utente, Long> {
//    List<Utente> findByNome(String nome);
      Utente findByNome (String nome);

}
