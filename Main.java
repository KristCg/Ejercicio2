import java.util.Scanner;

public class Main{
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


    }
}