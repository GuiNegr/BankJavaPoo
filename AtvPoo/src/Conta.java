public class Conta {
    private int numero;

    private double saldo, limite;
    private String nome;

    public Conta() {

    }

    public Conta(int numero, double saldo, double limite, String nome) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.nome = nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public String getNome() {
        return nome;
    }

    public double getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean saca(double valor) {
        if (valor <= (this.saldo + this.limite)) {
            this.saldo -= valor;
            return true;
        } else return false;
    }

    public void deposita(double valor) {
        if (valor >= 0) {
            this.saldo += valor;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nNumero da conta: " + getNumero() + "\nSaldo: " + getSaldo() + "\nLimite da conta: " + getLimite();
    }

    public void transferencia(Conta referencia, Conta pagador, double valor) throws Exception {
        if (valor <= (pagador.getSaldo() + pagador.getLimite())) {
            pagador.saldo -= valor;
            referencia.saldo += valor;
            System.out.println("TRANSFERENCIA REALIZADA COM SUCESSO");

        }else {
            throw new Exception("ERRO SALDO NAO SUFICIENTE");
        }

    }
}

