import java.util.Scanner;

public class Dicionario {
    private BST arvore;
    private ListaDupla listaTemp;

    public Dicionario() {
        arvore = new BST();
        listaTemp = new ListaDupla();
    }

    public void inicializar(String arquivo) {
        listaTemp.carregarDoArquivo(arquivo);
        int total = listaTemp.tamanho();
        System.out.println("Carregadas " + total + " palavras. Inserindo na árvore de forma aleatoria...");

        while (!listaTemp.vazia()) {
            arvore.inserir(listaTemp.removerAleatorio());
        }
        System.out.println("Dicionario inicializado!\n");
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("=== DICIONARIO DE INGLES ===");
            System.out.println("1. Buscar palavra");
            System.out.println("2. Remover palavra");
            System.out.println("3. Adicionar nova palavra");
            System.out.println("4. Listar em ordem (In-Order)");
            System.out.println("5. Listar em largura (Level-Order)");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Palavra em ingles: ");
                    String ing = sc.nextLine();
                    Palavra res = arvore.buscar(ing);
                    if (res != null)
                        System.out.println(res.getIngles() + "->" + res.getPortugues() + " (" + res.getClassificacao() + ")");
                    else
                        System.out.println("Palavra nao encontrada.");
                    break;

                case 2:
                    System.out.print("Palavra a remover: ");
                    String rm = sc.nextLine();
                    arvore.remover(rm);
                    System.out.println("Operacao concluida.");
                    break;

                case 3:
                    System.out.print("Ingles: ");
                    String i = sc.nextLine();
                    System.out.print("Portugues: ");
                    String p = sc.nextLine();
                    System.out.print("Classificacao: ");
                    String c = sc.nextLine();
                    arvore.inserir(new Palavra(i, p, c));
                    System.out.println("Palavra adicionada.");
                    break;

                case 4:
                    System.out.println("Palavras em ordem:");
                    arvore.listarEmOrdem();
                    break;

                case 5:
                    System.out.println("Palavras em largura:");
                    arvore.listarEmLargura();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
            System.out.println();
        } while (opcao != 0);

        sc.close();
    }
}
