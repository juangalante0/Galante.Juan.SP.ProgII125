
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Inventario <T> implements CSVSerializable {
    
    private List<T> lista = new ArrayList<>();

    
    public void agregar(T item) {
        if(item != null){
            lista.add(item);
        }
    }
    
    public void listarElementos(){
        if(lista.isEmpty()){
            throw new RuntimeException("La lista esta vacia");
        }
        for(T elemento : lista){
            System.out.println(elemento);
        }
    }

    public void eleminar(int indice) {
        validarIndice(indice);
        lista.remove(indice);
    }
    
    private void validarIndice(int indice){
        if (indice < 0 || indice >= lista.size()){
        
            throw new IndexOutOfBoundsException("Incide invalido");
        }
    }
    
    public void ordenar() {
       
        lista.sort((Comparator<? super T>) Comparator.naturalOrder());
        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }
    
    public void ordenar(Comparator<? super T> comparator){
        lista.sort(comparator);
        for(T elemento : lista){
            System.out.println(elemento);
        }
    }
    
    public void paraCadaElemento(Consumer<? super T> accion) {
        for (T elemento : lista) {
        accion.accept(elemento); 
        }
    }
    
    public List<T> filtrar(Predicate<? super T> criterio) {
        List<T> toReturn = new ArrayList<>();
        for (T elemento : lista){
            if (criterio.test(elemento)){
                toReturn.add(elemento);
            }
        }
        return toReturn;
    }
    
    public List<T> transformar(Function<? super T, ? extends T> transformacion) {
        List<T> toReturn = new ArrayList<>();
        for (T elemento : lista){
            toReturn.add(transformacion.apply(elemento));
        }
        return toReturn;
    }
    
    public void guardarEnArchivo(String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(lista);
            System.out.println("Inventario guardado en archivo binario.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cargarDesdeArchivo(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            lista = (List<T>) ois.readObject();
            System.out.println("Inventario cargado desde archivo binario.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void guardarEnCSV(String rutaArchivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
        for (T elemento : lista) {
            if (elemento instanceof NaveEspacial) {
                NaveEspacial nave = (NaveEspacial) elemento;
                writer.write(nave.getNombre() + "," + nave.getCategoria());
                writer.newLine();
            }
        }
        System.out.println("Inventario guardado en archivo CSV.");
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
    
 
}
     

