public class Gerente extends Funcionario{
    private int anos_exp;

    // Métodos get e set
    public int getAnos_xp() {
        return anos_exp;
    }
    public void setAnos_xp(int anos_xp) {
        this.anos_exp = anos_xp;
    }

    // Construtores
    public Gerente(String rg, String nome, Data data_nasc, Data data_adm, double salario, int anos_exp) {
        super(rg, nome, data_nasc, data_adm, salario);
        this.anos_exp = anos_exp;
    }

    public Gerente() {
        super("", "", null, null, 0);
    }

    public String toString() {
        return "[RG = " + RG + 
        "\n, nome = " + nome +
        "\n, data_nasc = " + data_nasc.getDia() + "/" + data_nasc.getMes() + "/" + data_nasc.getAno() +
        "\n, data_adm = " + data_adm.getDia() + "/" + data_adm.getMes() + "/" + data_adm.getAno() +
        "\n, salario = " + salario + 
        "\n, anos exp = " + anos_exp + "]\n";
    }
}
