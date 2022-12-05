public class End {
    private String rua;
    private int num;
    private String bairro;
    private String cidade;

    // Métodos gets e sets
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "End [rua = " + rua + ", " + num + ", " + bairro + ", " + cidade + "]";
    }
}
