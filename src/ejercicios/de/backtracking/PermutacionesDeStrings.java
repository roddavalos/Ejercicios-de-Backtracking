/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.de.backtracking;

/**
 *
 * @author rod_c
 */
public class PermutacionesDeStrings {
    public class PermutationsOfString {

    // Función principal para generar permutaciones de una cadena
    public static void permuta(String palabra){
        permuta("", palabra); // Llamada inicial a la función recursiva con una permutación vacía
    }
    
    // Función recursiva para generar permutaciones
    private static void permuta(String permutacion, String palabra){
        if(palabra.length() == 0)
            System.out.println(permutacion); // Si la palabra está vacía, se imprime la permutación actual
        else {
            for(int i = 0; i < palabra.length(); i++){
                // Agregar el carácter actual a la permutación y eliminarlo de la palabra
                permuta(permutacion + palabra.charAt(i), palabra.substring(0, i) + palabra.substring(i + 1));
            }
        }
    }
    
    public static void main(String[] args) {
        permuta("abc"); // Generar y mostrar permutaciones para la cadena "abc"
    }
}

}
