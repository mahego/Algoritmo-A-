package mapaMisantla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BuscaCI {

	private Problema problema;
	private HashSet<Estado> visitados;
	private DistanciaLR informacion;

	public BuscaCI(Problema problema, DistanciaLR informacion){
		this.problema = problema;
		this.informacion = informacion;
	}

	public Stack<Nodo> codicia() {
		this.visitados = new HashSet<>();
		Stack<Nodo> borda = new Stack<>();

		Nodo no = new Nodo();
		no.setEstado(problema.getEstadoInicial());
		borda.push(no);

		while (!borda.isEmpty()) {

			no = borda.pop();

			if (problema.isObjetivo(no.getEstado())) {
				return solucao(no);
			}

			borda.addAll(expandirCodicia(no));
		}

		return null;
	}

	public Stack<Nodo> A_Asterico() {
		this.visitados = new HashSet<>();
		List<Nodo> borda = new ArrayList<>();

		Nodo no = new Nodo();
		no.setEstado(problema.getEstadoInicial());
		borda.add(no);

		while (!borda.isEmpty()) {

			no = borda.remove(0);

			if (problema.isObjetivo(no.getEstado())) {
				return solucao(no);
			}

			borda.addAll(expandirAsterico(no));
			Collections.sort(borda);
		}

		return null;
	}

	private Stack<Nodo> solucao(Nodo no) {
		Stack<Nodo> caminho = new Stack<>();
		caminho.add(no);

		Nodo pago = no.getPago();
		while (pago != null) {
			caminho.push(pago);
			pago = pago.getPago();
		}

		return caminho;
	}

	private List<Nodo> expandirCodicia(Nodo no) {
		List<Nodo> sucessores = new ArrayList<>();

		// imprimirArbol(no);

		this.visitados.add(no.getEstado());

		for (Arista aresta : problema.getMapa().get(no.getEstado())) {

			if (!this.visitados.contains(aresta.getDestino())) {
				Nodo novo = new Nodo();
				novo.setEstado(aresta.getDestino());
				novo.setPago(no);
				novo.setProfundidad((no.getProfundidad() + 1));
				double distanciaLR = informacion.getDistancia(
						aresta.getDestino(), problema.getEstadoFinal());
				
                                // usado para ordenar
                                novo.setComparador(distanciaLR); 
				sucessores.add(novo);                                
			}
		}

		Collections.sort(sucessores, Collections.reverseOrder());

		return sucessores;
	}

	private List<Nodo> expandirAsterico(Nodo no) {
		List<Nodo> sucessores = new ArrayList<>();

		this.visitados.add(no.getEstado());

		for (Arista aresta : problema.getMapa().get(no.getEstado())) {

			if (!this.visitados.contains(aresta.getDestino())) {

				Nodo novo = new Nodo();
				novo.setEstado(aresta.getDestino());
				novo.setPago(no);
				novo.setProfundidad((no.getProfundidad() + 1));
				double distanciaLR = informacion.getDistancia(
						aresta.getDestino(), problema.getEstadoFinal());
				novo.setCosto(aresta.getCusto() + no.getCusto());

				// usado para ordenar
				novo.setComparador((aresta.getCusto() + no.getCusto()) + distanciaLR);

				/*
				 System.out .println((aresta.getCusto() + no.getCusto() +
				 distanciaLR) + " = " + (aresta.getCusto() + no.getCusto()) +
				 " + " + distanciaLR + " -- " + novo.getEstado());
                                        */
				
				sucessores.add(novo);
			}
		}

		return sucessores;
	}

	private void imprimirArbol(Nodo no) {
		String str = "";
		for (int i = 0; i < no.getProfundidad(); i++) {
			str += "\t";
		}
		System.out.println(str + "<<" + no + ">>");
	}

}
