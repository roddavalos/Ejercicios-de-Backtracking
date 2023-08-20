/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.de.backtracking;

import java.util.ArrayList;

/**
 *
 * @author rod_c
 */
public class CombinacionesSumas {

    // Función principal para generar combinaciones de sumas
    public static void combinacionesSumas(int num){
        ArrayList<Integer> numeros = new ArrayList(); // Lista para almacenar los números en una combinación
        combinacionesSumas(num, numeros, 0); // Llamada a la función recursiva con los valores iniciales
    }
    
    // Función recursiva para generar las combinaciones de sumas
    private static void combinacionesSumas(int num, ArrayList<Integer> numeros, int suma){
        if(suma == num)
            System.out.println(numeros); // Si la suma es igual al número objetivo, se imprime la combinación
        else {
            for(int i = 1; i <= num; i++){
                suma = suma + i; // Agregar el número actual a la suma temporal
                if(suma <= num){ // Si la suma temporal es menor o igual al número objetivo
                    numeros.add(i); // Agregar el número actual a la lista de números en la combinación
                    combinacionesSumas(num, numeros, suma); // Llamada recursiva con la suma y la lista actualizadas
                    numeros.remove(numeros.indexOf(i)); // Eliminar el número actual para probar otras combinaciones
                }
                suma = suma - i; // Restablecer la suma temporal al valor anterior
            }
        }
    }
    
    public static void main(String[] args) {
        combinacionesSumas(3); // Generar y mostrar combinaciones de sumas para el número 3
    }
}

 
    
    
   

