
import java.sql.Date;
import java.sql.Time;

public class Salones {
    private int Numero;
    private String Tipo;
    private double Costo;
    private int Capacidad;
    private int[] ListaEspera;
    private Reserva[] reservas; 
    private int numReservas; 

    public Salones(int numero, String tipo, double costo, int capacidad) {
        this.Numero = numero;
        this.Tipo = tipo;
        this.Costo = costo;
        this.Capacidad = capacidad;
        this.ListaEspera = new int[0];
        this.reservas = new Reserva[0]; 
        this.numReservas = 0; 
    }

    public int getNumero() {
        return Numero;
    }
    
    public String getTipo() {
        return Tipo;
    }
    
    public double getCosto() {
        return Costo;
    }
    
    public int getCapacidad() {
        return Capacidad;
    }
   
    public int[] getListaEspera() {
        return ListaEspera;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public boolean validarReglas(int CantidadPersonas) {
        return CantidadPersonas <= Capacidad;
    }
    
    public boolean validarDisponibilidad(Date fecha, Time horaInicio, Time horaFin) {
        for (Reserva reserva : reservas) {
            if (reserva != null && reserva.getFecha().equals(fecha)) {
                if ((horaInicio.before(reserva.getHorario()) && horaFin.after(reserva.getHorario())) || 
                    (horaInicio.equals(reserva.getHorario()) || horaFin.equals(reserva.getHorario()))) {
                    return false;
                }
            }
        }
        return true; 
    }

    public void agregarReserva(Reserva reserva) {
        if (validarDisponibilidad(reserva.getFecha(), reserva.getHorario(), reserva.getHorario())) {
            Reserva[] nuevaListaReservas = new Reserva[reservas.length + 1];
            System.arraycopy(reservas, 0, nuevaListaReservas, 0, reservas.length);
            nuevaListaReservas[reservas.length] = reserva;
            reservas = nuevaListaReservas;
            numReservas++;
        } else {
            System.out.println("No se puede agregar la reserva, horario no disponible.");
        }
    }

    public void agregarListaEspera(int numeroSolicitud) {
        int[] nuevaListaEspera = new int[ListaEspera.length + 1];
        System.arraycopy(ListaEspera, 0, nuevaListaEspera, 0, ListaEspera.length);
        nuevaListaEspera[ListaEspera.length] = numeroSolicitud;
        this.ListaEspera = nuevaListaEspera;
    }
}
