/**
 * Responsável por mostrar um formulário que permite
 * que um sócio pague uma quota de um determinado valor
 *
 * @author cam
 * @version 20181006
 */

package view;

import javax.swing.*;

public class PagarQuotaView extends JFrame {
    private JPanel pagarQuotaPanel;
    private JTextField pagarQuotaTextField;
    private JTextField numberTextQ, valorTextQ;
    private JTextField valorFieldQ,numberFieldQ;
    private JButton pagarBtn;


    public PagarQuotaView() {
        setSize(500,400);
        setContentPane(pagarQuotaPanel);
        setLocationRelativeTo(null);
    }

    public JTextField getPagarQuotaTextField() {
        pagarQuotaTextField.setBackground(new java.awt.Color(238, 238, 238));
        pagarQuotaTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pagarQuotaTextField.setHorizontalAlignment(JTextField.CENTER);

        return pagarQuotaTextField;
    }

    public JTextField getNumberTextQ() {
        numberTextQ.setBackground(new java.awt.Color(238, 238, 238));
        numberTextQ.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        numberTextQ.setHorizontalAlignment(JTextField.RIGHT);

        return numberTextQ;
    }

    public JTextField getValorTextQ() {
        valorTextQ.setBackground(new java.awt.Color(238, 238, 238));
        valorTextQ.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        valorTextQ.setHorizontalAlignment(JTextField.RIGHT);

        return valorTextQ;
    }

    public JTextField getValorFieldQ() {
        return valorFieldQ;
    }

    public JTextField getNumberFieldQ() {
        return numberFieldQ;
    }

    public JButton getPagarBtn() {
        return pagarBtn;
    }
}
