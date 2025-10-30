public class Palavra {
    private String ingles;
    private String portugues;
    private String classificacao;

    public Palavra(String i, String p, String c) {
        this.ingles = toLower(i);
        this.portugues = p;
        this.classificacao = c;
    }

    public Palavra() {
        this("", "", "");
    }

    public String getIngles() {
        return ingles;
    }

    public String getPortugues() {
        return portugues;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public static String toLower(String s) {
        return s.toLowerCase();
    }
}
