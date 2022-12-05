public class Motorista {
    private String nomeMotorista;
    private String numCarta;
    private Data dataAdmissao;

    // Métodos gets e sets
    public void setNomeMotorista(String nomeMotorista){
        this.nomeMotorista = nomeMotorista;
    }    

    public String getNomeMotorista(){
        return nomeMotorista;
    }

    public void setNumCarta(String numCarta){
        this.numCarta = numCarta;
    }

    public String getNumCarta(){
        return numCarta;
    }

    public void setDataAdmissao(Data dataAdmissao){
        this.dataAdmissao = dataAdmissao;
    }

    public Data getDataAdmissao(){
        return dataAdmissao;
    }

    public String toString(){
        return "\nNome: "+nomeMotorista+""+
            "\nCNH: "+numCarta+""+
            "\nData admissao: "+dataAdmissao.getDia()+"/"+dataAdmissao.getMes()+"/"+dataAdmissao.getAno()+"\n";
    }
}