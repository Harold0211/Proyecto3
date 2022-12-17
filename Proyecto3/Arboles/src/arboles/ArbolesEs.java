package arboles;

import javax.swing.JOptionPane;

public class ArbolesEs {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        Arbol tree = new Arbol();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                           1. Agregar un nodo
                                                                           2.InOrder
                                                                           3.PreOrder
                                                                           4.PostOrder
                                                                           5. Busacar Nodo
                                                                           6.Eliminar un nodo
                                                                           7.Salir
                                                                           Elige una Opcion....""",
                        "Arboles Binarios",
                        JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo...", "Agregando nodo",
                                JOptionPane.QUESTION_MESSAGE));

                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del nodo...", "Agregando nodo",
                                JOptionPane.QUESTION_MESSAGE);

                        tree.agregarNodo(elemento, nombre);
                    break;

                    case 2:
                        if (!tree.Vacio()) {
                            System.out.println();
                            tree.InOrder(tree.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio",
                                    "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;

                    case 3:
                        if (!tree.Vacio()) {
                            System.out.println();
                            tree.PreOrder(tree.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio",
                                    "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 4:
                        if (!tree.Vacio()) {
                            System.out.println();
                            tree.PostOrder(tree.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio",
                                    "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 5:
                        if (!tree.Vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el numero del nodo que quiere buscar...", "Buscando nodo",
                                    JOptionPane.QUESTION_MESSAGE));
                            if (tree.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado",
                                        "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println("Los datos del Nodo buscado es: " + tree.buscarNodo(elemento));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio",
                                    "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                        }
                   break;

                    case 6 :
                        if (!tree.Vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el numero a Eliminar...", "Eliminando Nodo",
                                    JOptionPane.QUESTION_MESSAGE));
                            if (tree.eliminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado",
                                        "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El Nodo fue Eliminado",
                                        "¡El nodo ha sido Eliminado!", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio",
                                    "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;

                    case 7 :
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default :
                        JOptionPane.showMessageDialog(null, "Opción Incorrecta",
                                "¡Cuidado!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }

        } while (opcion != 7);
    }

}
