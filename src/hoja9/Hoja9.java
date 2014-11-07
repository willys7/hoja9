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
        
        AlgoDeFloyd GrafoCiu = new AlgoDeFloyd(); // Aqui creamos la matriz de adyacencia del grefo que leemos del archivo de texto
        GrafoCiu.masCorto(); // Le aplicamos el algoritmo de Floyd para encontrar el camino mas corto
        int op1=1; // El usiarios debe elegir una opcion
        int op2; // la pregunta de modificacion del grafo necesita una segunda eleccion
        Scanner scan = new Scanner(System.in); 


        while(op1!=3){       //Esta en un while esperando la opcion que el usuario elija hasta que sea 3 que es para salir 
            System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
            System.out.println("2. CAmbiar el grafo");
            System.out.println("3. Salir del programa");
            op1 = scan.nextInt();
            
            
            //Imprime la matriz de adyacendia del grafo respectivo
            System.out.println("\nMatriz de adyacencia");
            GrafoCiu.inter.desplegar();
            
            
            if(op1==1){
                GrafoCiu.masCorto(); // Aplicamos Floyd para el camino mas corto entre 2 nodos
                System.out.println("Nombre de la ciudad de inicial");
                String ciudad1 = scan.next(); 
                System.out.println("A donde desea llegar");
                String ciudad2 = scan.next();
                 if(GrafoCiu.inter.contains(ciudad1)&&GrafoCiu.inter.contains(ciudad2)){
                    System.out.println("\nLa distancia minima encontrada es: "+GrafoCiu.inter.getVertice(ciudad1, ciudad2)+".");
                    if(GrafoCiu.inter.getVertice(ciudad1, ciudad2)!=10000){
                        System.out.print("EL camino que debe seguir es: "+ciudad1);
                        GrafoCiu.CiudadesMedias(GrafoCiu.inter.getIndex(ciudad1), GrafoCiu.inter.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            
            // Si elije la opcion se procede apreguntar que cambio quiere y se realiza
            else if(op1==2){
                System.out.println("1. Se encuentran problemas en la carretera entre 2 ciudades");
                System.out.println("2. Nueva carretera entre ciudades");
                op2 = scan.nextInt();
 
                if(op2==1){
                    System.out.println("Nombre ciudad inicial");
                    String ciudad1 = scan.next();
                    System.out.println("A donde desea llegar");
                    String ciudad2 = scan.next();
                    if(GrafoCiu.inter.contains(ciudad1)&&GrafoCiu.inter.contains(ciudad2)){
                        GrafoCiu.inter.agregarVertice(ciudad1, ciudad2, 10000);
                    }
                }
               
                else if(op2==2){
                    System.out.println("nombre ciudad inicial");
                    String ciudad1 = scan.next();
                    System.out.println("A donde quiere llegar");
                    String ciudad2 = scan.next();
                    System.out.println("Cual es la nuevo distancia entre las ciudades");
                    int distancia = scan.nextInt();
                    // En el caso de que las ciudades ya existirean solo se remplaza el valor de la distancia
                    if(GrafoCiu.inter.contains(ciudad1)&&GrafoCiu.inter.contains(ciudad2)){
                        GrafoCiu.inter.agregarVertice(ciudad1, ciudad2, distancia);
                    }
                    // En el caso de que la ciudades aun no esten el grafo
                    // se deben meter a la matriz del grafo
                    else{
                        GrafoCiu.inter.agregar(ciudad1);
                        GrafoCiu.inter.agregar(ciudad2);
                        GrafoCiu.inter.agregarVertice(ciudad1, ciudad2, distancia);
                    }
                }
                // Luego de que se realizaron cualquiera de las modificaciones 
                // se lleva a cabo el proceso de volver a aplicar Floy para el camino mas corto
                GrafoCiu.masCorto();
            }

        }
        
    }
}
