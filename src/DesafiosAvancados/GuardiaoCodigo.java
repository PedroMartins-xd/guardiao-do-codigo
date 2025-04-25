package DesafiosAvancados;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuardiaoCodigo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Nível 1: Desbloqueio da Linguagem Perdida
        System.out.println("Digite uma palavra: ");
        String palavra = sc.next();

        sc.nextLine(); // limpa o buffer antes do próximo nextLine()

        System.out.println(converterTextoParaMinusculo(palavra));

        // Nível 2: Criação de uma Chave Mágica
        String chave;

        while (true) {
            System.out.println("Digite uma Chave Mágica: ");
            chave = sc.nextLine();

            if (!validarChaveMagica(chave)) {
                System.out.println("A Chave Mágica esta Incorreta!, Deve conter: ");
                System.out.println("- Pelo menos 10 caracteres");
                System.out.println("- Pelo menos 1 letra mínuscula");
                System.out.println("- Pelo menos 1 letra maíscula");
                System.out.println("- Pelo menos 1 número");
                System.out.println("- Pelo menos 1 caractere especial (!, @, #, etc.)");
            } else {
                System.out.println("Chave Correta!");
                break;
            }
        }


        // Menu de modo de jogo
        System.out.println("=== Menu de Jogos ===");
        System.out.println("1 - Modo Normal (1 a 100, 7 tentativas)");
        System.out.println("2 - Modo Hardcore (1 a 120, 5 tentativas)");
        System.out.print("Escolha o modo: ");
        int modo = sc.nextInt();
        sc.nextLine(); // limpa o buffer


        int numeroSecreto;
        int tentativas;

        if (modo == 1) {
            numeroSecreto = random.nextInt(100) + 1;
            tentativas = 7;
            System.out.println("Modo Normal foi selecionado");
            System.out.println("Adivinhe o número entre 1 e 100. Você tem "
                    + tentativas + " tentativas!");
        } else if (modo == 2) {
            numeroSecreto = random.nextInt(120) + 1;
            tentativas = 5;
            System.out.println("Modo Hardcore Ativado");
            System.out.println("Adivinhe o número entre 1 e 120. Você tem "
                    + tentativas + " tentativas!");
        } else {
            System.out.println("Modo inválido! Iniciando em Modo Normal por padrão");
            numeroSecreto = random.nextInt(100) + 1;
            tentativas = 7;
        }


        // Lista de Mensagens Mistícas
        ArrayList<String> mensagens = new ArrayList<>();
        mensagens.add("Linus Torvalds: Simples é melhor do que complexo.");
        mensagens.add("Ada Lovelace: A criatividade é a essência da programação.");
        mensagens.add("Alan Turing: O impossível é só o que ainda não foi feito.");


        // Nível 3: Duelo contra o Bug Supremo
        for (int i = 1; i <= tentativas; i++) {
            System.out.println("Tentativa " + i + ": ");
            int chute = sc.nextInt();

            int diferenca = Math.abs(chute - numeroSecreto);
            if (diferenca == 0) {
                System.out.println("Acertou!, Mensagem Mágica desbloquead!");
                System.out.println(mensagens.get(random.nextInt(mensagens.size())));
                sc.close();
                return;
            } else if (diferenca < 10) {
                System.out.println("Você está perto!");
            } else {
                System.out.println("Você está longe!");
            }
        }

        System.out.println("Acabaram suas tentativas! O número era: " + numeroSecreto);
        sc.close();
    }

    private static String converterTextoParaMinusculo(String palavra) {
        return new StringBuilder(palavra).reverse().toString().toLowerCase();
    }

    private static boolean validarChaveMagica(String chave) {
        return chave.length() >= 10 &&
                chave.matches(".*[A-Z].*") &&
                chave.matches(".*[0-9].*") &&
                chave.matches(".*[^a-zA-Z0-9].*");
    }
}
