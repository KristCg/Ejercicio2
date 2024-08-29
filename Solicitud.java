import java.sql.Date;
import java.sql.Time;


public class Solicitud {
    private static int contador = 0;
    private int numeroSolicitud;
    private String nombre;
    private String encargado;
    private String tipoEvento;
    private int cantidadPersonas;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    public Solicitud(String nombre, String encargado, String tipoEvento, int cantidadPersonas, Date fecha, Time horaInicio, Time horaFin) {
        this.numeroSolicitud = ++contador;
        this.nombre = nombre;
        this.encargado = encargado;
        this.tipoEvento = tipoEvento;
        this.cantidadPersonas = cantidadPersonas;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }
}
