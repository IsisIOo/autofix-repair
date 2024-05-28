package com.example.autofixrepairlist.repository;

import com.example.autofixrepairlist.entity.Repair;
import com.example.autofixrepairlist.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Repair, Long> {

    //encontrar todos los detalles que llega a tener una pantente
    @Query(value = "SELECT * FROM details WHERE details.patent = :patent", nativeQuery = true)
    List<Details> findByPatentDetails(@Param("patent") String patent);

    //encontrar un solo detalle por id
    @Query(value = "SELECT * FROM details WHERE details.repair_id = :repair.id", nativeQuery = true)
    Details findDetailsById(@Param("repairId") Long repairId);



}
