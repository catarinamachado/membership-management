/**
 * Formulário para a criação de um novo sócio.
 *
 * @author cam
 * @version 20181006
 */

package view;

import javax.swing.*;

public class NovoSocioView extends JFrame {
    private JPanel novoSocioPanel;
    private JTextField numberText, nomeText, cursoText, anoText, moradaText;
    private JTextField numberField, nomeField, cursoField, anoField, moradaField;
    private JButton fecharBtn, guardarBtn;


    public NovoSocioView() {
        setSize(500,400);
        setContentPane(novoSocioPanel);
        setLocationRelativeTo(null);
    }

    public JTextField getNumberText() {
        numberText.setBackground(new java.awt.Color(238, 238, 238));
        numberText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        numberText.setHorizontalAlignment(JTextField.RIGHT);

        return numberText;
    }

    public JTextField getNomeText() {
        nomeText.setBackground(new java.awt.Color(238, 238, 238));
        nomeText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nomeText.setHorizontalAlignment(JTextField.RIGHT);

        return nomeText;
    }

    public JTextField getCursoText() {
        cursoText.setBackground(new java.awt.Color(238, 238, 238));
        cursoText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        cursoText.setHorizontalAlignment(JTextField.RIGHT);

        return cursoText;
    }

    public JTextField getAnoText() {
        anoText.setBackground(new java.awt.Color(238, 238, 238));
        anoText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        anoText.setHorizontalAlignment(JTextField.RIGHT);

        return anoText;
    }

    public JTextField getMoradaText() {
        moradaText.setBackground(new java.awt.Color(238, 238, 238));
        moradaText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        moradaText.setHorizontalAlignment(JTextField.RIGHT);

        return moradaText;
    }

    public JTextField getNumberField() {
        return numberField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getCursoField() {
        return cursoField;
    }

    public JTextField getAnoField() {
        return anoField;
    }

    public JTextField getMoradaField() {
        return moradaField;
    }

    public JButton getFecharBtn() {
        return fecharBtn;
    }

    public JButton getGuardarBtn() {
        return guardarBtn;
    }

}
