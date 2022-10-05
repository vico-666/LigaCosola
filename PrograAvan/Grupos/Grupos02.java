package PrograAvan.Grupos;

import java.util.Arrays;

public class Grupos02 {
    private int[] padres;
    private int num_grupos;

    public Grupos02(int num_grupos) {
        this.num_grupos = num_grupos;
        padres = new int[num_grupos];
        for(int i=0; i < num_grupos; i++){
            padres[i] = i;
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
        padres[pId] = qId;
        num_grupos--;
    }

    @Override
    public String toString() {
        return "Grupos02{" +
                "padres=" + Arrays.toString(padres) +
                ", num_grupos=" + num_grupos +
                '}';
    }
}
