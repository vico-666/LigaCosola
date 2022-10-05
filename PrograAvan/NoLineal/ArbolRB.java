package PrograAvan;

import PrograAvan.Lineal.Cola;

import java.util.NoSuchElementException;

public class ArbolRB<Llave extends Comparable<Llave>, Valor> {

    private static final boolean ROJO = true;
    private static final boolean NEGRO = false;

    private Nodo raiz;

    private class Nodo {
        private Llave llave;
        private Valor valor;
        private Nodo izquierdo, derecho;
        private boolean color;
        private int tam;          // subtree count

        public Nodo(Llave llave, Valor val, boolean color, int tam) {
            this.llave = llave;
            this.valor = val;
            this.color = color;
            this.tam = tam;
        }
    }

    public ArbolRB() {
    }


    private boolean esRojo(Nodo x) {
        if (x == null) return false;
        return x.color == ROJO;
    }

    private int get_tam(Nodo x) {
        if (x == null) return 0;
        return x.tam;
    }

    public int get_tam() {
        return get_tam(raiz);
    }

    public boolean es_vacio() {
        return raiz == null;
    }


    /*********************** rutinas arbol ***********/
    public Valor getValorByLlave(Llave llave) {
        return getValorByLlave(raiz, llave);
    }

    private Valor getValorByLlave(Nodo x, Llave llave) {
        while (x != null) {
            int cmp = llave.compareTo(x.llave);
            if (cmp < 0) x = x.izquierdo;
            else if (cmp > 0) x = x.derecho;
            else return x.valor;
        }
        return null;
    }

    /***************************/
    public boolean contiene(Llave llave) {
        return getValorByLlave(llave) != null;
    }

    /***************** INSERTAR ***************************************/
    public void insertar(Llave llave, Valor val) {
        if (llave == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(llave);
            return;
        }

        raiz = insertar(raiz, llave, val);
        raiz.color = NEGRO;
    }

    private Nodo insertar(Nodo h, Llave llave, Valor val) {
        if (h == null) return new Nodo(llave, val, ROJO, 1);

        int cmp = llave.compareTo(h.llave);
        if (cmp < 0) h.izquierdo = insertar(h.izquierdo, llave, val);
        else if (cmp > 0) h.derecho = insertar(h.derecho, llave, val);
        else h.valor = val;

        if (esRojo(h.derecho) && !esRojo(h.izquierdo)) h = rotarIzquierda(h);
        if (esRojo(h.izquierdo) && esRojo(h.izquierdo.izquierdo)) h = rotarDerecha(h);
        if (esRojo(h.izquierdo) && esRojo(h.derecho)) intercambiar_color(h);
        h.tam = get_tam(h.izquierdo) + get_tam(h.derecho) + 1;

        return h;
    }

    /************************* ELIMINAR MIN*******************************/
    public void deleteMin() {
        if (!esRojo(raiz.izquierdo) && !esRojo(raiz.derecho))
            raiz.color = ROJO;

        raiz = deleteMin(raiz);
        if (!es_vacio()) raiz.color = NEGRO;
    }

    private Nodo deleteMin(Nodo h) {
        if (h.izquierdo == null)
            return null;

        if (!esRojo(h.izquierdo) && !esRojo(h.izquierdo.izquierdo))
            h = rojo_a_izquierda(h);

        h.izquierdo = deleteMin(h.izquierdo);
        return balancear(h);
    }


    /********** ELIMIAR MAX ****************************************/
    public void deleteMax() {
        if (!esRojo(raiz.izquierdo) && !esRojo(raiz.derecho))
            raiz.color = ROJO;

        raiz = deleteMax(raiz);
        if (!es_vacio()) raiz.color = NEGRO;
    }

    private Nodo deleteMax(Nodo h) {
        if (esRojo(h.izquierdo))
            h = rotarDerecha(h);

        if (h.derecho == null)
            return null;

        if (!esRojo(h.derecho) && !esRojo(h.derecho.izquierdo))
            h = rojo_a_derecha(h);

        h.derecho = deleteMax(h.derecho);

        return balancear(h);
    }

    /**
     * ****** ELIMINAR
     ********************************************/
    public void delete(Llave llave) {
        if (!contiene(llave)) return;
        if (!esRojo(raiz.izquierdo) && !esRojo(raiz.derecho))
            raiz.color = ROJO;

        raiz = delete(raiz, llave);
        if (!es_vacio()) raiz.color = NEGRO;
    }

    private Nodo delete(Nodo h, Llave llave) {
        if (llave.compareTo(h.llave) < 0) {
            if (!esRojo(h.izquierdo) && !esRojo(h.izquierdo.izquierdo))
                h = rojo_a_izquierda(h);
            h.izquierdo = delete(h.izquierdo, llave);
        } else {
            if (esRojo(h.izquierdo))
                h = rotarDerecha(h);
            if (llave.compareTo(h.llave) == 0 && (h.derecho == null))
                return null;
            if (!esRojo(h.derecho) && !esRojo(h.derecho.izquierdo))
                h = rojo_a_derecha(h);
            if (llave.compareTo(h.llave) == 0) {
                Nodo x = get_min(h.derecho);
                h.llave = x.llave;
                h.valor = x.valor;
                h.derecho = deleteMin(h.derecho);
            } else h.derecho = delete(h.derecho, llave);
        }
        return balancear(h);
    }

    /*********************** rotaciones *****************************************************/

    private Nodo rotarDerecha(Nodo h) {
        // assert (h != null) && isRed(h.left);
        Nodo x = h.izquierdo;
        h.izquierdo = x.derecho;
        x.derecho = h;
        x.color = x.derecho.color;
        x.derecho.color = ROJO;
        x.tam = h.tam;
        h.tam = get_tam(h.izquierdo) + get_tam(h.derecho) + 1;
        return x;
    }

    private Nodo rotarIzquierda(Nodo h) {
        // assert (h != null) && isRed(h.right);
        Nodo x = h.derecho;
        h.derecho = x.izquierdo;
        x.izquierdo = h;
        x.color = x.izquierdo.color;
        x.izquierdo.color = ROJO;
        x.tam = h.tam;
        h.tam = get_tam(h.izquierdo) + get_tam(h.derecho) + 1;
        return x;
    }

    private void intercambiar_color(Nodo h) {
        h.color = !h.color;
        h.izquierdo.color = !h.izquierdo.color;
        h.derecho.color = !h.derecho.color;
    }

    private Nodo rojo_a_izquierda(Nodo h) {
        intercambiar_color(h);
        if (esRojo(h.derecho.izquierdo)) {
            h.derecho = rotarDerecha(h.derecho);
            h = rotarIzquierda(h);
            intercambiar_color(h);
        }
        return h;
    }
    private Nodo rojo_a_derecha(Nodo h) {
        intercambiar_color(h);
        if (esRojo(h.izquierdo.izquierdo)) {
            h = rotarDerecha(h);
            intercambiar_color(h);
        }
        return h;
    }
    private Nodo balancear(Nodo h) {
        if (esRojo(h.derecho)) h = rotarIzquierda(h);
        if (esRojo(h.izquierdo) && esRojo(h.izquierdo.izquierdo)) h = rotarDerecha(h);
        if (esRojo(h.izquierdo) && esRojo(h.derecho)) intercambiar_color(h);

        h.tam = get_tam(h.izquierdo) + get_tam(h.derecho) + 1;
        return h;
    }

    public int get_altura() {
        return get_altura(raiz);
    }

    private int get_altura(Nodo x) {
        if (x == null) return -1;
        return 1 + Math.max(get_altura(x.izquierdo), get_altura(x.derecho));
    }

    public Llave get_min() {
        if (es_vacio()) throw new NoSuchElementException("calls min() with empty symbol table");
        return get_min(raiz).llave;
    }

    private Nodo get_min(Nodo x) {
        if (x.izquierdo == null) return x;
        else return get_min(x.izquierdo);
    }


    public Llave get_max() {
        if (es_vacio()) throw new NoSuchElementException("calls max() with empty symbol table");
        return get_max(raiz).llave;
    }
    private Nodo get_max(Nodo x) {
        if (x.derecho == null) return x;
        else return get_max(x.derecho);
    }

    public Llave floor(Llave llave) {
        if (llave == null) throw new IllegalArgumentException("argument to floor() is null");
        if (es_vacio()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Nodo x = floor(raiz, llave);
        if (x == null) return null;
        else return x.llave;
    }

    private Nodo floor(Nodo x, Llave llave) {
        if (x == null) return null;
        int cmp = llave.compareTo(x.llave);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.izquierdo, llave);
        Nodo t = floor(x.derecho, llave);
        if (t != null) return t;
        else return x;
    }


    public Llave ceiling(Llave llave) {
        if (llave == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (es_vacio()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Nodo x = ceiling(raiz, llave);
        if (x == null) return null;
        else return x.llave;
    }

    // the smallest key in the subtree rooted at x greater than or equal to the given key
    private Nodo ceiling(Nodo x, Llave llave) {
        if (x == null) return null;
        int cmp = llave.compareTo(x.llave);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.derecho, llave);
        Nodo t = ceiling(x.izquierdo, llave);
        if (t != null) return t;
        else return x;
    }


    public Llave select(int k) {
        if (k < 0 || k >= get_tam()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        Nodo x = select(raiz, k);
        return x.llave;
    }

    // the key of rank k in the subtree rooted at x
    private Nodo select(Nodo x, int k) {
        // assert x != null;
        // assert k >= 0 && k < size(x);
        int t = get_tam(x.izquierdo);
        if (t > k) return select(x.izquierdo, k);
        else if (t < k) return select(x.derecho, k - t - 1);
        else return x;
    }


    public int rank(Llave llave) {
        if (llave == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(llave, raiz);
    }

    // number of keys less than key in the subtree rooted at x
    private int rank(Llave llave, Nodo x) {
        if (x == null) return 0;
        int cmp = llave.compareTo(x.llave);
        if (cmp < 0) return rank(llave, x.izquierdo);
        else if (cmp > 0) return 1 + get_tam(x.izquierdo) + rank(llave, x.derecho);
        else return get_tam(x.izquierdo);
    }


    public Iterable<Llave> keys() {
        if (es_vacio()) return new Cola<Llave>();
        return keys(get_min(), get_max());
    }


    public Iterable<Llave> keys(Llave lo, Llave hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Cola<Llave> queue = new Cola<>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(raiz, queue, lo, hi);
        return queue;
    }

    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(Nodo x, Cola<Llave> queue, Llave lo, Llave hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.llave);
        int cmphi = hi.compareTo(x.llave);
        if (cmplo < 0) keys(x.izquierdo, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.encolar(x.llave);
        if (cmphi > 0) keys(x.derecho, queue, lo, hi);
    }


    public int get_tam(Llave lo, Llave hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contiene(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }
}

