package promedioNotas;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class promedioNotasHashMap {
	public static void main(String[] args) {
		HashMap<String, ArrayList<Double>> estudiantesLista = new HashMap<String, ArrayList<Double>>();
		ArrayList<Double> notasEstudiante;
        
        int estudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));

        for (int i = 0; i < estudiantes; i++) {

            String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
            

            notasEstudiante = new ArrayList<>();
            
            for (int j = 0; j < 3; j++) {
                Double nota;
                
                do {

                    nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1)));
                    if (nota < 0 || nota > 5) {
                        System.out.println("Nota inválida. Debe estar entre 0 y 5.");
                    }
                    

                    notasEstudiante.add(nota);
                } while (nota < 0 || nota > 5);
                
                
            }
            

            estudiantesLista.put(nombreEstudiante, notasEstudiante);
        }

        System.out.println("Se ingreso un total de "+estudiantes+" estudiantes");
        System.out.println("Cantidad de notas ingresadas por estudiante: 3");
        
        
        Double sumaPromedios = 0.0;
        int gana = 0;
        int pierde = 0;
        
        
        for (String nombre : estudiantesLista.keySet()) {
        	
        	ArrayList<Double> notas = estudiantesLista.get(nombre);
        	
            double sumaNotas = 0;
            
            for (double nota : notas) {
                sumaNotas += nota;
            }
            
 
            double promedio = sumaNotas / notas.size();
            
            
            sumaPromedios += promedio;
            
            

            if (promedio >= 3.5) {
                System.out.println("Estudiante: " + nombre + " - Promedio: " + promedio + " - Gana");
                gana++;
            } else if(promedio < 3.5 && promedio > 2){
                System.out.println("Estudiante: " + nombre + " - Promedio: " + promedio + " - Pierde pero puede recuperar");
                pierde++;
            } else if(promedio <= 2) {
            	System.out.println("Estudiante: " + nombre + " - Promedio: " + promedio + " - Pierde y no puede recuperar");
            	pierde++;
            } 
            

    }	Double promedioTotal = sumaPromedios / estudiantes;
        System.out.println("Promedio total es = "+promedioTotal);
        System.out.println("Ganaron en total = "+ gana);
        System.out.println("Pierden en total = "+ pierde);
        
        
    }
}
