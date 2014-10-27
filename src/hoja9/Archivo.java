/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja9;
import java.io.*;
/**
 *
 * @author William
 */
public class Archivo{
    
    File archivo;
    FileReader varArchivo;
    BufferedReader varline;
    IntefazGrafo grafo = new MatrizGrafo();

    
    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       archivo=new File(direccion); 
    }  

    public IntefazGrafo arregloNombres() throws IOException{

        varArchivo = new FileReader (archivo);
        varline = new BufferedReader(varArchivo);
        String linea;
        while((linea=varline.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.agregar(tmp[0]);
            grafo.agregar(tmp[1]);
        }
        return grafo;
    }

    public IntefazGrafo matrizCostos() throws IOException{

        varArchivo = new FileReader (archivo);
        varline = new BufferedReader(varArchivo);
        String linea;

        while((linea=varline.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.agregarVertice(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}

