/**
 * Encarregue de mostrar uma tabela com todos os sócios.
 *
 * @author cam
 * @version 20181006
 */


package view;

import javax.swing.*;
import java.awt.*;

public class VisualizarSociosView extends JFrame {
    private JPanel visualizarPanel;
    private JScrollPane barra;


    public VisualizarSociosView() {
        setSize(700,400);
        setLocationRelativeTo(null);

        visualizarPanel = new JPanel();
        visualizarPanel.setLayout(new GridLayout(1, 1));
    }

    /**
     * Cria a tabela com as informações relativas a todos os sócios.
     */
    public void createTableSocios(JTable sociosTable){
        sociosTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        sociosTable.setDefaultEditor(Object.class, null);

        barra = new JScrollPane(sociosTable);
        visualizarPanel.add(barra);

        getContentPane().add(visualizarPanel);
    }
}
