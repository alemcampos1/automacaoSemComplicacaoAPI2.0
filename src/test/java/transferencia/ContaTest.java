package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "12345678900", "1111111");
        silvioSantos = new Cliente("Silvio Santos", "15487222", "1782154");

        contaXuxa = new Conta("0025", "2254", 2500.00, xuxa);
        contaSilvio = new Conta("0026", "2251", 3500.00, silvioSantos);
    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());
    }

    @Test
    public void realizarTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);

    }

    @Test
    public void validarProprietario(){

        assertEquals(xuxa, contaXuxa.getProprietario());
    }

    @Test
    public void validarAgencia(){
        assertEquals("0025", contaXuxa.getAgencia());
        assertEquals("0026", contaSilvio.getAgencia());

    }

    @Test
    public void validarConta(){

        assertEquals("2254", contaXuxa.getNumeroConta());
        assertEquals("2251", contaSilvio.getNumeroConta());
    }

    @Test
    public void validarNome(){
        assertEquals("Xuxa", xuxa.getNome());
        assertEquals("Silvio Santos", silvioSantos.getNome());
    }

    @Test
    public void validarCPF(){
        assertEquals("12345678900", xuxa.getCpf());
        assertEquals("15487222", silvioSantos.getCpf());
    }

    @Test void validarRG(){
        assertEquals("1111111", xuxa.getRg());
        assertEquals("1782154", silvioSantos.getRg());
    }
}