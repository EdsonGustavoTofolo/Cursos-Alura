package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropondoLancesSteps {

    private Lance lance;
    private Leilao leilao;
    private Lance lance10;
    private Lance lance15;
    private List<Lance> lances;

    @Before
    public void setup() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("Tablet xpto");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        this.lance = new Lance(new Usuario("fulano"), BigDecimal.TEN);
    }

    @Quando("propoe o leilao")
    public void quando_propoe_o_leilao() {
        this.leilao.propoe(this.lance);
    }

    @Entao("o lance eh aceito")
    public void então_o_lance_eh_aceito() {
        Assertions.assertEquals(1, this.leilao.getLances().size());
        Assertions.assertEquals(BigDecimal.TEN, this.leilao.getLances().get(0).getValor());
    }

    @Dado("varios lances validos")
    public void varios_lances_validos() {
        Lance lance1 = new Lance(new Usuario("fulano"), BigDecimal.TEN);
        Lance lance2 = new Lance(new Usuario("ciclano"), new BigDecimal("15"));
        this.lances.add(lance1);
        this.lances.add(lance2);
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        this.lances.forEach(l -> leilao.propoe(l));
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assertions.assertEquals(2, this.leilao.getLances().size());
        Assertions.assertEquals(BigDecimal.TEN, this.leilao.getLances().get(0).getValor());
        Assertions.assertEquals(new BigDecimal("15"), this.leilao.getLances().get(1).getValor());
    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario(Double valor, String usuario) {
        Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
        lances.add(lance);
    }

    @Quando("propoe dois lances ao leilao")
    public void propoe_dois_lances_ao_leilao() {
        this.lances.forEach(l -> leilao.propoe(l));
    }

    @Entao("os dois lances sao aceitos")
    public void os_dois_lances_sao_aceitos() {
        Assertions.assertEquals(this.lances.size(), this.leilao.getLances().size());
        Assertions.assertEquals(this.lances.get(0).getValor(), this.leilao.getLances().get(0).getValor());
        Assertions.assertEquals(this.lances.get(1).getValor(), this.leilao.getLances().get(1).getValor());
    }

    @Dado("um lance invalido de {double} reais e do usuario {string}")
    public void um_lance_invalido_de_reais_e_do_usuario(Double valor, String usuario) {
        this.lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
    }

    @Entao("o lance nao eh aceito")
    public void o_lance_nao_eh_aceito() {
        Assertions.assertEquals(0, this.leilao.getLances().size());
    }

    @Entao("o segundo lance nao eh aceito")
    public void o_segundo_lance_nao_eh_aceito() {
        Assertions.assertEquals(2, leilao.getLances().size());
        Assertions.assertEquals(lances.get(0).getValor(), leilao.getLances().get(0).getValor());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        for (Map<String, String> map : maps) {
            Lance lance = new Lance(new Usuario(map.get("nomeUsuario")), new BigDecimal(map.get("valor")));
            lances.add(lance);
        }
    }
}
