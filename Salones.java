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
        this.ListaEspera = new [];

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



    public void agregarListaEspera(int Numerodesolocitud) {
        listaEspera.add(Numerodesolocitud);

    }
   




    





}
