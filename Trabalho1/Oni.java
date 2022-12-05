public class Oni {
    private int ID;
    private String marca;
    private String modelo;
    private double quilometragem;
    private Data data_fabri;
    private Motorista motorista;
    private int assentos[][] = new int[8][4];

    // Métodos gets e sets
    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setQuilometragem(double quilometragem){
        this.quilometragem = quilometragem;
    }

    public double getQuilometragem(){
        return this.quilometragem;
    }

    public void setDataFabri(Data data_fabri){
        this.data_fabri = data_fabri;
    }

    public Data getDataFabri(){
        return this.data_fabri;
    }

    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }

    public Motorista getMotorista(){
        return this.motorista;
    }

    public void setAssento(int i, int j){
        this.assentos[i][j] = 1;
    }

    public int getAssento(int i, int j){
        return this.assentos[i][j];
    }

    public void setDadosOnibus(double quilometragem){
        setQuilometragem(quilometragem);
    }

    public String toString(){
        return "\nID: "+ID+""+
            "\nModelo: "+modelo+""+
            "\nMarca: "+marca+""+
            "\nKm: "+quilometragem+""+
            "\nData fabri: "+data_fabri.getDia()+"/"+data_fabri.getMes()+"/"+data_fabri.getAno()+"\n";
    }
}