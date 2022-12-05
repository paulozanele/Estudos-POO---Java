public class Funcionario {
    protected String RG;
    protected String nome;
    protected Data data_nasc;
    protected Data data_adm;
    protected double salario;

    // Métodos gets e sets
    public String getRG() {
        return RG;
    }
    public void setRG(String rg) {
        this.RG = rg;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Data getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(Data data_nasc) {
        this.data_nasc = data_nasc;
    }
    public Data getData_adm() {
        return data_adm;
    }
    public void setData_adm(Data data_adm) {
        this.data_adm = data_adm;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Construtor
    public Funcionario(String rg, String nome, Data data_nasc, Data data_adm, double salario) {
        this.RG = rg;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.data_adm = data_adm;
        this.salario = salario;
    }

    public String toString() {
        return "Funcionario [RG = " + RG +
        "\n, nome = " + nome +
        "\n, data_nasc = " + data_nasc.getDia() + "/" + data_nasc.getMes() + "/" + data_nasc.getAno() +
        "\n, data_adm = " + data_adm.getDia() + "/" + data_adm.getMes() + "/" + data_adm.getAno() +
        "\n, salario = " + salario + "]";
    }
}
