import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FreteServiceTest {

    @Test
    void CF01_freteGratis_valorExato300() {
        FreteService service = new FreteService();
        double frete = service.calcularFrete(300.00, 10.0, "86020000");
        assertEquals(0.00, frete, 0.001);
    }

    @Test
    void CF02_freteGratis_valorAcima() {
        FreteService service = new FreteService();
        double frete = service.calcularFrete(350.00, 25.0, "01001000");
        assertEquals(0.00, frete, 0.001);
    }

    @Test
    void CF03_ate5kg_regiaoNormal() {
        FreteService service = new FreteService();
        double frete = service.calcularFrete(100.00, 5.0, "01001000");
        assertEquals(20.00, frete, 0.001);
    }

    @Test
    void CF04_entre5e20_regiaoNormal() {
        FreteService service = new FreteService();
        double frete = service.calcularFrete(150.00, 10.0, "01001000");
        assertEquals(35.00, frete, 0.001);
    }

    @Test
    void CF05_acima20_regiaoNormal() {
        FreteService service = new FreteService();
        double frete = service.calcularFrete(200.00, 25.0, "01001000");
        assertEquals(60.00, frete, 0.001);
    }
}
