package com.tickets.service.impl;

import com.tickets.dao.ActividadDao;
import com.tickets.domain.Actividad;
import com.tickets.service.ActividadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadDao actividadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Actividad> getActividades(boolean activos) {
        var lista=actividadDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

    }

    @Override
    @Transactional
    public void save(Actividad actividad) {
        actividadDao.save(actividad);
    }

    @Override
    @Transactional
    public void delete(Actividad actividad) {
        actividadDao.delete(actividad);
    }

    @Override
    @Transactional(readOnly = true)
    public Actividad getActividad(Actividad actividad) {
        return actividadDao.findById(actividad.getIdActividad()).orElse(null);
    }

}
/*@Autowired
    private ActividadDao actividadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Actividad> getActividads() {
        var lista=actividadDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

    }

    @Override
    @Transactional(readOnly = true)
    public Actividad getActividad(Actividad actividad) {
        return actividadDao.findById(actividad.getIdActividad()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Actividad actividad) {
        actividadDao.save(actividad);
    }

    @Override
    @Transactional
    public void delete(Actividad actividad) {
        actividadDao.delete(actividad);
    }*/