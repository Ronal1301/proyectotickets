package com.tickets.service;

import com.tickets.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
    
    //Se obtiene un Categoria, a partir de id de un categoria
    public Categoria getCategoria(Categoria categoria);
    
    //Se inserta un nuevo categoria si el id del categoria está vacío
    //Se actualiza un categoria si el id del categoria NO está vacío
    public void save(Categoria categoria);
    
    //Se elimina el categoria que tiene el id pasado por parametro
    public void delete(Categoria categoria);
}
