//parte de Keilla fazer aqui
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



