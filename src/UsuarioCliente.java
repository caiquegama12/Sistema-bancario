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

String requisicao = opcao + ";" + conta + ";" + valor;
                saida.println(requisicao);

String respostaStr = entrada.readLine();
                if (respostaStr == null) break;

String[] partesResposta = respostaStr.split(";");
String status = partesResposta[0];
String mensagemOuSaldo = partesResposta.length > 1 ? partesResposta[1] : "";

                if (status.equals("sucesso")) {
        System.out.printf("\n[SUCESSO] Seu saldo atual é: R$ %.2f\n", Double.parseDouble(mensagemOuSaldo));
        } else {
        System.out.println("\n[ERRO] " + mensagemOuSaldo);
                }
                        }
                        } catch (IOException e) {
        System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        scanner.close();
    }
private static void mostrarMenu() {
    System.out.println("\n==============================");
    System.out.println("      CAIXA ELETRÔNICO      ");
    System.out.println("==============================");
    System.out.println("1. Consultar Saldo");
    System.out.println("2. Fazer Depósito");
    System.out.println("3. Fazer Saque");
    System.out.println("4. Sair");
    System.out.println("==============================");
}
}



