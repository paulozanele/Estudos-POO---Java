public class Data {
	private int dia;
	private int mes;
	private int ano;
	private String hora;
	private String min;

	// Métodos gets e sets
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		if(dia >= 1 && dia <= 31)
			this.dia = dia;
		else
			System.out.println("Data invalida.");
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		if(mes >= 1 && mes <= 12)
			this.mes = mes;
		else
			System.out.println("Data invalida.");
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		if(ano >= 1950 && ano <= 2050)
			this.ano = ano;
		else
			System.out.println("Data invalida.");
	}
	public String getHora() {
		return hora;
	}
	public void setHora(int hora) {
		String aux;
		if(hora >= 0 && hora <= 23){
			if(hora >=0 && hora <= 9){
				aux = String.valueOf(hora);
				aux = "0" + aux;
			}else{
				aux = String.valueOf(hora);
			}
			this.hora = aux;
		}else
			System.out.println("Horario invalido.");
	}
	public String getMin() {
		return min;
	}
	public void setMin(int min) {
		String aux;
		if(min >= 0 && min <= 59){
			if(min >= 0 && min <= 9){
				aux = String.valueOf(min);
				aux = "0" + aux;
			}else{
				aux = String.valueOf(min);
			}
			this.min = aux;
		}else
			System.out.println("Horario invalido.");
	}
}