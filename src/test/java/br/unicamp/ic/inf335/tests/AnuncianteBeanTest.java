package br.unicamp.ic.inf335.tests;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncianteBeanTest {

    private AnuncioBean anuncio1;
    private AnuncioBean anuncio2;
    private AnuncioBean anuncio3;

    @BeforeEach
    void setUp() throws MalformedURLException {
        ProdutoBean produto1 = new ProdutoBean("CD00001", "Onix 2017", "Preto, Automatico", 1000.0, "Poucos riscos, estado de novo.");
        ProdutoBean produto2 = new ProdutoBean("CD00002", "Celta 2015", "Branco, Direção Hidraulica", 1500.0, "Kilometragem alta.");
        ProdutoBean produto3 = new ProdutoBean("CD00003", "Corsa 2015", "Prata, Ar condicionado", 2000.0, "Manutenção em dia.");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://site.com/foto1.jpg"));
        fotos.add(new URL("https://site.com/foto2.jpg"));
        this.anuncio1 = new AnuncioBean(produto1, fotos, 0.1);
        this.anuncio2 = new AnuncioBean(produto2, fotos, 0.2);
        this.anuncio3 = new AnuncioBean(produto3, fotos, 0.3);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void addAnuncioTest() throws MalformedURLException {

        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(this.anuncio1);

        assertEquals(anuncios.get(0),this.anuncio1);
        assertEquals(anuncios.size(),1);
    }

    @Test
    void removeAnuncioTest() throws MalformedURLException {

        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(this.anuncio1);
        anuncios.add(this.anuncio2);

        assertEquals(anuncios.get(0),anuncio1);
        assertEquals(anuncios.get(1),anuncio2);
        assertEquals(anuncios.size(),2);

        anuncios.remove(anuncio1);

        assertEquals(anuncios.get(0),anuncio2);
        assertEquals(anuncios.size(),1);
    }

    @Test
    void valorMedioAnunciosTest() throws MalformedURLException {

        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(this.anuncio1);
        anuncios.add(this.anuncio2);
        anuncios.add(this.anuncio3);

        AnuncianteBean anunciante = new AnuncianteBean("Concessionária Silva", "123.456.789-00", anuncios);
        Double valorMedio = Math.floor(anunciante.valorMedioAnuncios());

        assertEquals(1166, valorMedio);
    }
}
