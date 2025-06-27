package paquete;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class pruebaUno {
	public static void main(String args[]) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        
        LocalDate fechaInicio = LocalDate.parse("01/04/2025", formatter);
        LocalDate fechaFin = LocalDate.parse("2025-05-26");

        
        int contadorDias = 0;
        
        for (LocalDate fechaTemp = fechaInicio; !fechaTemp.equals(fechaFin); contadorDias++) {
            int dia = fechaTemp.getDayOfMonth();
            int mes = fechaTemp.getMonthValue();
            int anio = fechaTemp.getYear();

            dia++;
            int diasEnMes = LocalDate.of(anio, mes, 1).lengthOfMonth();
            if (dia > diasEnMes) {
                dia = 1;
                mes++;
                if (mes > 12) {
                    mes = 1;
                    anio++;
                }
            }

            fechaTemp = LocalDate.of(anio, mes, dia);
        }

        System.out.println("Días entre fecha inicio y fecha fin: " + contadorDias);

        
        LocalDate etapa1Fin = avanzarDias(fechaInicio, 13);
        System.out.println("\nEtapa 1:");
        System.out.println("Fecha fin de etapa 1: " + etapa1Fin);

        LocalDate etapa2Inicio = avanzarDias(etapa1Fin, 1);
        LocalDate etapa2Fin = avanzarDias(etapa2Inicio, 28);
        System.out.println("\nEtapa 2:");
        System.out.println("Fecha inicio de etapa 2: " + etapa2Inicio);
        System.out.println("Fecha fin de etapa 2: " + etapa2Fin);

        LocalDate etapa3Inicio = avanzarDias(etapa2Fin, 1);
        LocalDate etapa3Fin = avanzarDias(etapa3Inicio, 14);
        System.out.println("\nEtapa 3:");
        System.out.println("Fecha inicio de etapa 3: " + etapa3Inicio);
        System.out.println("Fecha fin de etapa 3: " + etapa3Fin);
    }
	
	
    public static LocalDate avanzarDias(LocalDate fecha, int dias) {
        LocalDate fechaTemp = fecha;
        for (int i = 0; i < dias; i++) {
            int dia = fechaTemp.getDayOfMonth();
            int mes = fechaTemp.getMonthValue();
            int anio = fechaTemp.getYear();

            dia++;
            int diasEnMes = LocalDate.of(anio, mes, 1).lengthOfMonth();
            if (dia > diasEnMes) {
                dia = 1;
                mes++;
                if (mes > 12) {
                    mes = 1;
                    anio++;
                }
            }

            fechaTemp = LocalDate.of(anio, mes, dia);
        }
        return fechaTemp;
	}
}
