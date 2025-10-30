import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private NoBST raiz;

    public BST() {
        raiz = null;
    }

    private NoBST inserir(NoBST r, Palavra p) {
        if (r == null) return new NoBST(p);
        if (p.getIngles().compareTo(r.palavra.getIngles()) < 0)
            r.esq = inserir(r.esq, p);
        else if (p.getIngles().compareTo(r.palavra.getIngles()) > 0)
            r.dir = inserir(r.dir, p);
        return r;
    }

    public void inserir(Palavra p) {
        raiz = inserir(raiz, p);
    }

    private NoBST buscar(NoBST r, String ingles) {
        if (r == null || r.palavra.getIngles().equals(ingles)) return r;
        if (ingles.compareTo(r.palavra.getIngles()) < 0)
            return buscar(r.esq, ingles);
        return buscar(r.dir, ingles);
    }

    public Palavra buscar(String ingles) {
        NoBST res = buscar(raiz, Palavra.toLower(ingles));
        return (res != null) ? res.palavra : null;
    }

    private NoBST minimo(NoBST no) {
        while (no != null && no.esq != null) no = no.esq;
        return no;
    }

    private NoBST remover(NoBST r, String ingles) {
        if (r == null) return r;
        int cmp = ingles.compareTo(r.palavra.getIngles());
        if (cmp < 0) r.esq = remover(r.esq, ingles);
        else if (cmp > 0) r.dir = remover(r.dir, ingles);
        else {
            if (r.esq == null) return r.dir;
            else if (r.dir == null) return r.esq;
            NoBST temp = minimo(r.dir);
            r.palavra = temp.palavra;
            r.dir = remover(r.dir, temp.palavra.getIngles());
        }
        return r;
    }

    public void remover(String ingles) {
        raiz = remover(raiz, Palavra.toLower(ingles));
    }

    private void emOrdem(NoBST r) {
        if (r != null) {
            emOrdem(r.esq);
            System.out.println(r.palavra.getIngles());
            emOrdem(r.dir);
        }
    }

    public void listarEmOrdem() {
        emOrdem(raiz);
    }

    public void listarEmLargura() {
        if (raiz == null) return;
        Queue<NoBST> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            NoBST atual = fila.poll();
            System.out.println(atual.palavra.getIngles());
            if (atual.esq != null) fila.add(atual.esq);
            if (atual.dir != null) fila.add(atual.dir);
        }
    }
}
