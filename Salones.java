public class Salones{
    private int Numero;
    private String Tipo;
    private double Costo;
    private int Capacidad;
    private int[] ListaEspera;



    public Salones(int numero, string tipo, double costo, int capacidad){
        this.Numero = numero;
        this.Tipo = tipo;
        this.Costo = costo;
        this.Capacidad = capacidad;
        this.ListaEspera = new int[0];

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


    public boolean validarReglas(int CantidadPersonas){
        if (CantidadPersonas <= capacidad ){
            return true;
        }

        else if (CantidadPersonas > capacidad){
            return false;
        }

    }

    public boolean validarDisponibilidad(date Fecha, int horaInicio, int horaFin){
        date listaFechas = new listaFechas[0];
        for (int i = 0; i < listaFechas.length; i++ ){
            int[] listaHoras = {7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        }


    }

    public void agregarListaEspera(int Numerodesolocitud) {
        listaEspera.add(Numerodesolocitud);

    }
   




    





}
