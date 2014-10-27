/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja9;

import java.util.Scanner;

/**
 *
 * @author William
 */
public class Hoja9 {

    public static void main(String[] args){
        
        GrafoFloyd matriz = new GrafoFloyd(); // Matriz de adyacencia
        matriz.caminoCorto(); // Algoritmo de Floyd para encontrar el camino mas corto entre todos los nodos
        int op1=1; // Seleccion del usuario para realizar
        int op2; // Seleccion del usuario para la pregunta 3
        Scanner scan = new Scanner(System.in); //Entrada por teclado

        // Realizar ciclo mientras la respuesta del usuario no sea 4
        while(op1!=4){       
            System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
            System.out.println("2. Nombre de la ciudad en el centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Finalizar programa");
            op1 = scan.nextInt();
            // Desplegar la matriz
            System.out.println("\nMatriz de adyacencia");
            matriz.inter.mostrar();
            
            // Si la respuesta es 1, preguntar por las ciudades y desplegar resultados
            if(op1==1){
                matriz.caminoCorto(); // Camino mas corto entre todas las ciudades
                System.out.println("Ingrese el nombre de la ciudad de salida");
                String ciudad1 = scan.next(); 
                System.out.println("Ingrese el nombre de la ciudad de destino");
                String ciudad2 = scan.next();
                // Si las ciudades se encuentran en la matriz, entonces desplegar la distancia minima y la ruta completa
                if(matriz.inter.contains(ciudad1)&&matriz.inter.contains(ciudad2)){
                    System.out.println("\nLa distancia minima es: "+matriz.inter.getVertice(ciudad1, ciudad2)+".");
                    if(matriz.inter.getVertice(ciudad1, ciudad2)!=10000){
                        System.out.print("La ruta es: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.inter.getIndex(ciudad1), matriz.inter.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            // Si la respuesta es 2, desplegar el centro de grafo
            else if(op1==2){
                matriz.centroGrafo();
            }
            
            // Si la respuesta es 3, preguntar cual es el cambio a realizar y ejecutarlo
            else if(op1==3){
                System.out.println("1. Hay interrupcion de trafico entre un par de ciudades");
                System.out.println("2. Establecer nueva conexion");
                op2 = scan.nextInt();
                // Si la respuesta es 1, preguntar por el nombre de las ciudades y colocar un numero muy grande
                // en la matriz de adyacencia para indicar que no hay conexion
                if(op2==1){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    if(matriz.inter.contains(ciudad1)&&matriz.inter.contains(ciudad2)){
                        matriz.inter.agregarVertice(ciudad1, ciudad2, 10000);
                    }
                }
                // Si la respuesta es 2, preguntar por el nombre de las ciudades y agregar nueva distancia.
                else if(op2==2){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    int distancia = scan.nextInt();
                    // Si las ciudades ya existen, cambiar el valor
                    if(matriz.inter.contains(ciudad1)&&matriz.inter.contains(ciudad2)){
                        matriz.inter.agregarVertice(ciudad1, ciudad2, distancia);
                    }
                    // Si las ciudades no existen, agregarlas a la matriz
                    else{
                        matriz.inter.agregar(ciudad1);
                        matriz.inter.agregar(ciudad2);
                        matriz.inter.agregarVertice(ciudad1, ciudad2, distancia);
                    }
                }
                // Recalcular las rutas mas cortas
                matriz.caminoCorto();
            }

        }
        
    }
}
