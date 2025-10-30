public class NoBST {
    Palavra palavra;
    NoBST esq;
    NoBST dir;

    public NoBST(Palavra p) {
        this.palavra = p;
        this.esq = null;
        this.dir = null;
    }
}
