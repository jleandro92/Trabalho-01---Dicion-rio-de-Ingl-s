import java.io.*;

public class Utils {
    public static void criarArquivoExemplo(String caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            writer.println("apple;maçã;substantivo");
            writer.println("dog;cachorro;substantivo");
            writer.println("run;correr;verbo");
            writer.println("blue;azul;adjetivo");
            writer.println("house;casa;substantivo");
            writer.println("car;carro;substantivo");
            writer.println("fast;rápido;adjetivo");
            writer.println("eat;comer;verbo");
            writer.println("book;livro;substantivo");
            writer.println("happy;feliz;adjetivo");
            writer.println("jump;pular;verbo");
            writer.println("river;rio;substantivo");
            writer.println("sun;sol;substantivo");
            writer.println("cold;frio;adjetivo");
            writer.println("friend;amigo;substantivo");
            writer.println("green;verde;adjetivo");
            writer.println("sleep;dormir;verbo");
            writer.println("water;água;substantivo");
            writer.println("small;pequeno;adjetivo");
            writer.println("the;o/a;artigo");
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }
}