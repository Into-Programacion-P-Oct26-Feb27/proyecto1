package proyecto1;

import java.util.Locale;
import java.util.Scanner;

public class Proyecto1avance {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);

        // Variables de entrada y control
        double metaRecreativa = 0;
        double tiempoTotalDia = 0;
        double tiempoAcademicoDia = 0;
        double tiempoRecreativoDia = 0;

        // Acumuladores y contadores
        double totalSemana = 0;
        double totalAcademico = 0;
        double totalRecreativo = 0;
        int diasSuperoMeta = 0;
        String cadenaAcumuladora = "";

        boolean bandera = true;

        System.out.println("=== CONTROL Y ANALISIS DE USO DE DISPOSITIVOS MOVILES ===");

        // 1. Ingreso y validacion de la meta diaria recreativa
        while (bandera) {
            System.out.println("Ingrese su meta diaria maxima de uso recreativo (horas, 0 - 24):");
            metaRecreativa = entrada.nextDouble();

            if ((metaRecreativa >= 0) && (metaRecreativa <= 24)) {
                bandera = false;
            } else {
                System.out.println("Error: La meta debe estar entre 0 y 24 horas.");
            }
        }

        // 2. Registro de datos por cada dia de la semana (7 dias)
        int dia = 1;
        int limiteDias = 7;

        while (dia <= limiteDias) {
            System.out.printf("\n--- Dia %d ---\n", dia);

            // Validar tiempo total del dia
            bandera = true;
            while (bandera) {
                System.out.println("Ingrese el tiempo total de uso del telefono (horas):");
                tiempoTotalDia = entrada.nextDouble();

                if ((tiempoTotalDia >= 0) && (tiempoTotalDia <= 24)) {
                    bandera = false;
                } else {
                    System.out.println("Error: El tiempo debe estar entre 0 y 24 horas.");
                }
            }

            // Validar tiempo academico del dia
            bandera = true;
            while (bandera) {
                System.out.println("Ingrese el tiempo destinado a actividades academicas (horas):");
                tiempoAcademicoDia = entrada.nextDouble();

                if ((tiempoAcademicoDia >= 0) && (tiempoAcademicoDia <= tiempoTotalDia)) {
                    bandera = false;
                } else {
                    System.out.printf("Error: El tiempo academico debe estar entre 0 y %.2f horas.\n",
                            tiempoTotalDia);
                }
            }

            // Calculo parcial del tiempo recreativo diario
            tiempoRecreativoDia = tiempoTotalDia - tiempoAcademicoDia;
            System.out.printf("Tiempo recreativo del dia %d: %.2f horas\n", dia, tiempoRecreativoDia);

            // Acumulacion basica
            totalSemana = totalSemana + tiempoTotalDia;
            totalAcademico = totalAcademico + tiempoAcademicoDia;
            totalRecreativo = totalRecreativo + tiempoRecreativoDia;

            dia = dia + 1;
        }

        // TODO: Completar comparacion con meta diaria, porcentajes semanales y reporte final
        System.out.printf("\n[AVANCE] Registro semanal completado. Total acumulado: %.2f horas.\n",
                totalSemana);
    }
}
