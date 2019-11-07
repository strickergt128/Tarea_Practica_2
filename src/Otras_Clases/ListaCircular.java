package Otras_Clases;

public class ListaCircular<T> {

    private Nodo<T> cabeza;
    private int size;

    public ListaCircular() {
        cabeza = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T element) {
        Nodo<T> nuevo = new Nodo<>(element, null);
        if (isEmpty()) {
            nuevo.setNext(nuevo);
            cabeza = nuevo;
            size++;
        } else {
            Nodo<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            fin.setNext(nuevo);
            nuevo.setNext(cabeza);
            size++;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            Nodo<T> fin = cabeza;
            do {
                System.out.println(fin.getElement());
                fin = fin.getNext();
            } while (fin != cabeza);
        }
    }
    
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();
        lista.add(2);
        lista.add(1);
        lista.add(0);
        lista.show();
    }
}
