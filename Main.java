import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Salones[] salones = {
            new Salones(1, "Pequeño", 500.00, 250),
            new Salones(2, "Pequeño", 500.00, 250),
            new Salones(3, "Mediano", 1000.00, 500),
            new Salones(4, "Mediano", 1000.00, 500),
            new Salones(5, "Grande", 1500.00, 800),
            new Salones(6, "Grande", 1500.00, 800)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("**Bienvenido**");
        System.out.println("1. Envia tu solicitud");
        System.out.println("2. Reporte de salones ");
        System.out.println("Ingresa el numero de la accion que deseas realizar");
        int op1 = scanner.nextInt();
        scanner.nextLine();

        switch (op1) {
            case 1:
                System.out.println("Por favor, ingrese los datos que se solicitan:");
                System.out.print("Nombre del Evento: ");
                String nombre = scanner.nextLine();
                System.out.print("Nombre del Encargado del evento: ");
                String encargado = scanner.nextLine();
                System.out.print("Tipo de evento (Pequeño, Mediano, Grande): ");
                String tipoEvento = scanner.nextLine();
                System.out.print("Cantidad de personas: ");
                int cantidadPersonas = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Fecha en que se realizará el evento (yyyy-mm-dd): ");
                String fechaString = scanner.nextLine();
                Date fecha = Date.valueOf(fechaString);
                System.out.print("Hora de inicio del evento (hh:mm:ss): ");
                String horaInicioString = scanner.nextLine();
                Time horaInicio = Time.valueOf(horaInicioString);
                System.out.print("Hora en la que termina el evento (hh:mm:ss): ");
                String horaFinString = scanner.nextLine();
                Time horaFin = Time.valueOf(horaFinString);
                Solicitud solicitud = new Solicitud(nombre, encargado, tipoEvento, cantidadPersonas, fecha, horaInicio, horaFin);

                int numeroSolicitud = solicitud.getNumeroSolicitud();
                boolean salonEncontrado = false;

                for (Salones salon : salones) {
                    if (salon.getTipo().equalsIgnoreCase(tipoEvento)) {
                        salonEncontrado = true;
                        if (salon.validarReglas(cantidadPersonas)) {
                            if (salon.validarDisponibilidad(fecha, horaInicio, horaFin)) {
                                Reserva nuevaReserva = new Reserva(nombre, encargado, salon.getNumero(), fecha, horaInicio);
                                salon.agregarReserva(nuevaReserva);
                                System.out.println("Reserva agregada para el salón " + salon.getNumero());
                            } else {
                                System.out.println("El salón no está disponible en la fecha y hora solicitadas.");
                                System.out.print("¿Deseas que te pongan en la lista de espera? (si, no): ");
                                String lista = scanner.nextLine();

                                if (lista.equalsIgnoreCase("si")) {
                                    salon.agregarListaEspera(numeroSolicitud);
                                    System.out.println("Solicitud " + numeroSolicitud + " agregada a la lista de espera del salón " + salon.getNumero());
                                }
                            }
                        } else {
                            System.out.println("El evento no cumple con las reglas para el salón " + salon.getNumero());
                        }
                        break;
                    }
                }

                if (!salonEncontrado) {
                    System.out.println("No se encontró un salón para el evento.");
                }
                break;

            case 2:
                System.out.println("**Reporte de Salones**");
                for (Salones salon : salones) {
                    System.out.println("Número de Salón: " + salon.getNumero());
                    System.out.println("Tipo: " + salon.getTipo());
                    System.out.println("Costo: $" + salon.getCosto());
                    System.out.println("Capacidad: " + salon.getCapacidad());
                    System.out.println("Número de Reservas: " + salon.getReservas().length);
                    
                    // Imprimir detalles de las reservas
                    System.out.println("Detalles de Reservas:");
                    for (Reserva reserva : salon.getReservas()) {
                        if (reserva != null) { 
                            System.out.println(" - Nombre del Evento: " + reserva.getNombre());
                            System.out.println("   Encargado: " + reserva.getEncargado());
                            System.out.println("   Fecha: " + reserva.getFecha());
                            System.out.println("   Hora: " + reserva.getHorario());
                        }
                    }
                    
                    System.out.print("Lista de Espera: ");
                    if (salon.getListaEspera().length > 0) {
                        for (int Solicitud : salon.getListaEspera()) {
                            System.out.print(Solicitud + " ");
                        }
                    } else {
                        System.out.print("No hay solicitudes en espera.");
                    }
                    System.out.println("\n");
                }
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }

        scanner.close();
    }
}

