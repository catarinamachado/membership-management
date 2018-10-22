/**
 * Classe Quota, armazena a informacao útil relativa a
 * uma quota (nomeadamente data e valor).
 *
 * @author cam
 * @version 20181006
 */

package model;

import java.time.LocalDate;

public class Quota {
    private double valor;
    private LocalDate data;

    public Quota() {
        this.valor = 0;
        this.data = LocalDate.MIN;
    }

    public Quota(double valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    public Quota(Quota q) {
        this.valor = q.getValor();
        this.data = q.getData();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Quota clone() {
        return new Quota(this);
    }
}
