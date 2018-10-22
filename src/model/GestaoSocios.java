/**
 * Principal classe da aplicação.
 * Armazena os socios do sistema e consequentes funcionalidades
 * (criar novos socios, pagar quotas e alterar informação dos sócios).
 *
 * @author cam
 * @version 20181006
 */

package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


public class GestaoSocios extends Observable {
    private Map<Integer, Socio> socios;

    /**
     * Construtor por omissão do sistema.
     */
    public GestaoSocios() {
        this.socios = new HashMap<>();
    }

    /**
     * Construtor parametrizado.
     */
    public GestaoSocios(Map<Integer, Socio> socios) {
        this.socios = socios;
    }

    /**
     * Devolve uma HashMap com todos os sócios.
     */
    public Map<Integer, Socio> getSocios() {
        return socios;
    }

    /**
     * Devolve um apontador para um determinado sócio (caso exista).
     */
    public Socio getSocio(int numero) throws SocioNullException {
        Socio s = this.socios.get(numero);

        if(s == null)
            throw new SocioNullException("Não existem nenhum sócio com o nº" + numero + ".");

        return s.clone();
    }

    /**
     * Adiciona um novo sócio ao sistema (caso ainda não existe nenhum sócio
     * com o número passado como parâmetro).
     */
    public void addSocio(int numberValue, String nameValue, String cursoValue, int anoValue, String moradaValue, ArrayList quotas) throws SocioNullException {
        Socio s = this.socios.get(numberValue);

        if(s == null){
            Socio novoS = new Socio(numberValue, nameValue, cursoValue, anoValue, moradaValue, quotas);
            this.socios.put(numberValue, novoS.clone());

            this.setChanged();
            this.notifyObservers();
        }
        else
            throw new SocioNullException("Já existe um sócio com o nº" + numberValue + ".");
    }

    /**
     * Altera a informação relativa a um determinado sócio.
     */
    public void alterarInfoSocio(int socioNr, String name, String curso, int anoValue, String moradaValue) {
        Socio s = this.socios.get(socioNr);

        s.setNome(name);
        s.setCurso(curso);
        s.setAno(anoValue);
        s.setMorada(moradaValue);

        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Regista o pagamento de uma quota, de um determinado valor, efetuada por
     * um determinado sócio.
     */
    public void pagarQuota(int numero, Double valor) throws SocioNullException {
        Socio s = this.socios.get(numero);

        if(s == null)
            throw new SocioNullException("Não existem nenhum sócio com o nº" + numero + ".");

        Quota q = new Quota(valor, LocalDate.now());
        s.addQuota(q);
    }
}
