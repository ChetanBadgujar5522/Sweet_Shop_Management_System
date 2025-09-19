package com.sweetshop.service;

import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SweetService {

    @Autowired
    private SweetRepository repo;

    public Sweet create(Sweet s) { return repo.save(s); }
    public List<Sweet> list() { return repo.findAll(); }
    public Optional<Sweet> get(Long id) { return repo.findById(id); }

    public Sweet update(Long id, Sweet s) {
        Sweet existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
        existing.setName(s.getName());
        existing.setCategory(s.getCategory());
        existing.setPrice(s.getPrice());
        existing.setQuantity(s.getQuantity());
        return repo.save(existing);
    }

    public void delete(Long id) { repo.deleteById(id); }

    public List<Sweet> searchByName(String name) { return repo.findByNameContainingIgnoreCase(name); }
    public List<Sweet> searchByCategory(String category) { return repo.findByCategoryContainingIgnoreCase(category); }
    public List<Sweet> searchByPriceRange(double min, double max) { return repo.findByPriceBetween(min, max); }

    public Sweet purchase(Long id, int qty) {
        Sweet s = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        if (s.getQuantity() < qty) throw new RuntimeException("Insufficient stock");
        s.setQuantity(s.getQuantity() - qty);
        return repo.save(s);
    }

    public Sweet restock(Long id, int qty) {
        Sweet s = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        s.setQuantity(s.getQuantity() + qty);
        return repo.save(s);
    }
}
