package com.TaskFlow.TaskFlow.Repository;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPuestoRepository extends JpaRepository<Puesto,Long> {
}
