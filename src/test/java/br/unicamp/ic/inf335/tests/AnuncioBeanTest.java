package br.unicamp.ic.inf335.tests;

import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnuncioBeanTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValorTest() throws MalformedURLException {
        ProdutoBean produto1 = new ProdutoBean("CD00001", "Onix 2017", "Preto, Automatico", 1000.0, "Poucos riscos, estado de novo.");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://site.com/foto2.jpg"));
        AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 0.1);

        assertEquals(900,anuncio1.getValor());
    }
}