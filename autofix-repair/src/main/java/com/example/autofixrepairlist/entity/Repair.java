package com.example.autofixrepairlist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "repair")
@Data
@NoArgsConstructor
@AllArgsConstructor

//ESTE CORRESPONDE AL MICROSERVICIO 3
public class Repair {
    //clase para el historial de reparaciones
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id; //usaremos el id para relacionarlo con los detalles

    //private Long car_Id; //id del auto al que se le realizan las operaciones aun no sé

    //------------FECHA DE LLEGADA AL TALLER----------------
    private String admissionDateDayName; //nombre del dia de llegada
    private int admissionDateDay; //fecha de llega al taller
    private int admissionDateMonth;
    private int admissionHour;   //hora de llegada


    //ESTO SEGUN AHORA VA EN OTRO ARCHIVO
    //private String repairType; //tipo de reparacion/es


    //-----------FECHAS DE SALIDA DADAS POR EL TALLER---------------
    private int departureDateDay; //fecha de salida del vehiculo
    private int departureDateMonth;
    private int departureHour; //hora de salida, asumo que deberia ser igual a la de llegada

    //-----------FECHAS DE SALIDA DEL CLIENTE---------------
    private int clientDateDay; //fecha en la que el cliente se lleva el vehiculo
    private int clientDateMonth;
    private int clientHour; //hora en la que el cliente se lleva el vehiculo


    //-----------MONTOS DE PAGO---------------
    //para calcularlos se debe recuperar los datos desde otro servicio
    private double totalAmount;
    private double totalDiscounts;
    private double totalRecharges;
    private double totalIva;
}

