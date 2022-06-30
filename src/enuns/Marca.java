package enuns;

public enum Marca {
        FORD("Ford"),
        FIAT("Fiat"),
        CHEVROLET("Chevrolet"),
        TOYOTA("Toyota"),
        RENAULT("Renault");

        private String nome;
        Marca(String nome)
        {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

}
