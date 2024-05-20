package com.example.autofixrepairlist.controller;

import com.example.autofixrepairlist.entity.Repair;
import com.example.autofixrepairlist.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair")
@CrossOrigin("*")
public class RepairController {
    @Autowired
    RepairService repairService;

    //todos los weas
    @GetMapping
    //este obtiene todos los registros existentes
    public ResponseEntity<List<Repair>> getAllRepair() {
        List<Repair> recordHistory = repairService.getRecordRepository();
        return ResponseEntity.ok(recordHistory);

    }

    @GetMapping("/{patent}")
    //recibe solo un registro
    public ResponseEntity<Repair> getOneRepairByPatent(@PathVariable String patent) {
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
        Repair repairHistory = new Repair();

        //Conseguimos los costos para colocarlo en el auto
        double totalAmount = repairService.getCostbyRepair(rec);

        //Vamos a colocar cada uno de los componentes en el nuevo auto
        repairHistory.setId(rec.getId());

        //FECHAS CLIENTE
        repairHistory.setAdmissionHour(rec.getAdmissionHour());
        repairHistory.setAdmissionDateDayName(rec.getAdmissionDateDayName());
        repairHistory.setAdmissionDateDay(rec.getAdmissionDateDay());
        repairHistory.setAdmissionDateMonth(rec.getAdmissionDateMonth());

        //repairHistory.setRepairType(rec.getRepairType());

        //FECHAS TALLER
        repairHistory.setDepartureDateDay(rec.getDepartureDateDay());
        repairHistory.setDepartureDateMonth(rec.getDepartureDateMonth());
        repairHistory.setDepartureHour(rec.getDepartureHour());

        //FECHAS SALIDA CLIENTE
        repairHistory.setClientDateDay(rec.getClientDateDay());
        repairHistory.setClientDateMonth(rec.getClientDateMonth());
        repairHistory.setClientHour(rec.getClientHour());

        repairHistory.setTotalAmount(totalAmount);

        Repair repairHistoryNew = repairService.saveRecord(repairHistory);
        return ResponseEntity.ok(repairHistoryNew);
    }

    @GetMapping("/byCar/{}")
    public ResponseEntity<List<Repair>> getByStudentId(@PathVariable("carId") Long carId) {
        List<Repair> repairs = repairService.byCarId(carId);
        return ResponseEntity.ok(repairs);
    }






}