package Ejercicio2;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Solicitud{
    private int numeroSolicitud;
    private String nombre;
    private String encargado;
    private String tipoEvento;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    public Solicitud(int numeroSolicitud, String nombre, String encargado,String tipoEvento, Date fecha, Time horaInicio, Time horaFin){
        this.numeroSolicitud = numeroSolicitud;
        this.nombre = nombre;
        this.encargado = encargado;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public int getNumeroSolicitud(){
        return numeroSolicitud;
    }
    public String getNombre(){
        return nombre;
    }
    public String getEncargado(){
        return encargado;
    }
    public String getTipoEvento(){
        return tipoEvento;
    }
    public Date getFecha(){
        return fecha;
    }
    public Time getHoraInicio(){
        return horaInicio;
    }
    public Time getHoraFin(){
        return horaFin;
    }
    public boolean verificarConflicto(List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().equals(this.fecha)) {
                if ((this.horaInicio.before(reserva.getHorario()) && this.horaFin.after(reserva.getHorario())) ||
                    (this.horaInicio.equals(reserva.getHorario()) && this.horaFin.after(reserva.getHorario())) ||
                    (this.horaInicio.before(reserva.getHorario()) && this.horaFin.equals(reserva.getHorario()))) {
                    return true;
                }
            }
        }
        return false; 
    }
}