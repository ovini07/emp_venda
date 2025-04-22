package com.map.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.ItemVenda;
import com.map.repository.ItemVendaRepository;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    @Autowired
    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public List<ItemVenda> getAllItemVendas() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda getItemVendaById(Long id) {
        Optional<ItemVenda> itemVenda = itemVendaRepository.findById(id);
        return itemVenda.orElse(null);
    }

    public ItemVenda saveItemVenda(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    public ItemVenda updateItemVenda(Long id, ItemVenda updatedItemVenda) {
        Optional<ItemVenda> existingItemVenda = itemVendaRepository.findById(id);
        if (existingItemVenda.isPresent()) {
            updatedItemVenda.setId(id);
            return itemVendaRepository.save(updatedItemVenda);
        }
        return null;
    }

    public boolean deleteItemVenda(Long id) {
        Optional<ItemVenda> existingItemVenda = itemVendaRepository.findById(id);
        if (existingItemVenda.isPresent()) {
            itemVendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}