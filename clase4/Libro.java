public class Libro {
   /* 
    // Atributos
    private String titulo;
    private String autor;
    private double precio;

    // Constructor
    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    // Getter para precio
    public double getPrecio() {
        return precio;
    }

    // Método toString para mostrar información del libro
    public String toString() {
        return "Libro: [ Título: " + titulo + " | Autor: " + autor + " | Precio: $" + precio + " ]";
       
        */

    
    
    private String titulo;
    private String autor;
    private double precio;

    
    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    
    public double getPrecio() {
        return precio;
    }

    
    public String toString() {
        return "Libro: [Título: " + titulo + " | Autor: " + autor + " | Precio: $" + precio + "]";
    }
}

    
