package com.example.autofixrepair.controller;

import com.example.autofixrepair.entity.Repair;
import com.example.autofixrepair.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/record")
@CrossOrigin("*")
public class RepairController {
    @Autowired
    RepairService repairService;

    //todos los weas
    @GetMapping("/")
    //este obtiene todos los registros existentes
    public ResponseEntity<List<Repair>> listRecords() {
        List<Repair> recordHistory = repairService.getRecordRepository();
        return ResponseEntity.ok(recordHistory);

    }

    @GetMapping("/patent1/{patent}")
    //recibe solo un registro
    public ResponseEntity<Repair> getOneRecordByPatent(@PathVariable String patent) {
        Repair recordHistory = repairService.getOneRecordRespository(patent);
        return ResponseEntity.ok(recordHistory);
    }

    @PostMapping("/")
    public ResponseEntity<Repair> saveRecord(@RequestBody Repair recordHistory) {
        Repair recordHistoryNew = repairService.saveRecord(recordHistory);
        return ResponseEntity.ok(recordHistoryNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecordById(@PathVariable Long id) throws Exception {
        var isDeleted = repairService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/newRecord/")
    public ResponseEntity<Repair> updateRecord(@RequestBody Repair rec){

        //Creamos una nueva entidad con new
        Repair recordHistory = new Repair();

        //Conseguimos los costos para colocarlo en el auto
        double totalAmount = repairService.getCostbyRepair(rec);

        //Vamos a colocar cada uno de los componentes en el nuevo auto
        recordHistory.setPatent(rec.getPatent());
        recordHistory.setId(rec.getId());
        recordHistory.setAdmissionHour(rec.getAdmissionHour());
        recordHistory.setAdmissionDateDayName(rec.getAdmissionDateDayName());
        recordHistory.setAdmissionDateDay(rec.getAdmissionDateDay());
        recordHistory.setAdmissionDateMonth(rec.getAdmissionDateMonth());
        recordHistory.setRepairType(rec.getRepairType());
        recordHistory.setDepartureDateDay(rec.getDepartureDateDay());
        recordHistory.setDepartureDateMonth(rec.getDepartureDateMonth());
        recordHistory.setDepartureHour(rec.getDepartureHour());
        recordHistory.setClientDateDay(rec.getClientDateDay());
        recordHistory.setClientDateMonth(rec.getClientDateMonth());
        recordHistory.setClientHour(rec.getClientHour());
        recordHistory.setTotalAmount(totalAmount);

        Repair recordHistoryNew = repairService.saveRecord(recordHistory);
        return ResponseEntity.ok(recordHistoryNew);
    }






}