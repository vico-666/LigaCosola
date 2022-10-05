package PrograAvan.Grupos;

import java.util.Arrays;

public class Grupos01 {
    private int[] ids;
    private int num_grupos;

    public Grupos01(int nodos) {
        this.num_grupos = nodos;
        ids = new int[nodos];
        for (int i=0; i < nodos; i++){
            ids[i] = i;
        }
    }

    public int get_grupo(int p){
        return ids[p];
    }

    public boolean conectados(int p, int q){
        return get_grupo(p) == get_grupo(q);
    }

    public void conectar(int p, int q){
        if (conectados(p, q)){
            return;
        }
        int idP = get_grupo(p);
        for (int i=0; i < ids.length; i++){
            if (ids[i] == idP){
                ids[i] = get_grupo(q);
            }
        }
        num_grupos--;
    }

    public int getNum_grupos() {
        return num_grupos;
    }

    @Override
    public String toString() {
        return "Grupos01{" +
                "ids=" + Arrays.toString(ids) +
                ", num_grupos=" + num_grupos +
                '}';
    }
}
