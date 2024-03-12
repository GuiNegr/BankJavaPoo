import java.util.Scanner;

public class Main {
    static Conta[] conta;
    static Conta referencia;
    static Conta pagador;
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean cont = true;

        do {
            conta = criar();
            Boolean procedimento = true;
            while (procedimento) {
                System.out.println("DESEJA REALIZAR QUAIS FUNÇÕES? \nSACAR \nDEPOSITAR \nMOSTRAR INFORMAÇÕES DA CONTA \nTRANSFERENCIA");
                String resp = ler.next();
                funcaoconta(resp);
                System.out.println("DESEJA CONTINUAR? S/N");
                String continuea = ler.next();
                if (continuea.equalsIgnoreCase("n")) {
                    procedimento = false;
                    cont = false;

                }
            }
        } while (cont);
        System.out.println("OBRIGADO POR UTILIZAR");
    }

    public static void funcaoconta(String respperg) throws Exception {
        System.out.println("INFORME O NUMERO DA CONTA PARA ACESSAR AS FUNCIONALIDADES ");
        int resp = ler.nextInt();
        for (int i = 0; i < conta.length; i++) {
            if (resp == conta[i].getNumero()) {
                if (respperg.equalsIgnoreCase("SACAR")) {
                    System.out.println("INFORME O VALOR PARA SAQUE");
                    double valor = ler.nextDouble();
                    if (conta[i].saca(valor)) {
                        System.out.println("SAQUE REALIZADO COM SUCESSO");
                    } else {
                        System.out.println("INFORME O VALOR NOVAMENTE");
                        valor = ler.nextDouble();
                    }
                } else if (respperg.equalsIgnoreCase("DEPOSITAR")) {
                    System.out.println("INFORME O VALOR PARA DEPOSITO");
                    double valor = ler.nextDouble();
                    conta[i].deposita(valor);
                } else if (respperg.equalsIgnoreCase("INFORMAÇÕES")) {
                    String a = conta[i].toString();
                    System.out.println(a);
                }else if(respperg.equalsIgnoreCase("TRANSFERENCIA")){
                    transferencia(resp);
                }
                break;
            }
        }
    }

    public static Conta[] criar() {
        System.out.println("QUANTAS CONTAS DESEJA CADASTRAR?");
        int resp = ler.nextInt();
        Conta[] conta = new Conta[resp];
        for (int i = 0; i < conta.length; i++) {
            System.out.println("informe o numero da conta");
            int numero = ler.nextInt();
            System.out.println("Informe o saldo residente da conta");
            int saldo = ler.nextInt();
            System.out.println("informe o limte da conta");
            int limite = ler.nextInt();
            System.out.println("informe o nome da conta");
            String nome = ler.next();
            Conta contanew = new Conta(numero, saldo, limite, nome);
            conta[i] = contanew;
        }
        return conta;
    }

    public static void transferencia(int resper) throws Exception {
        Conta ajudante = new Conta();
        System.out.println("INFORME O NUMERO DA CONTA PRA ONDE IRÁ REALIZAR A TRANSFERENCIA");
        int resp = ler.nextInt();
        for (int i = 0; i < conta.length; i++) {
            if (resp == conta[i].getNumero()) {
                referencia = conta[i];
                break;
            }
        }
        for (int i = 0; i < conta.length; i++) {
            if (resper == conta[i].getNumero()) {
                 pagador = conta[i];
                break;
            }
        }
        System.out.println("INFORME O VALOR QUE IRÁ TRANSFERIR");
        double valor = ler.nextDouble();
        try {
            ajudante.transferencia(referencia, pagador, valor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}