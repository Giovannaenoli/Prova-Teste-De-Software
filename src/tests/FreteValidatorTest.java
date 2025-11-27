import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

    class FreteValidatorTest {

        @Test
        void VF01_pedidoValido_semErros() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 10.0, d, "86020000");
            assertTrue(erros.isEmpty());
        }

        @Test
        void VF02_pesoZero_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 0.0, d, "86020000");
            assertEquals(1, erros.size());
            assertTrue(erros.contains("Peso inválido"));
        }

        @Test
        void VF03_pesoAcimaLimite_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 35.0, d, "86020000");
            assertEquals(1, erros.size());
            assertTrue(erros.contains("Peso acima do limite"));
        }

        @Test
        void VF04_comprimentoAcima_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(1.10, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 10.0, d, "86020000");
            assertEquals(1, erros.size());
            assertTrue(erros.contains("Comprimento acima do limite"));
        }

        @Test
        void VF05_larguraAcima_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.90, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 10.0, d, "86020000");
            assertEquals(1, erros.size());
            assertTrue(erros.contains("Largura acima do limite"));
        }

        @Test
        void VF06_alturaAcima_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.70);
            List<String> erros = validator.validarPedidoFrete(100.00, 10.0, d, "86020000");
            assertEquals(1, erros.size());
            assertTrue(erros.contains("Altura acima do limite"));
        }

        @Test
        void VF07_valorNegativo_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(-10.00, 10.0, d, "86020000");
            assertEquals(1, erros.size());
            assertTrue(erros.contains("Valor da compra inválido"));
        }

        @Test
        void VF08_cepTamanhoInvalido_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 10.0, d, "8602000"); // 7 dígitos
            assertTrue(erros.contains("CEP deve ter 8 dígitos"));
        }

        @Test
        void VF09_cepComLetra_retornaErro() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(0.50, 0.40, 0.30);
            List<String> erros = validator.validarPedidoFrete(100.00, 10.0, d, "86A20000");
            assertTrue(erros.contains("CEP deve conter apenas dígitos"));
        }

        @Test
        void VF10_variosErros_mesmoTempo() {
            FreteValidator validator = new FreteValidator();
            Dimensoes d = new Dimensoes(1.20, 0.90, 0.80);
            List<String> erros = validator.validarPedidoFrete(-5.00, 40.0, d, "8X0200"); // cep curto e com letra

            assertTrue(erros.size() >= 4);
            assertTrue(erros.contains("Valor da compra inválido"));
            assertTrue(erros.contains("Peso acima do limite"));
            assertTrue(erros.contains("Comprimento acima do limite"));
            assertTrue(erros.contains("Largura acima do limite"));
            assertTrue(erros.contains("Altura acima do limite"));
            assertTrue(erros.contains("CEP deve ter 8 dígitos") || erros.contains("CEP deve conter apenas dígitos"));
        }
    }

