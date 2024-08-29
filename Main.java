import java.util.Scanner;
import java.sql.Date;
import java.sql.Time;

public class Main{
    private int op1;
    public static void main(String[] args){
        Salones [] salones = {
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
        switch (op1) {
            case 1:
                op1 = 1;
                System.out.println("Porfavor, ingrese los datos que se solicitan:");
                System.out.println("Nombre del Evento" );
                String nombre = scanner.nextLine();
                System.out.print("Nombre del Encargado del evento: ");
                String encargado = scanner.nextLine();
                System.out.print("Tipo de evento: ");
                String tipoEvento = scanner.nextLine();
                System.out.print("Fecha en que se realizara el evento(yyyy-mm-dd): ");
                String fechaString = scanner.nextLine();
                Date fecha = Date.valueOf(fechaString);
                System.out.print("Hora de inicio del evento:(hh:mm:ss) ");
                String horaInicioString = scanner.nextLine();
                Time horaInicio = Time.valueOf(horaInicioString);
                System.out.print("Hora en la que termianr el evento(hh:mm:ss): ");
                String horaFinString = scanner.nextLine();
                Time horaFin = Time.valueOf(horaFinString);
                Solicitud solicitud = new Solicitud(nombre, encargado, tipoEvento, fecha, horaInicio, horaFin);
                break;
            case 2:
                op1 = 2;
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}