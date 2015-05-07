package mapaMisantla;


public class Nodo implements Comparable<Nodo>{
	private Estado estado;
	private Nodo pago = null;
	private int profundidad = 0;
	private double costo = 0.0;
	private double comparador = 0.0;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Nodo getPago() {
		return pago;
	}
	public void setPago(Nodo pago) {
		this.pago = pago;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	
        @Override
	public String toString(){
		return estado.toString();
		
	}
	public double getCusto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getComparador() {
		return comparador;
	}
	public void setComparador(double g) {
		this.comparador = g;
	}
	
	@Override
	public int compareTo(Nodo o) {
		if (this.comparador < o.getComparador()){
			return -1;
		}else{
			return 1;
		}		
	}

}
