/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.de.backtracking;

/**
 *
 * @author rod_c
 */
public class BusquedaDePalabrasEnMatriz {
    boolean[][] visitados; // Matriz de booleanos para marcar celdas visitadas

    public boolean encontrar(char[][] matriz, String palabra) {
        int i, j;
        i = 0;
        visitados = new boolean[matriz.length][matriz[0].length]; 
        boolean resp = false;

        // Bucle para recorrer todas las celdas de la matriz
        while (i < matriz.length && resp == false) {
            j = 0;
            while (j < matriz[0].length && resp == false) {
                // Si la letra en la celda actual coincide con la primera letra de la palabra
                if (matriz[i][j] == palabra.charAt(0) && busqueda(matriz, palabra, i, j, 0))
                    resp = true; // Encontró la palabra, marca la respuesta como verdadera
                j++;
            }
            i++;
        }
        return resp; // Devuelve si la palabra se encontró en la matriz
    }

    public boolean busqueda(char[][] matriz, String palabra, int i, int j, int index) {
        if (index == palabra.length())
            return true; // Se llegó al final de la palabra, por lo tanto se encontró

        if (i < 0 || i >= matriz.length || j < 0 || j >= matriz[0].length ||
            palabra.charAt(index) != matriz[i][j] || visitados[i][j])
            return false; // Condiciones de límites o letra incorrecta, o celda ya visitada

        visitados[i][j] = true; // Marca la celda actual como visitada

        // Realiza la búsqueda recursiva en las cuatro direcciones posibles
        if (busqueda(matriz, palabra, i + 1, j, index + 1) ||
            busqueda(matriz, palabra, i - 1, j, index + 1) ||
            busqueda(matriz, palabra, i, j + 1, index + 1) ||
            busqueda(matriz, palabra, i, j - 1, index + 1))
            return true; // Si alguna dirección encuentra la palabra, devuelve verdadero

        visitados[i][j] = false; // Si no se encontró la palabra, desmarca la celda
        return false;
    }

    public static void main(String[] args) {
        char[][] matriz = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String palabra1 = "ABCE";
        String palabra2 = "ASA";
        String palabra3 = "FCE";
        String palabra4 = "ABA";
        BusquedaDePalabrasEnMatriz pruebas = new BusquedaDePalabrasEnMatriz();

        // Realiza las pruebas de búsqueda con las palabras dadas
        System.out.println(pruebas.encontrar(matriz, palabra1));
        System.out.println(pruebas.encontrar(matriz, palabra2));
        System.out.println(pruebas.encontrar(matriz, palabra3));
        System.out.println(pruebas.encontrar(matriz, palabra4));
    }
}

