import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FreteServiceTest {

    @Test
    void CF01_freteGratis_valorExato300() {
        FreteService service = new FreteService();
        double frete = service.calcularFrete(300.00, 10.0, "86020000");
        assertEquals(0.00, frete, 0.001);
    }
}
