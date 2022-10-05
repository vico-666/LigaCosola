package PrograAvan.Lineal;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T>, Serializable {
    private Nodo<T> cabeza;
    private int tam;

    public Lista() {
        cabeza = null;
        tam = 0;
    }

    public boolean esta_vacia(){
        return tam == 0;
    }

    public int getTam() {
        return tam;
    }
    public void insertar(T item){
        cabeza = insertar(cabeza, item);
    }
    private Nodo insertar(Nodo x, T item){
        if (x == null){
            x = new Nodo();
            x.item = item;
            x.enlace = null;
            tam++;
            return x;
        }
        x.enlace = insertar(x.enlace, item);
        return x;
    }

    public T get(int indice){
        if (indice>= tam){
            throw new IllegalArgumentException("Indice "+indice+ " fuera de rango : "+ tam);
        }
        for (int i=0; i <indice;i++){
            cabeza = cabeza.enlace;
        }
        return cabeza.item;
    }

    public T desempilar(){
        return desempilar(cabeza);
    }
    public T desempilar(Nodo<T> x){

        if (x.enlace == null){
            T dato = x.item;
            x = null;
            return dato;
        }
        else{
            return(desempilar(x.enlace));
        }

    }
    public T desencolar(){
        if (esta_vacia()) throw new NoSuchElementException("Lista vacia");
        T s = cabeza.item;
        cabeza = cabeza.enlace;
        tam--;
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(cabeza);
    }
    private class ListIterator implements Iterator<T>{
        private Nodo<T> actual;

        public ListIterator(Nodo<T> pri){
            actual = pri;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T dato = actual.item;
            actual = actual.enlace;
            return dato;
        }

    }
}