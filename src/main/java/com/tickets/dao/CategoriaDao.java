package com.tickets.dao;

import com.tickets.domain.Categoria;
import com.tickets.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
