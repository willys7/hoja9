/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja9;

/**
 *
 * @author William
 */
 
public interface IntefazGrafo<V,E> {

    public void agregar(V label);

    public void agregarVertice(V vtx1, V vtx2, E label);

    public void desplegar();
 
    public int getIndex(V label);

    public V get(int label);

    public int getVertice(V label1, V label2);

    public boolean contains(V label);

    public int size();
    
}
