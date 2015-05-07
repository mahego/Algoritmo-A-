package mapaMisantla;

import java.util.ArrayList;
import java.util.HashMap;

public class Problema {

    private HashMap<Estado, ArrayList<Arista>> mapa;
    private Estado estadoInicial;
    private Estado estadoFinal;

    public Problema() {
        ArrayList<Arista> estados;
        mapa = new HashMap<>();

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Teziutlan, 171));
        estados.add(new Arista(Estado.Tlapacoyan, 455));
        mapa.put(Estado.SanJose, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Teziutlan, 356));
        estados.add(new Arista(Estado.SanJose, 455));
        estados.add(new Arista(Estado.Misantla, 193));
        estados.add(new Arista(Estado.Hupiltepec, 280));
        mapa.put(Estado.Tlapacoyan, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.SanJose, 75));
        estados.add(new Arista(Estado.Tlapacoyan, 71));
        mapa.put(Estado.SanJose, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Manantiales, 140));
        estados.add(new Arista(Estado.Martinez, 151));
        estados.add(new Arista(Estado.Misantla, 80));
        estados.add(new Arista(Estado.Tlapacoyan, 99));
        mapa.put(Estado.Hupiltepec, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Hupiltepec, 71));
        mapa.put(Estado.Manantiales, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Hupiltepec, 111));
        estados.add(new Arista(Estado.Misantla, 70));
        estados.add(new Arista(Estado.SanRafael, 70));
        mapa.put(Estado.Martinez, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Martinez, 70));
        estados.add(new Arista(Estado.Casitas, 75));
        estados.add(new Arista(Estado.Nautla, 75));
        mapa.put(Estado.SanRafael, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.SanRafael, 75));
        mapa.put(Estado.Casitas, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Vega, 120));
        estados.add(new Arista(Estado.Raudal, 146));
        estados.add(new Arista(Estado.SanRafael, 138));
        mapa.put(Estado.Nautla, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Tlapacoyan, 80));
        estados.add(new Arista(Estado.Hupiltepec, 146));
        estados.add(new Arista(Estado.Martinez, 97));
        estados.add(new Arista(Estado.Vega, 146));
        estados.add(new Arista(Estado.Yecuatla, 97));
        mapa.put(Estado.Misantla, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Nautla, 99));
        estados.add(new Arista(Estado.Raudal, 211));
        estados.add(new Arista(Estado.Yecuatla, 211));
        mapa.put(Estado.Vega, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Misantla, 101));
        mapa.put(Estado.Yecuatla, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Nautla, 211));
        estados.add(new Arista(Estado.Vega, 101));
        estados.add(new Arista(Estado.Carranza, 90));
        mapa.put(Estado.Raudal, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Carranza, 90));
        estados.add(new Arista(Estado.Cardel, 90));
        estados.add(new Arista(Estado.Misantla, 90));
        mapa.put(Estado.Tenochtitlan, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Raudal, 85));
        estados.add(new Arista(Estado.Tenochtitlan, 98));
        estados.add(new Arista(Estado.Cardel, 142));
        mapa.put(Estado.Carranza, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Tenochtitlan, 86));
        estados.add(new Arista(Estado.Carranza, 86));
        estados.add(new Arista(Estado.Vencedor, 86));
        mapa.put(Estado.Cardel, estados);

        estados = new ArrayList<>();
        estados.add(new Arista(Estado.Cardel, 96));
        mapa.put(Estado.Vencedor, estados);

    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public HashMap<Estado, ArrayList<Arista>> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<Estado, ArrayList<Arista>> mapa) {
        this.mapa = mapa;
    }

    public Estado getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(Estado estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public boolean isObjetivo(Estado estado) {
        return (estado.equals(getEstadoFinal()));
    }

}
