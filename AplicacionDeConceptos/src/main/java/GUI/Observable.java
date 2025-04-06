package GUI;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void eliminarObservador(Observador obs) {
        observadores.remove(obs);
    }

    protected void notificarObservadores(String tipoEntidad, String accion, Object dato) {
        for (Observador obs : observadores) {
            obs.actualizar(tipoEntidad, accion, dato);
        }
    }
}
