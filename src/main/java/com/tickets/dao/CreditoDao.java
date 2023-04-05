package com.tickets.dao;

import com.tickets.domain.Cliente;
import com.tickets.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoDao extends JpaRepository<Credito, Long> {

}
