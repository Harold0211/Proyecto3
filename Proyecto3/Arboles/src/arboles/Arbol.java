package arboles;

/**
 *
 * @author Ideapad
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void agregarNodo(int d, String nom) {
        Nodo nuevo = new Nodo(d, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo auxiliar = raiz;
            Nodo padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.Left;
                    if (auxiliar == null) {
                        padre.Left = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.Right;
                    if (auxiliar == null) {
                        padre.Right = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean Vacio() {
        return raiz == null;
    }

    public void InOrder(Nodo r) {
        if (r != null) {
            InOrder(r.Left);

            System.out.print(r.dato+ ", ");//Raiz
            InOrder(r.Right);
        }
    }

    public void PreOrder(Nodo r) {
        if (r != null) {
            System.out.print(r.dato+ ", ");
            PreOrder(r.Left);
            PreOrder(r.Right);
        }
    }

    public void PostOrder(Nodo r) {
        if (r != null) {
            System.out.print(r.dato+", ");
            PostOrder(r.Left);
            PostOrder(r.Right);
        }
    }

    //Metodo buscar 
    public Nodo buscarNodo(int d) {
        Nodo aux = raiz;
        while (aux.dato != d) {
            if (d < aux.dato) {
                aux = aux.Left;
            } else {
                aux = aux.Right;

            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    //Metod para eliminar un nodo
    public boolean eliminar(int d) {
        Nodo auxiliar = raiz;
        Nodo padre = raiz;
        boolean esHijoIzq = true;
        while (auxiliar.dato != d) {
            padre = auxiliar;
            if (d < auxiliar.dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.Left;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.Right;
            }
            if (auxiliar == null) {
                return false;
            }
        }//Fin del while
        if (auxiliar.Left == null && auxiliar.Right == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.Left = null;

            } else {
                padre.Right = null;
            }
        } else if (auxiliar.Left == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.Left;
            } else if (esHijoIzq) {
                padre.Left = auxiliar.Right;

            } else {
                padre.Right = auxiliar.Left;
            }
        } else if (auxiliar.Left == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.Right;
            } else if (esHijoIzq) {
                padre.Left = auxiliar.Right;

            } else {
                padre.Right = auxiliar.Left;
            }
        } else {
            Nodo reemplazo=obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.Left = reemplazo;
            } else {
                padre.Right = reemplazo;
            }
            reemplazo.Left=auxiliar.Left;
        }
        return true;
    }
//Metodo para devolver el nodo remplazo
    public Nodo obtenerNodoReemplazo(Nodo nodoReemp){
        Nodo reemplazarPadre=nodoReemp;
        Nodo reemplazo=nodoReemp;
        Nodo auxiliar=nodoReemp.Right;
        while(auxiliar!=null)
        {
            reemplazarPadre=reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.Left;
            
        }
        if(reemplazo!=nodoReemp.Right){
            reemplazarPadre.Left=reemplazo.Right;
            reemplazo.Right=nodoReemp.Right;
        }
        System.out.println("El Nodo Reemplazo es "+reemplazo);
    return reemplazo;
    }
}

