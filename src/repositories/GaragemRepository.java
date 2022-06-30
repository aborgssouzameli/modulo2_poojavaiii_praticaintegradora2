package repositories;

import java.util.HashSet;
import java.util.Set;

public class GaragemRepository {
    private final Set<VeiculoRepository> veiculos;

    public GaragemRepository() {
        this.veiculos = new HashSet<>();
    }

    public Set<VeiculoRepository> getVeiculos() {
        return veiculos;
    }

    public boolean add(VeiculoRepository veiculo) {
        return this.getVeiculos().add(veiculo);
    }

    public boolean remove(VeiculoRepository veiculo) {
        return this.getVeiculos().remove(veiculo);
    }
}
