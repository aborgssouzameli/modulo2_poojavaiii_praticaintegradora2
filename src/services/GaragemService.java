package services;

import repositories.GaragemRepository;
import repositories.VeiculoRepository;

import java.util.Set;

public class GaragemService {

    GaragemRepository repository;

    public GaragemService() {
        repository = new GaragemRepository();
    }

    public void add(VeiculoService veiculo) {
        repository.add(veiculo.getVeiculo());
    }

    public Set<VeiculoRepository> getVeiculos() {
        return repository.getVeiculos();
    }
}
