package com.tickets.service;

import com.tickets.domain.Actividad;
import java.util.List;

public interface ActividadService {
    
    // Se obtiene un listado de actividads en un List
    public List<Actividad> getActividades(boolean activos);
    
    //Se obtiene un Actividad, a partir de id de un actividad
    public Actividad getActividad(Actividad actividad);
    
    //Se inserta un nuevo actividad si el id del actividad está vacío
    //Se actualiza un actividad si el id del actividad NO está vacío
    public void save(Actividad actividad);
    
    //Se elimina el actividad que tiene el id pasado por parametro
    public void delete(Actividad actividad);
}
