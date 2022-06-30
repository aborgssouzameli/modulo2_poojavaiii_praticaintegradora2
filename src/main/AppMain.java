package main;

import enuns.Marca;
import repositories.VeiculoRepository;
import services.*;

import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class AppMain {
    private static AppMain app;
    private GaragemService garagem;
    public AppMain() {
        garagem = new GaragemService();
    }
    public static void main (String[] args) {
        app = new AppMain();
        app.inicializa();
    }

    public void inicializa () {
        adicionarVeiculos();
        ordenarVeiculoMenorMaiorValor();
        ordenarVeiculoPorMarca();
        exibirVeiculoPrecoMaximo(1000.00);
        exibirVeiculoPrecoIgualSuperior(1000.00);
        exibirValorMedioVeiculoPorMarca();
    }

    public void adicionarVeiculos() {
        garagem.add(new VeiculoService("Fiesta", Marca.FORD, 1000.00));
        garagem.add(new VeiculoService("Focus", Marca.FORD, 1200.00));
        garagem.add(new VeiculoService("Explorer", Marca.FORD, 2500.00));
        garagem.add(new VeiculoService("Uno", Marca.FIAT, 500.00));
        garagem.add(new VeiculoService("Cronos", Marca.FIAT, 1000.00));
        garagem.add(new VeiculoService("Torino", Marca.FIAT, 1250.00));
        garagem.add(new VeiculoService("Aveo", Marca.CHEVROLET, 1250.00));
        garagem.add(new VeiculoService("Spin", Marca.CHEVROLET, 2500.00));
        garagem.add(new VeiculoService("Corolla", Marca.TOYOTA, 1200.00));
        garagem.add(new VeiculoService("Fortuner", Marca.TOYOTA, 3000.00));
        garagem.add(new VeiculoService("Logan",Marca.RENAULT, 950.00));
    }

    public void ordenarVeiculoMenorMaiorValor() {
        System.out.println("\n[Ordenando veículo de menor valor para maior]");
        retornarStreamVeiculosGaragem()
                .sorted(Comparator.comparing(VeiculoService::getPreco))
                .forEach(v -> System.out.println(v.toString()))
        ;
    }

    public void ordenarVeiculoPorMarca() {
        System.out.println("\n[Ordenando veículo de acordo com a marca (crescente)]");
        retornarStreamVeiculosGaragem()
                .sorted(Comparator.comparing(VeiculoService::getMarca))
                .forEach(v -> System.out.println(v.toString()))
        ;
    }

    public void exibirVeiculoPrecoMaximo(Double preco) {
        System.out.println("\n[Ordenando veículo de acordo a faixa de preço máximo]");
        retornarStreamVeiculosGaragem()
                .filter(veiculo -> veiculo.getPreco().doubleValue() < preco.doubleValue())
                .forEach(v -> System.out.println(v.toString()));
    }

    public void exibirVeiculoPrecoIgualSuperior(Double preco) {
        System.out.println("\n[Ordenando veículo de acordo a faixa de preço máximo]");
        retornarStreamVeiculosGaragem()
                .filter(veiculo -> veiculo.getPreco().doubleValue() >= preco.doubleValue())
                .forEach(v -> System.out.println(v.toString()));
    }

    public void exibirValorMedioVeiculoPorMarca() {
        for (Marca marca: Marca.values()) {
            OptionalDouble valorMedioVeiculo = retornarStreamVeiculosGaragem()
                    .filter(veiculo-> marca.equals(veiculo.getMarca()))
                    .mapToDouble(VeiculoService::getPreco).average();
            System.out.printf("\nPreço médio de veículos da marca %s: %.2f\n", marca, valorMedioVeiculo.getAsDouble());
        }
    }

    private Stream<VeiculoRepository> retornarStreamVeiculosGaragem() {
        return garagem.getVeiculos().stream();
    }
}
