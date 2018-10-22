/**
 * Classe Socio, entidade do sistema.
 *
 * @author cam
 * @version 20181006
 */

package model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Socio {
    private int numero;
    private String nome;
    private String curso;
    private int ano;
    private String morada;
    private List<Quota> quotas;

    public Socio() {
        this.numero = 0;
        this.nome = "";
        this.curso = "";
        this.ano = 0;
        this.morada = "";
        this.quotas = new ArrayList<>();
    }

    public Socio(Socio s) {
        this.numero = s.getNumero();
        this.nome = s.getNome();
        this.curso = s.getCurso();
        this.ano = s.getAno();
        this.morada = s.getMorada();
        this.quotas = s.getQuotas();
    }

    public Socio(int numero, String nome, String curso, int ano, String morada, ArrayList<Quota> quotas) {
        this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.ano = ano;
        this.morada = morada;
        this.quotas = quotas;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getAno() {
        return ano;
    }

    public String getMorada() {
        return morada;
    }


    public ArrayList<Quota> getQuotas() {
        return quotas.stream().
                collect(Collectors.toCollection(ArrayList::new));
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setQuotas(ArrayList<Quota> quotas) {
        this.quotas = quotas.stream().
                collect(Collectors.toCollection(ArrayList::new));
    }

    public String toString() {
        return "Socio {" +
                "numero= " + numero +
                ", nome= '" + nome + '\'' +
                ", curso= '" + curso + '\'' +
                ", ano= '" + ano + '\'' +
                ", morada= '" + morada + '\'' +
                ", quotas= '" + quotas + '\'' +
                '}';
    }

    public Socio clone() {
        return new Socio(this);
    }


    /**
     * Regista o pagamento de uma quota.
     */
    public void addQuota(Quota q){
        this.quotas.add(q.clone());
    }
}
