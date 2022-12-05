public class Rota {
    private int ID;
    private String origem;
    private String parada;
    private String destino;
    private Data saida;
    private Data chegada;
    private Oni onibus;

    // Métodos gets e sets
    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
    }

    public void setOrigem(String origem){
        this.origem = origem;
    }

    public String getOrigem(){
        return this.origem;
    }

    public void setParada(String parada){
        this.parada = parada;
    }

    public String getParada(){
        return this.parada;
    }

    public void setDetino(String destino){
        this.destino = destino;
    }

    public String getDestino(){
        return this.destino;
    }

    public void setSaida(Data saida){
        this.saida = saida;
    }

    public Data getSaida(){
        return this.saida;
    }

    public void setChegada(Data chegada){
        this.chegada = chegada;
    }

    public Data getChegada(){
        return this.chegada;
    }

    public void setOnibus(Oni onibus){
        this.onibus = onibus;
    }

    public Oni getOnibus(){
        return this.onibus;
    }

    public String toString(){
        return "\nID rota: "+ID+""+
            "\nOrigem: "+origem+""+
            "\nParada: "+parada+""+
            "\nDestino: "+destino+""+
            "\nMotorista: "+onibus.getMotorista().getNomeMotorista()+""+
            "\nID Onibus: "+onibus.getID()+""+
            "\nSaida: "+saida.getDia()+"/"+saida.getMes()+"/"+saida.getAno()+" - "+saida.getHora()+":"+saida.getMin()+""+
            "\nChegada: "+chegada.getDia()+"/"+chegada.getMes()+"/"+chegada.getAno()+" - "+chegada.getHora()+":"+chegada.getMin()+"\n";

    }
}