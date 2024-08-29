import java.sql.Date;
import java.sql.Time;

public class Reserva {
    private String nombre;
    private String encargado;
    private int salonAsignado;
    private Date fecha;
    private Time horario;

    public Reserva(String nombre, String encargado, int salonAsignado, Date fecha, Time horario) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.salonAsignado = salonAsignado;
        this.fecha = fecha;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public int getSalonAsignado() {
        return salonAsignado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHorario() {
        return horario;
    }

    public boolean asignarSalon(int salon) {
        if (salonAsignado == 0) {
            salonAsignado = salon; 
            return true;
        } else {
            return false;
        }
    }
}
