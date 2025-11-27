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
    }

