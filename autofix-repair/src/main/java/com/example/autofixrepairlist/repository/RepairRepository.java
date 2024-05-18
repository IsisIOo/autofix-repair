package com.example.autofixrepairlist.repository;

import com.example.autofixrepairlist.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
        List<Repair> findByPatent(String patent); //no borrar, esta mala

        //obtener un solo registro al cual le puedo hacer un get luego
        @Query(value = "SELECT * FROM record WHERE record.patent = :patent", nativeQuery = true)
        Repair findByPatentOne(@Param("patent") String patent);

}
