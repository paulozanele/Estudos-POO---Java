public class Veiculo {
    protected int n_chassi;
    protected String marca;
    protected String modelo;
    protected Data ano;
    protected double km;
    protected String combustivel; // gasolina, álcool ou flex
    protected double peso;
    protected boolean vendido;

    // Métodos gets e sets
    public int getN_chassi() {
        return n_chassi;
    }
    public void setN_chassi(int n_chassi) {
        this.n_chassi = n_chassi;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Data getAno() {
        return ano;
    }
    public void setAno(Data ano) {
        this.ano = ano;
    }
    public double getKm() {
        return km;
    }
    public void setKm(double km) {
        this.km = km;
    }
    public String getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public boolean isVendido() {
        return vendido;
    }
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    // Construtor
    public Veiculo(int n_chassi, String marca, String modelo, Data ano, double km, String combustivel, double peso,
            boolean vendido) {
        this.n_chassi = n_chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = km;
        this.combustivel = combustivel;
        this.peso = peso;
        this.vendido = vendido;
    }

    public Veiculo() {
    }
    
    @Override
    public String toString() {
        return "Veiculo [ano = " + ano + 
        "\n, combustivel = " + combustivel + 
        "\n, km = " + km + 
        "\n, marca = " + marca + 
        "\n, modelo = " + modelo + 
        "\n, n_chassi = " + n_chassi + 
        "\n, peso = " + peso + 
        "\n, vendido = " + vendido + "]";
    }
}
