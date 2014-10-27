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
public class Documento{
    
    File doc;
    FileReader varDoc;
    BufferedReader lineaOrg;
    IntefazGrafo grafoNe = new MatrizGrafo();

    
    public void obtenerDoc(String dire) throws FileNotFoundException{
       doc=new File(dire); 
    }  

    public IntefazGrafo Nombres() throws IOException{

        varDoc = new FileReader (doc);
        lineaOrg = new BufferedReader(varDoc);
        String linea;
        while((linea=lineaOrg.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafoNe.agregar(tmp[0]);
            grafoNe.agregar(tmp[1]);
        }
        return grafoNe;
    }

    public IntefazGrafo Pesos() throws IOException{

        varDoc = new FileReader (doc);
        lineaOrg = new BufferedReader(varDoc);
        String linea;

        while((linea=lineaOrg.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafoNe.agregarVertice(tmp[0], tmp[1], tmp[2]);
        }
        return grafoNe;
    }
    

}

