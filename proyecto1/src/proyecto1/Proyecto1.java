package proyecto1;

import java.util.Scanner;

public class Proyecto1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables acumuladoras y contadores
        double totalSemana = 0;
        double totalAcademico = 0;
        double totalRecreativo = 0;
        int diasSuperoMeta = 0;

        System.out.println("=== CONTROL Y ANÁLISIS DE USO DE DISPOSITIVOS MÓVILES ===");

        // 1. Solicitar y validar la meta diaria de uso recreativo
        double metaRecreativa;
        do {
            System.out.print("Ingrese su meta diaria máxima de uso recreativo (en horas, 0 - 24): ");
            metaRecreativa = sc.nextDouble();
            if (metaRecreativa < 0 || metaRecreativa > 24) {
                System.out.println("Error: La meta debe estar entre 0 y 24 horas.");
            }
        } while (metaRecreativa < 0 || metaRecreativa > 24);

        // 2. Ciclo para registrar los 7 días de la semana
        for (int dia = 1; dia <= 7; dia++) {
            System.out.println("\n--- Día " + dia + " ---");
            double tiempoTotalDia;
            double tiempoAcademicoDia;

            // Validar tiempo total diario (entre 0 y 24 horas)
            do {
                System.out.print("Tiempo total de uso del teléfono (horas): ");
                tiempoTotalDia = sc.nextDouble();
                if (tiempoTotalDia < 0 || tiempoTotalDia > 24) {
                    System.out.println("Error: El tiempo debe ser positivo y no superar las 24 horas.");
                }
            } while (tiempoTotalDia < 0 || tiempoTotalDia > 24);

            // Validar tiempo académico (no negativo y no mayor al tiempo total del día)
            do {
                System.out.print("Tiempo destinado a actividades académicas (horas): ");
                tiempoAcademicoDia = sc.nextDouble();
                if (tiempoAcademicoDia < 0 || tiempoAcademicoDia > tiempoTotalDia) {
                    System.out.println("Error: El tiempo académico debe estar entre 0 y " + tiempoTotalDia + " horas.");
                }
            } while (tiempoAcademicoDia < 0 || tiempoAcademicoDia > tiempoTotalDia);

            // Calcular tiempo recreativo del día
            double tiempoRecreativoDia = tiempoTotalDia - tiempoAcademicoDia;
            System.out.printf("Tiempo recreativo registrado hoy: %.2f horas.%n", tiempoRecreativoDia);

            // Informar si se encuentra dentro del límite o si lo supera
            if (tiempoRecreativoDia <= metaRecreativa) {
                System.out.println("Estado: Dentro del límite establecido.");
            } else {
                System.out.println("Estado: ¡Has superado tu meta diaria recreativa!");
                diasSuperoMeta++;
            }

            // Acumular totales semanales
            totalSemana += tiempoTotalDia;
            totalAcademico += tiempoAcademicoDia;
            totalRecreativo += tiempoRecreativoDia;
        }

        // 3. Cálculos finales de la semana
        double promedioDiario = totalSemana / 7.0;
        double porcentajeAcademico = (totalSemana > 0) ? (totalAcademico / totalSemana) * 100 : 0;
        double porcentajeRecreativo = (totalSemana > 0) ? (totalRecreativo / totalSemana) * 100 : 0;

        // 4. Mostrar resultados esperados
        System.out.println("\n==========================================");
        System.out.println("          RESUMEN DE LA SEMANA            ");
        System.out.println("==========================================");
        System.out.printf("1. Tiempo total de uso semanal: %.2f horas%n", totalSemana);
        System.out.printf("2. Tiempo acumulado académico: %.2f horas%n", totalAcademico);
        System.out.printf("3. Tiempo acumulado recreativo: %.2f horas%n", totalRecreativo);
        System.out.printf("4. Promedio diario de uso: %.2f horas/día%n", promedioDiario);
        System.out.println("5. Días en que se superó la meta recreativa: " + diasSuperoMeta + " de 7 días");
        System.out.printf("6. Distribución del tiempo: %.1f%% Académico | %.1f%% Recreativo%n",
                porcentajeAcademico, porcentajeRecreativo);

        // 7. Valoración general sobre el cumplimiento de la meta
        System.out.print("7. Valoración general: ");
        if (diasSuperoMeta == 0) {
            System.out.println("¡Excelente! Cumpliste tu meta recreativa todos los días.");
        } else if (diasSuperoMeta <= 2) {
            System.out.println("Buen trabajo. Mantuviste un buen control la mayor parte de la semana.");
        } else if (diasSuperoMeta <= 4) {
            System.out.println("Regular. Superaste tu límite varios días; intenta regular tus tiempos.");
        } else {
            System.out.println("Atención: Superaste tu meta la mayoría de la semana. Es recomendable reducir el uso recreativo.");
        }
        System.out.println("==========================================");

        sc.close();
    }
}
