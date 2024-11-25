package com.laraconchego.repository;

import com.laraconchego.model.Lar;
import com.laraconchego.model.Lar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LarRepository extends JpaRepository<Lar, Long> {
    void deleteLarById(Long id);

    List<Lar> findAllLars();

    Lar save(Lar lar);
}
