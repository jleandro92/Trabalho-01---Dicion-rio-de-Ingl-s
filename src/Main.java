public class Main {
    public static void main(String[] args) {
        String arquivo = "palavras.txt";
        Utils.criarArquivoExemplo(arquivo);
        Dicionario dic = new Dicionario();
        dic.inicializar(arquivo);
        dic.menu();
    }
}
