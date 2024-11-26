
package modelo;


public class NaveEspacial implements Comparable<NaveEspacial> {
    
    private int id;
    private String nombre;
    private Categoria categoria;
    private int capacidad;

    public NaveEspacial(int id, String nombre,int capacidad, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre() {
        return nombre;
    }
    
        

    @Override
    public String toString() {
        return "NaveEspacial{" + "nombre=" + nombre + ", categoria=" + categoria + ", capacidad=" + capacidad + '}';
    }

    @Override
    public int compareTo(NaveEspacial o) {
       return Integer.compare(id, o.id);
    }
    
    
     
    
}
