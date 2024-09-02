package promedioNotas;

import java.util.ArrayList;


import javax.swing.JOptionPane;

public class Ejercicio {

    public static void main(String[] args) {
        ArrayList<String> estudiantesLista = new ArrayList<>();
        ArrayList<ArrayList<Double>> notasLista = new ArrayList<>();
        
        int estudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));

        for (int i = 0; i < estudiantes; i++) {

            String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
            estudiantesLista.add(nombreEstudiante);
            

            ArrayList<Double> notasEstudiante = new ArrayList<>();
            
            for (int j = 0; j < 3; j++) {
                Double nota;
                
                do {

                    nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1)));
                    if (nota < 0 || nota > 5) {
                        System.out.println("Nota inválida. Debe estar entre 0 y 5.");
                    }
                } while (nota < 0 || nota > 5);
                notasEstudiante.add(nota);
            }
            

            notasLista.add(notasEstudiante);
        }

        System.out.println("Se ingreso un total de "+estudiantes+" estudiantes");
        System.out.println("Cantidad de notas ingresadas: 3");
        
        
        Double sumaPromedios = 0.0;
        int gana = 0;
        int pierde = 0;
        
        for (int b = 0; b < estudiantesLista.size(); b++) {
        	
            ArrayList<Double> notas = notasLista.get(b);
            
            double sumaNotas = 0;
            
            for (double nota : notas) {
                sumaNotas += nota;
            }
            

            double promedio = sumaNotas / notas.size();
            
            
            sumaPromedios += promedio;
            
            
            

            if (promedio >= 3.5) {
                System.out.println("Estudiante: " + estudiantesLista.get(b) + " - Promedio: " + promedio + " - Gana");
                System.out.println();
                gana++;
            } else if(promedio < 3.5 && promedio > 2){
                System.out.println("Estudiante: " + estudiantesLista.get(b) + " - Promedio: " + promedio + " - Pierde pero puede recuperar");
                System.out.println();
                pierde++;
            } else if(promedio <= 2) {
            	System.out.println("Estudiante: " + estudiantesLista.get(b) + " - Promedio: " + promedio + " - Pierde y no puede recuperar");
            	System.out.println();
            	pierde++;
            } 
            

    }	Double promedioTotal = sumaPromedios / estudiantes;
        System.out.println("Promedio total es = "+promedioTotal);
        System.out.println();
        System.out.println("Ganaron en total = "+ gana);
        System.out.println();
        System.out.println("Pierden en total = "+ pierde);
        
        
    }
}
