public class Cliente {
    private String CPF;
    private String nome;
    private Data data_nasc;
    private End endereco;
    private double renda;
    private int dependentes;
    
    
    // Métodos gets e sets
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cpf) {
        CPF = cpf;
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
    public End getEndereco() {
        return endereco;
    }
    public void setEndereco(End endereco) {
        this.endereco = endereco;
    }
    public double getRenda() {
        return renda;
    }
    public void setRenda(double renda) {
        this.renda = renda;
    }
    public int getDependentes() {
        return dependentes;
    }
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    // Construtores
    public Cliente(String cpf, String nome, Data data_nasc, End endereco, double renda) {
        CPF = cpf;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.renda = renda;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "[CPF = " + CPF + 
        "\n, nome = " + nome + 
        "\n, data_nasc = " + data_nasc.getDia() + "/" + data_nasc.getMes() + "/" + data_nasc.getAno() + 
        "\n, endereco = " + endereco.getRua() + ", " + endereco.getNum() + ", " + endereco.getBairro() + ", " + endereco.getCidade() + 
        "\n, dependentes = " + dependentes +
        "\n, renda = " + renda + "]\n";
    }
}
