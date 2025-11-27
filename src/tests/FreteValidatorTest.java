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
    }

