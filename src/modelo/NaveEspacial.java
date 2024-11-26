
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
    
    
     public String toCSV(){
        return id + "," + nombre + "," + categoria.toString() + "," + capacidad;
    }
    
    public static NaveEspacial fromCSV(String empleadoCSV){
        NaveEspacial toReturn = null;
        String[] values = empleadoCSV.split(",");
            if(values.length == 4){
                
                int id = Integer.parseInt(values[0]);
                String nombre = values[1];
                Categoria categoria = Categoria.valueOf(values[2]);
                int capacidad = Integer.parseInt(values[3]);

                toReturn = new NaveEspacial(id, nombre, capacidad, categoria);
            }
            return toReturn;
    }
}
