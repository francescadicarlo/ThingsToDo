package it.todolist.service;

import it.todolist.converter.DettaglioConverter;
import it.todolist.model.Singleton;
import it.todolist.repository.DettaglioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DettaglioService {

    @Autowired
    DettaglioRepo repo;
    @Autowired
    DettaglioConverter conv;
    public static Singleton getSingleton() {
        return Singleton.getInstance();
    }
}
