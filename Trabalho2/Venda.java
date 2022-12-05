public class Venda {
    private int ID;
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;
    private double valor;
    private Data data_venda;

    // Métodos gets e sets
    public int getID() {
        return ID;
    }
    public void setID(int id) {
        ID = id;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Data getData_venda() {
        return data_venda;
    }
    public void setData_venda(Data data_venda) {
        this.data_venda = data_venda;
    }

    // Construtor
    public Venda(int iD, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data_venda) {
        ID = iD;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valor = valor;
        this.data_venda = data_venda;
    }

    public Venda() {
    }

    @Override
    public String toString() {
        return "[ID = " + ID + 
        "\n, cliente = " + cliente.getNome() + " - CPF = " + cliente.getCPF() +  
        "\n, data_venda = " + data_venda.getDia() +  "/" + data_venda.getMes() + "/" + data_venda.getAno() + " - " + data_venda.getHora() + ":" + data_venda.getMin() +
        "\n, valor = " + valor + 
        "\n, veiculo = " + veiculo.getClass() + ", N_chassi = " + veiculo.getN_chassi() + 
        "\n, vendedor = " + vendedor.getNome() + "]\n";
    }
}
