package com.example.autofixrepairlist.repository;

import com.example.autofixrepairlist.entity.Repair;
import com.example.autofixrepairlist.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailsRepository extends JpaRepository<Repair, Long> {
    @Query(value = "SELECT * FROM details WHERE details.patent = :patent", nativeQuery = true)
    Details findByPatentDetails(@Param("patent") String patent);

    @Query(value = "SELECT * FROM details WHERE details.repair_id = :repair.id", nativeQuery = true)
    Details findByIdDetails(@Param("repair.id") Long repairId);
}
