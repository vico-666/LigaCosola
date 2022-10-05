package PrograAvan.Grupos;

import java.util.Arrays;

public class Grupos03 {
    private int[] padres;
    private int[] tamanios;
    private int num_grupos;

    public Grupos03(int num_grupos) {
        this.num_grupos = num_grupos;
        padres = new int[num_grupos];
        tamanios = new int[num_grupos];
        for(int i=0; i < num_grupos; i++){
            padres[i] = i;
            tamanios[i] = 1;
        }
    }

    public int get_grupo(int p){
        while (p != padres[p]){
            p = padres[p];
        }
        return p;
    }

    public boolean conectados(int p, int q){
        return get_grupo(p) == get_grupo(q);
    }

    public void conectar(int p, int q){
        int pId = get_grupo(p);
        int qId = get_grupo(q);
        if (pId == qId){
            return;
        }

        if (tamanios[pId] < tamanios[qId]){
            padres[pId] = qId;
            tamanios[qId] += tamanios[pId];
        }
        else {
            padres[qId] = pId;
            tamanios[pId] += tamanios[qId];
        }
        num_grupos--;
    }

    @Override
    public String toString() {
        return "Grupos03{" +
                "padres=" + Arrays.toString(padres) +
                ", tamanios=" + Arrays.toString(tamanios) +
                ", num_grupos=" + num_grupos +
                '}';
    }
}

