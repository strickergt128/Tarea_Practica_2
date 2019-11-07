package Otras_Clases;

public class NodoDoble<T> {

    private T element;
    private NodoDoble<T> next;
    private NodoDoble<T> back;

    public NodoDoble(T element, NodoDoble<T> next, NodoDoble<T> back) {
        this.element = element;
        this.next = next;
        this.back = back;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodoDoble<T> getNext() {
        return next;
    }

    public void setNext(NodoDoble<T> next) {
        this.next = next;
    }

    public NodoDoble<T> getBack() {
        return back;
    }

    public void setBack(NodoDoble<T> back) {
        this.back = back;
    }

}
