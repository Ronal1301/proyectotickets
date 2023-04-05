package com.tickets.dao;

import com.tickets.domain.Actividad;
import com.tickets.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadDao extends JpaRepository<Actividad, Long> {

}
