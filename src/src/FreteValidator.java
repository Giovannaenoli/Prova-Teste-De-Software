import java.util.*;

public class FreteValidator {

    public List<String> validarPedidoFrete(double valorCompra,
                                           double pesoKg,
                                           Dimensoes dimensoes,
                                           String cep) {
        List<String> erros = new ArrayList<>();

        // Valor da compra
        if (valorCompra < 0) {
            erros.add("Valor da compra inválido");
        }

        // Peso
        if (pesoKg <= 0) {
            erros.add("Peso inválido");
        } else if (pesoKg > 30.0) {
            erros.add("Peso acima do limite");
        }

        // Dimensões (verifica nulls defensivamente)
        if (dimensoes == null) {
            // Se não vier dimensões, consideramos que todas estão fora do limite
            erros.add("Comprimento acima do limite");
            erros.add("Largura acima do limite");
            erros.add("Altura acima do limite");
        } else {
            if (dimensoes.getComprimento() > 1.00) {
                erros.add("Comprimento acima do limite");
            }
            if (dimensoes.getLargura() > 0.80) {
                erros.add("Largura acima do limite");
            }
            if (dimensoes.getAltura() > 0.60) {
                erros.add("Altura acima do limite");
            }
        }

        // CEP: deve ter 8 caracteres numéricos
        if (cep == null) {
            erros.add("CEP deve ter 8 dígitos");
            erros.add("CEP deve conter apenas dígitos");
        } else {
            String somenteCep = cep.trim();
            if (somenteCep.length() != 8) {
                erros.add("CEP deve ter 8 dígitos");
            }
            if (!somenteCep.matches("\\d{8}")) {
                erros.add("CEP deve conter apenas dígitos");
            }
        }

        return erros;
    }
}
