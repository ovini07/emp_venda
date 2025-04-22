package com.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.entities.ItemVenda;
import com.map.service.ItemVendaService;

@RestController
@RequestMapping("/itemVenda")
public class ItemVendaController {

	private final ItemVendaService itemVendaService;

	@Autowired
	public ItemVendaController(ItemVendaService itemVendaService) {
		this.itemVendaService = itemVendaService;
	}

	@PostMapping("/")
	public ResponseEntity<ItemVenda> criarItemVenda(@RequestBody ItemVenda itemVenda) {
		ItemVenda novoItem = itemVendaService.saveItemVenda(itemVenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
	}

	@GetMapping("/")
	public ResponseEntity<List<ItemVenda>> getAllItemVendas() {
		List<ItemVenda> itemVendas = itemVendaService.getAllItemVendas();
		return ResponseEntity.ok(itemVendas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemVenda> getItemVendaById(@PathVariable Long id) {
		ItemVenda item = itemVendaService.getItemVendaById(id);
		if (item != null) {
			return ResponseEntity.ok(item);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemVenda> atualizarItemVenda(@PathVariable Long id, @RequestBody ItemVenda itemVenda) {
		ItemVenda atualizado = itemVendaService.updateItemVenda(id, itemVenda);
		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItemVenda(@PathVariable Long id) {
		boolean deletado = itemVendaService.deleteItemVenda(id); // Aqui é deleteItemVenda
		if (deletado) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}