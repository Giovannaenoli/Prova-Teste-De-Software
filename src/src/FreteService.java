public class FreteService {

    public double calcularFrete(double valorCompra, double pesoKg, String cep) {
        // regra frete grátis
        if (valorCompra >= 300.00) {
            return 0.0;
        }
        // retorna frete base mínimo (até 5kg)
        return 20.00;
    }
}