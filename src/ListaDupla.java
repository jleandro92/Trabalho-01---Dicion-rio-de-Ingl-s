import java.io.*;
import java.util.Random;

public class ListaDupla {
    private NoLista cabeca;
    private NoLista cauda;
    private Random random;

    public ListaDupla() {
        this.cabeca = null;
        this.cauda = null;
        this.random = new Random();
    }

    public void adicionar(Palavra p) {
        NoLista novo = new NoLista(p);
        if (cauda == null) {
            cabeca = cauda = novo;
        } else {
            cauda.prox = novo;
            novo.ant = cauda;
            cauda = novo;
        }
    }

    public boolean vazia() {
        return cabeca == null;
    }

    public int tamanho() {
        int cont = 0;
        NoLista atual = cabeca;
        while (atual != null) {
            cont++;
            atual = atual.prox;
        }
        return cont;
    }

    public Palavra removerPorIndice(int i) {
        int tam = tamanho();
        if (i < 0 || i >= tam) return new Palavra();

        NoLista no;
        if (i < tam / 2) {
            no = cabeca;
            for (int j = 0; j < i; j++) no = no.prox;
        } else {
            no = cauda;
            for (int j = tam - 1; j > i; j--) no = no.ant;
        }

        if (no.ant != null) no.ant.prox = no.prox;
        else cabeca = no.prox;
        if (no.prox != null) no.prox.ant = no.ant;
        else cauda = no.ant;

        return no.dado;
    }

    public Palavra removerAleatorio() {
        int tam = tamanho();
        if (tam == 0) return new Palavra();
        int i = random.nextInt(tam);
        return removerPorIndice(i);
    }

    public void carregarDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(";");
                if (partes.length != 3) continue;

                String ing = partes[0].trim();
                String pt = partes[1].trim();
                String cl = partes[2].trim();

                if (!ing.isEmpty() && !pt.isEmpty() && !cl.isEmpty()) {
                    adicionar(new Palavra(ing, pt, cl));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + nomeArquivo);
        }
    }
}
