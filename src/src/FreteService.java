public class FreteService {

    public double calcularFrete(double valorCompra, double pesoKg, String cep) {
        // regra frete grátis
        if (valorCompra >= 300.00) {
            return 0.0;
        }

        // Regra 2:
        double freteBase;
        if (pesoKg <= 5.0) {
            freteBase = 20.00;
        } else if (pesoKg <= 20.0) {
            freteBase = 35.00;
        } else {
            freteBase = 60.00;
        }

        // Regra 3:
        double adicional = 0.0;
        if (cep != null && cep.startsWith("8")) {
            adicional = 15.00;
        }

        double frete = freteBase + adicional;

        // Regra 4:
        frete = Math.round(frete * 100.0) / 100.0;
        return frete;
    }
}