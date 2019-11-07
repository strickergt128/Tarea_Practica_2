package Otras_Clases;

public class ListaCircularDoble<T> {

    private NodoDoble<T> cabeza;
    private int size;

    public ListaCircularDoble() {
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
        NodoDoble<T> nuevo = new NodoDoble<>(element, null, null);
        if (isEmpty()) {
            nuevo.setNext(nuevo);
            nuevo.setBack(nuevo);
            cabeza = nuevo;
            size++;
        } else {
            NodoDoble<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            fin.setNext(nuevo);
            nuevo.setBack(fin);
            nuevo.setNext(cabeza);
            cabeza.setBack(nuevo);
            size++;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            NodoDoble<T> fin = cabeza;
            do {
                System.out.println(fin.getElement());
                fin = fin.getNext();
            } while (fin != cabeza);
        }
    }
    
    public static void main(String[] args) {
        ListaCircularDoble<Integer> lista = new ListaCircularDoble<>();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.show();
    }
}
