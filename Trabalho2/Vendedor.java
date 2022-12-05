public class Vendedor extends Funcionario{
    private int tempo_trein_rest;
    private Gerente resp;
    
    // Métodos gets e sets 
    public int getTempo_trein_rest() {
        return tempo_trein_rest;
    }
    public Gerente getResp() {
        return resp;
    }
    public void setTempo_trein_rest(int tempo_trein_rest) {
        this.tempo_trein_rest = tempo_trein_rest;
    }
    public void setResp(Gerente resp) {
        this.resp = resp;
    }

    // Construtores
    public Vendedor(String RG, String nome, Data data_nasc, Data data_adm, double salario, int tempo_trein_rest, Gerente resp) {
        super(RG, nome, data_nasc, data_adm, salario);
        this.tempo_trein_rest = tempo_trein_rest;
        this.resp = resp;
    }

    public Vendedor(){
        super("", "", null, null, 0);
    }

    public String toString() {
        return "[RG = " + RG + 
        "\n, nome = " + nome +
        "\n, data_nasc = " + data_nasc.getDia() + "/" + data_nasc.getMes() + "/" + data_nasc.getAno() +
        "\n, data_adm = " + data_adm.getDia() + "/" + data_adm.getMes() + "/" + data_adm.getAno() +
        "\n, salario = " + salario + 
        "\n, tempo restante treinamento (dias) = " + tempo_trein_rest + "]\n";
    }
}
