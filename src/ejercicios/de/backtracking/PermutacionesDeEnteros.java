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
public class PermutacionesDeEnteros {

    // Función para generar todas las permutaciones posibles de un arreglo de enteros
    public static ArrayList<ArrayList<Integer>> permutar(int[] nums){
        ArrayList<ArrayList<Integer>> resultado = new ArrayList(); // Lista para almacenar las permutaciones
        backtrack(resultado, new ArrayList<>(), nums); // Iniciar el proceso de generación de permutaciones
        return resultado; // Devolver la lista de permutaciones generadas
    }
    
    // Función de backtracking para generar permutaciones
    public static void backtrack(ArrayList<ArrayList<Integer>> resultado, ArrayList<Integer> temporal, int[] nums){
        if(temporal.size() == nums.length){
            resultado.add(temporal); // Si la lista temporal tiene la misma longitud que nums, se agrega a resultado
            return;
        } else {
            for(int i = 0; i < nums.length; i++){
                if(temporal.contains(nums[i]))
                    continue; // Si el número ya está en la lista temporal, se salta a la siguiente iteración
                temporal.add(nums[i]); // Agregar el número actual a la lista temporal
                backtrack(resultado, new ArrayList<>(temporal), nums); // Llamada recursiva con la lista temporal actualizada
                temporal.remove(temporal.size() - 1); // Eliminar el último número agregado para probar otros números
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        ArrayList<ArrayList<Integer>> b = permutar(a); // Generar permutaciones para el arreglo a
        System.out.println(b); // Imprimir las permutaciones generadas
        
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayList<ArrayList<Integer>> d = permutar(c); // Generar permutaciones para el arreglo c
        System.out.println(d); // Imprimir las permutaciones generadas
    }
}
