package repositories;

import enuns.Marca;

public class VeiculoRepository {

        private String modelo;
        private Marca marca;
        private Double preco;

        public VeiculoRepository(String modelo, Marca marca, Double preco) {
            this.modelo = modelo;
            this.marca = marca;
            this.preco = preco;
        }
        public String getModelo() {
            return modelo;
        }
        public Marca getMarca() {
            return marca;
        }
        public Double getPreco() {
            return preco.doubleValue();
        }
        @Override
        public String toString()
        {
            return String.format("Veículo: %s, marca: %s, preco: R$ %.2f}",
                    this.getModelo(),
                    this.getMarca(),
                    this.getPreco().doubleValue());
        }
}
