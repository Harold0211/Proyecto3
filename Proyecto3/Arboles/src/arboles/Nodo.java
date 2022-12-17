package arboles;

/**
 *
 * @author Ideapad
 */
public class Nodo {

    int dato;
    String nombre;
    Nodo Right, Left;

    public Nodo(int d, String nom) {
        this.dato = d;
        this.nombre = nom;
        this.Right = null;
        this.Left = null;
    }

    @Override
    public String toString() {
        return nombre + " Su dato es " + dato;
    }
}
