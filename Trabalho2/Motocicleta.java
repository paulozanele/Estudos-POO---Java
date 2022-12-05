public class Motocicleta extends Veiculo{
    
    private int cilindradas;
    private String tipo; // trail, street, esportiva, custom

    // Métodos gets e sets
    public int getCilindradas() {
        return cilindradas;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Construtores
    public Motocicleta(int n_chassi, String marca, String modelo, Data ano, double km, String combustivel, double peso,
            boolean vendido, int cilindradas, String tipo) {
        super(n_chassi, marca, modelo, ano, km, combustivel, peso, vendido);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }

    public Motocicleta() {
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
        "\n, cilindradas = " + cilindradas + 
        "\n, tipo = " + tipo + 
        "\n, vendido = " + vendido + "]\n";
    }
}
