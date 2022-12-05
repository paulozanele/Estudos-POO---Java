public class Passageiro {
	private String numRG;
	private String nome;
	private String end;
	private Data data_nasc;
	
	// Métodos gets e sets
	public void setNumRG(String numRG){
		this.numRG = numRG;
	}
	
	public String getNumRG(){
		return this.numRG;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setEnd(String end){
		this.end = end;
	}
	
	public String getEnd(){
		return this.end;
	}
	
	public void setData(Data data_nasc){
		this.data_nasc = data_nasc;
	}
	
	public Data getData(){
		return this.data_nasc;
	}

	public String toString(){
		return "\nID: "+numRG+""+
			"\nNome: "+nome+""+
			"\nEndereco: "+end+""+
			"\nData nasc: "+data_nasc.getDia()+"/"+data_nasc.getMes()+"/"+data_nasc.getAno()+"\n";
	}
}