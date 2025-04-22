package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Venda;
import com.map.repository.VendaRepository;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVendaById(Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.orElse(null);
    }

    public Venda saveVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda updateVenda(Long id, Venda updatedVenda) {
        Optional<Venda> existingVenda = vendaRepository.findById(id);
        if (existingVenda.isPresent()) {
            updatedVenda.setId(id);
            return vendaRepository.save(updatedVenda);
        }
        return null;
    }

    public boolean deleteVenda(Long id) {
        Optional<Venda> existingVenda = vendaRepository.findById(id);
        if (existingVenda.isPresent()) {
            vendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}