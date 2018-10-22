/**
 * Painel inicial da aplicação, com os botões
 * para cada uma das funcionalidades principais do sistema.
 *
 * @author cam
 * @version 20181006
 */

package view;

import javax.swing.*;
import java.awt.*;

public class InitialView extends JFrame {
    private JPanel initialPanel;
    private JButton visualizarSociosBtn;
    private JTextField title;
    private JButton novoSocioBtn;
    private JButton pagarQuotaBtn;
    private JLabel photoLabel;

    public InitialView() {
        setSize(800,400);
        setContentPane(initialPanel);
        setLocationRelativeTo(null);
    }

    public JTextField getTextFieldTitle() {
        Font font1 = new Font("", Font.BOLD, 19);
        title.setBackground(new java.awt.Color(238, 238, 238));
        title.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(font1);

        return title;
    }

    public JLabel getPhotoLabel(){
        return photoLabel;
    }

    public JButton getVisualizarSociosBtn() {
        return visualizarSociosBtn;
    }

    public JButton getNovoSocioBtn() {
        return novoSocioBtn;
    }

    public JButton getPagarQuotaBtn() {
        return pagarQuotaBtn;
    }
}
