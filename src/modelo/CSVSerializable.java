
package modelo;

import java.util.function.Function;


public interface CSVSerializable <T> {
    
    void guardarEnCSV(String rutaArchivo);
    //void cargarDesdeCSV(String rutaArchivo, Function<String, T> parser);
    
}
