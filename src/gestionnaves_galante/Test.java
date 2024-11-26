
package gestionnaves_galante;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import modelo.Categoria;
import modelo.Inventario;
import modelo.NaveEspacial;


public class Test {

    public static void main(String[] args) {
        
        // Crear un inventario de naves espaciales
        Inventario<NaveEspacial> inventarioNaves = new Inventario<>();
        inventarioNaves.agregar(new NaveEspacial(1, "USS Enterprise", 50,
                Categoria.CIENTIFICA));
        inventarioNaves.agregar(new NaveEspacial(2, "Millennium Falcon", 3,
                Categoria.TRANSPORTE));
        inventarioNaves.agregar(new NaveEspacial(3, "TIE Fighter", 1,
                Categoria.MILITAR));
        inventarioNaves.agregar(new NaveEspacial(4, "X-Wing", 2,
                Categoria.MILITAR));
        inventarioNaves.agregar(new NaveEspacial(5, "Discovery One", 100,
                Categoria.CIENTIFICA));
        // Mostrar todas las naves en el inventario
        System.out.println("Inventario de naves espaciales:");
        inventarioNaves.paraCadaElemento(nave -> System.out.println(nave));
        // Filtrar naves por categoría MILITAR
        System.out.println("\nNaves de la categoría MILITAR:");
        inventarioNaves.filtrar(nave -> nave.getCategoria() == Categoria.MILITAR)
                .forEach(nave -> System.out.println(nave));
        System.out.println("\nNaves cuyo nombre contiene 'Falcon':");
        inventarioNaves.filtrar(nave -> nave.getNombre().contains("Falcon"))
                .forEach(nave -> System.out.println(nave));
        // Ordenar naves de manera natural (por id)
        System.out.println("\nNaves ordenadas de manera natural (por id):");
        inventarioNaves.ordenar();
        //inventarioNaves.paraCadaElemento(nave -> System.out.println(nave));
        // Ordenar naves por nombre utilizando un Comparator
        System.out.println("\nNaves ordenadas por nombre:");
        inventarioNaves.ordenar(Comparator.comparing(NaveEspacial::getNombre));
        //inventarioNaves.paraCadaElemento(nave -> System.out.println(nave));
        // Guardar el inventario en un archivo binario
        inventarioNaves.guardarEnArchivo("src/data/naves.dat");
        // Cargar el inventario desde el archivo binario
        Inventario<NaveEspacial> inventarioCargado = new Inventario<>();
        inventarioCargado.cargarDesdeArchivo("src/data/naves.dat");
        System.out.println("\nNaves cargadas desde archivo binario:");
        inventarioCargado.paraCadaElemento(nave -> System.out.println(nave));
        // Guardar el inventario en un archivo CSV
        inventarioNaves.guardarEnCSV("src/data/naves.csv");
        
        // Cargar el inventario desde el archivo CSV
        
        //inventarioCargado.cargarDesdeCSV("src/data/naves.csv", /* Acá va una
        //expresion lambda*/);
        //System.out.println("\nNaves cargadas desde archivo CSV:");
        //inventarioCargado.paraCadaElemento(nave -> System.out.println(nave));
        }
    }
    
