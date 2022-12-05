public class Carro extends Veiculo{
    private double potencia;
    private int cilindros;
    private int n_lugares;
    private String tipo; // utilitário, pickup, sedan, hatch, esportivo
    private double altura;
    private double largura;
    private double comprimento;

    
    // Métodos gets e sets
    public double getPotencia() {
        return potencia;
    }
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }
    public int getCilindros() {
        return cilindros;
    }
    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }
    public int getN_lugares() {
        return n_lugares;
    }
    public void setN_lugares(int n_lugares) {
        this.n_lugares = n_lugares;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {
        this.largura = largura;
    }
    public double getComprimento() {
        return comprimento;
    }
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    // Construtores
    public Carro(int n_chassi, String marca, String modelo, Data ano, double km, String combustivel, double peso,
            boolean vendido, double potencia, int cilindros, int n_lugares, String tipo, double altura, double largura,
            double comprimento) {
        super(n_chassi, marca, modelo, ano, km, combustivel, peso, vendido);
        this.potencia = potencia;
        this.cilindros = cilindros;
        this.n_lugares = n_lugares;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Carro() {
        super(0, "", "", null, 0, "", 0, false);
    }

    @Override
    public String toString() {
        return "[ano = " + ano.getAno() + 
        "\n, combustivel = " + combustivel + 
        "\n, km = " + km + 
        "\n, marca = " + marca + 
        "\n, modelo = " + modelo + 
        "\n, n_chassi = " + n_chassi + 
        "\n, peso = " + peso + 
        "\n, potencia = " + potencia + 
        "\n, cilindros = " + cilindros + 
        "\n, n_lugares = " + n_lugares + 
        "\n, tipo = " + tipo + 
        "\n, alt x larg x comp = " + altura + "x" + largura + "x" + comprimento + 
        "\n, vendido = " + vendido + "]\n";
    }
}
