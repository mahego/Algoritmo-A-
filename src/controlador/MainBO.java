package controlador;

import java.util.Stack;
import javax.swing.DefaultListModel;
import mapaMisantla.BuscaCI;
import mapaMisantla.DistanciaLR;
import mapaMisantla.Estado;
import mapaMisantla.Nodo;
import mapaMisantla.Problema;
import view.MapaJFrame;

/**
 *
 * @author leandro
 */
public class MainBO {

    public MapaJFrame view;
    public Problema problema;
    public BuscaCI busca;
    public Stack<Nodo> solucao;

    public MainBO(MapaJFrame view) {
        this.view = view;
        this.problema = new Problema();
        this.problema = new Problema();
        this.busca = new BuscaCI(problema, new DistanciaLR());
    }

    public void resolve(String busca) {
        this.problema.setEstadoInicial(Estado.valueOf(this.view.inicio));
        this.problema.setEstadoFinal(Estado.valueOf(this.view.fim));

        long ti = 0, tf = 0;
        solucao = null;
        if ("Codicioso".equals(busca)) {
            ti = System.currentTimeMillis();
            solucao = this.busca.codicia();
            tf = System.currentTimeMillis();
        } else if ("A*".equals(busca)) {
            ti = System.currentTimeMillis();
            solucao = this.busca.A_Asterico();
            tf = System.currentTimeMillis();
        }

        imprimeCaminho(solucao);
    }
    
    public void imprimeCaminho(Stack<Nodo> caminho) {
        DefaultListModel lista = new DefaultListModel();
        if (caminho == null) {
            lista.addElement("Camino no encontrado");
            view.getLista().setModel(lista);
            return;
        }

        Nodo no;
        do {
            no = caminho.pop();
            lista.addElement(no.toString());

        } while (!caminho.isEmpty());
        view.getLista().setModel(lista);
    }
}