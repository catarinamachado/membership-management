/**
 * Apresenta os detalhes relativos a um determinado sócio.
 *
 * @author cam
 * @version 20181006
 */

package view;

import javax.swing.*;

public class SocioDetailsView extends JFrame {
    private JPanel detailsPainel;
    private JTextField numberTextD, nameTextD, anoTextD, cursoTextD, moradaTextD;
    private JTextField nameFieldD, numberFieldD, cursoFieldD, anoFieldD, moradaFieldD;
    private JButton quotasPagasBtn, alterarDadosBtn;

    public SocioDetailsView() {
        setSize(500,400);
        setContentPane(detailsPainel);
        setLocationRelativeTo(null);
    }

    public JTextField getNumberTextD() {
        numberTextD.setBackground(new java.awt.Color(238, 238, 238));
        numberTextD.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        numberTextD.setHorizontalAlignment(JTextField.RIGHT);

        return numberTextD;
    }

    public JTextField getNameTextD() {
        nameTextD.setBackground(new java.awt.Color(238, 238, 238));
        nameTextD.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nameTextD.setHorizontalAlignment(JTextField.RIGHT);

        return nameTextD;
    }

    public JTextField getCursoTextD() {
        cursoTextD.setBackground(new java.awt.Color(238, 238, 238));
        cursoTextD.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        cursoTextD.setHorizontalAlignment(JTextField.RIGHT);

        return cursoTextD;
    }

    public JTextField getAnoTextD() {
        anoTextD.setBackground(new java.awt.Color(238, 238, 238));
        anoTextD.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        anoTextD.setHorizontalAlignment(JTextField.RIGHT);

        return anoTextD;
    }

    public JTextField getMoradaTextD() {
        moradaTextD.setBackground(new java.awt.Color(238, 238, 238));
        moradaTextD.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        moradaTextD.setHorizontalAlignment(JTextField.RIGHT);

        return moradaTextD;
    }

    public JTextField getNumberFieldD() {
        numberFieldD.setBackground(new java.awt.Color(238, 238, 238));
        numberFieldD.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        return numberFieldD;
    }

    public JTextField getNameFieldD() {
        return nameFieldD;
    }

    public JTextField getCursoFieldD() {
        return cursoFieldD;
    }

    public JTextField getAnoFieldD() {
        return anoFieldD;
    }

    public JTextField getMoradaFieldD() {
        return moradaFieldD;
    }

    public JButton getQuotasPagasBtn() {
        return quotasPagasBtn;
    }

    public JButton getAlterarDadosBtn() {
        return alterarDadosBtn;
    }

    /**
     * Preenche o formulário com os detalhes de um determinado sócio.
     */
    public void fillDetails(int number, String name, String curso, int ano, String morada){
        numberFieldD.setText(Integer.toString(number));
        nameFieldD.setText(name);
        cursoFieldD.setText(curso);
        anoFieldD.setText(Integer.toString(ano));
        moradaFieldD.setText(morada);
    }
}
