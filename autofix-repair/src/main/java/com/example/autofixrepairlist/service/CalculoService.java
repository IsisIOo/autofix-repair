package com.example.autofixrepairlist.service;

import com.example.autofixrepairlist.entity.Repair;

public class CalculoService {
    public double DescuentosSegunHora(Repair rec, double total_price) {
        // ahora veo si aplica el descuento segun la hora de ingreso

        //agregar dia
        int hour = rec.getAdmissionHour();//hora para determinar si se le aplica descuento por hora de llegada
        String day = rec.getAdmissionDateDayName().toLowerCase();//dia para determinar si se le aplica descuento por dia de llegada
        if (9 < hour && hour < 12 ) {//agregar que se entre lunes y jueves
            if(day.toLowerCase().equals("jueves")  || day.toLowerCase().equals("lunes")) {
                double total_price_hour = total_price * 0.1;
                total_price = total_price - total_price_hour;
                System.out.println("El descuento aplicado por la hora RECORD SERIVE SIN 1 : " + total_price_hour);
            }
        }
        else {
            total_price = total_price;
        }
        System.out.println("Precio total de la reparación con descuento por hora: RECORD SERVICE FUERA IF" + total_price);
        return total_price;}

    public double RecargoPorKilometraje(String patent, double total_price) {
        //recargo por kilometraje
        double total_price_km=0;
        String type1 = getCar(patent).getType();
        int km = getCar(patent).getKilometers();
        if (type1.toLowerCase().equals("sedan")) {
            if (km <= 5000) {
                total_price = total_price;
                System.out.println("No se aplicó recargo por kilometraje bajo 5000");
            }
            if (5001 < km && km <= 12000) {
                total_price_km = total_price * 0.03;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Sedan por kilometraje sobre 5000: " + total_price_km);
            }
            if (12001 < km && km <= 25000) {
                total_price_km = total_price * 0.07;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Sedan por kilometraje sobre 12000: " + total_price_km);
            }
            if (25001 < km && km <= 40000) {
                total_price_km = total_price * 0.12;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Sedan por kilometraje sobre 25000: " + total_price_km);
            }
            if (40000 < km) {
                total_price_km = total_price * 0.2;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Sedan por kilometraje sobre 40000: " + total_price_km);
            }
        }

        if (type1.toLowerCase().equals("hatchback")) {
            if (km < 5000) {
                total_price = total_price;
                System.out.println("No se aplicó recargo por kilometraje bajo 5000");
            }
            if (5001 < km && km < 12000) {
                total_price_km = total_price * 0.03;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Hatchback por kilometraje sobre 5000: " + total_price_km);
            }
            if (12001 < km && km < 25000) {
                total_price_km = total_price * 0.07;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Hatchback por kilometraje sobre 12000: " + total_price_km);
            }
            if (25001 < km && km < 40000) {
                total_price_km = total_price * 0.12;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Hatchback por kilometraje sobre 25000: " + total_price_km);
            }
            if (40000 < km) {
                total_price_km = total_price * 0.2;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a Hatchback por kilometraje sobre 40000: " + total_price_km);
            }
        }

        if (type1.toLowerCase().equals("suv") || type1.toLowerCase().equals("furgoneta") || type1.toLowerCase().equals("pickup")) {
            if (km < 5000) {
                total_price = total_price;
                System.out.println("No se aplicó recargo por kilometraje bajo 5000");
            }
            if (5001 < km && km < 12000) {
                total_price_km = total_price * 0.05;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a SUV por kilometraje sobre 5000: " + total_price_km);
            }
            if (12001 < km && km < 25000) {
                total_price_km = total_price * 0.09;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a SUV por kilometraje sobre 12000: " + total_price_km);
            }
            if (25001 < km && km < 40000) {
                total_price_km = total_price * 0.12;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a SUV por kilometraje sobre 25000: " + total_price_km);
            }
            if (40000 < km) {
                total_price_km = total_price * 0.2;
                total_price = total_price + total_price_km;
                System.out.println("El recargo aplicado a SUV por kilometraje sobre 40000: " + total_price_km);
            }
        }
        System.out.println("Precio total de la reparación con recargo por kilometraje kakaakaka: " + total_price +"y el valor es " + total_price_km);
        System.out.println("los kilometros son:" +km);
        System.out.println("el recargo por kilometraje es:" + total_price_km);
        return total_price;
    }

    public double recargoPorAntiguedad(String patent, double total_price) {
        //recargo por antiguedad
        int year_car = getCar(patent).getProductionYear();
        String type1 = getCar(patent).getType();
        if (type1.toLowerCase().equals("sedan") || type1.toLowerCase().equals("hatchback")) {
            if ((2024 - year_car) <= 5) {
                total_price = total_price;
                System.out.println("No se aplicó recargo por antiguedad bajo 5 años");
            }

            if ((2024 - year_car) >= 6 && (2024 - year_car) <= 10) {
                double total_price_year = total_price * 0.05;
                total_price = total_price + total_price_year;
                System.out.println("El recargo aplicado a Sedan por antiguedad entre 6 y 10 años: " + total_price_year);
            }

            if ((2024 - year_car) >= 11 && (2024 - year_car) <= 15) {
                double total_price_year = total_price * 0.09;
                total_price = total_price + total_price_year;
                System.out.println("El recargo aplicado a Sedan por antiguedad entre 11 y 15 años: " + total_price_year);
            }

            if ((2024 - year_car) >= 16) {
                double total_price_year = total_price * 0.15;
                total_price = total_price + total_price_year;
                System.out.println("El recargo aplicado a Sedan por antiguedad sobre 16 años: " + total_price_year);
            }
        }

        if (type1.toLowerCase().equals("suv") || type1.toLowerCase().equals("furgoneta") || type1.toLowerCase().equals("pickup") ) {
            if ((2024 - year_car) <= 5) {
                total_price = total_price;
                System.out.println("No se aplicó recargo por antiguedad bajo 5 años");
            }

            if ((2024 - year_car) >= 6 && (2024 - year_car) <= 10) {
                double total_price_year = total_price * 0.07;
                total_price = total_price + total_price_year;
                System.out.println("El recargo aplicado a SUV por antiguedad entre 6 y 10 años: " + total_price_year);
            }

            if ((2024 - year_car) >= 11 && (2024 - year_car) <= 15) {
                double total_price_year = total_price * 0.11;
                total_price = total_price + total_price_year;
                System.out.println("El recargo aplicado a SUV por antiguedad entre 11 y 15 años: " + total_price_year);
            }

            if ((2024 - year_car) >= 16) {
                double total_price_year = total_price * 0.2;
                total_price = total_price + total_price_year;
                System.out.println("El recargo aplicado a SUV por antiguedad sobre 16 años: " + total_price_year);
            }
        }

        System.out.println("Precio total de la reparación con recargo por antiguedad: " + total_price);
        return total_price;
    }

    public double recargoPorAtraso(Repair rec, double total_price) {
        //fechas de retiro indicadas por el taller
        int dia_retiro_taller = rec.getDepartureDateDay();
        int mes_retiro_taller = rec.getDepartureDateMonth();

        //fecha retirada por el cliente
        int dia_retiro_cliente = rec.getClientDateDay();
        int mes_retiro_cliente = rec.getClientDateMonth();

        //si el retiro del cliente es mayor al retiro del taller es pq está atrasado
        if ((dia_retiro_cliente - dia_retiro_taller) > 0 && mes_retiro_cliente == mes_retiro_taller) {
            int retraso = dia_retiro_cliente - dia_retiro_taller;
            System.out.println("el cliente esta retrasado por " + retraso + "DIAS");
            //corresponde a la cantidad de dias de retraso por 5% de cada dia que se demoro
            double recargo_dias = retraso * 0.05 * total_price;
            total_price = total_price + recargo_dias;

        }
        if ((dia_retiro_cliente - dia_retiro_taller) > 0 && (mes_retiro_cliente - mes_retiro_taller) > 0) {
            int retraso = dia_retiro_cliente - dia_retiro_taller;
            int retraso_meses = mes_retiro_cliente - mes_retiro_taller;
            System.out.println("el cliente esta retrasado por " + retraso + "dias y " + retraso_meses + "meses");
            //voy a considerar que los meses solo tienen 30 dias

            //retraso de dias simples
            double recargo_dias = retraso * 0.05 * total_price;
            //por ejemplo, si son 3 meses de diferencia, para sacar los dias seria 3 *30 =90 dias y cada dia tiene 0.05 de recargo
            double recargo_meses = retraso_meses * 30 * 0.05 * total_price;

            double recargo_total = recargo_dias + recargo_meses;
            total_price = total_price + recargo_total;
        }

        System.out.println("el total con atraso es:" + total_price);
        return total_price;
    }

}
