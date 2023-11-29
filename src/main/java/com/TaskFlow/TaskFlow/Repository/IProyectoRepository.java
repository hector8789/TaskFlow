package com.TaskFlow.TaskFlow.Repository;

import com.TaskFlow.TaskFlow.Entidades.Proyecto;
import com.TaskFlow.TaskFlow.Entidades.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoRepository extends JpaRepository<Proyecto,Long> {
}
