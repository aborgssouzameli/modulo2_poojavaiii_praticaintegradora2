package services;

import enuns.Marca;
import repositories.VeiculoRepository;

public class VeiculoService {
    VeiculoRepository repository;
    public VeiculoService(String modelo, Marca marca, Double preco) {
        repository = new VeiculoRepository(modelo, marca, preco);
    }

    public VeiculoRepository getVeiculo() {
        return repository;
    }

    public Double getPreco() {
        return repository.getPreco();
    }

    public static Double getPreco(VeiculoRepository r) {
        return r.getPreco();
    }

    public static Marca getMarca(VeiculoRepository r) {
        return r.getMarca();
    }

}
