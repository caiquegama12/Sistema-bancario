Usuário Cliente: import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UsuarioCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o IP do Banco (Ex: 192.168.x.x ou 127.0.0.1): ");
        String host = scanner.nextLine();
        int porta = 5000;

        try (
                Socket cliente = new Socket(host, porta);
                PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))
        ) {
            System.out.println("Conectado ao banco com sucesso!");

            System.out.print("\nDigite o número da sua conta (Ex: 123 ou 456): ");
            String conta = scanner.nextLine();

            while (true) {
                mostrarMenu();
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                double valor = 0.0;

//parte de Evily fazer aqui
//parte de Allana fazer aqui