package com.eicon.testecompra.services;

import com.eicon.testecompra.domain.Cliente;
import com.eicon.testecompra.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Transactional
    public Cliente findById(Integer id) {
        Cliente cliente = repo.findById(id).get();
        return cliente;
    }

    @Transactional
    public List<Cliente> findAll() {
        List<Cliente> list = repo.findAll();
        return list;
    }

}
