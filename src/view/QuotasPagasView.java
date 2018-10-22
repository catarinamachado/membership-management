/**
 * Responsável por mostrar ao utilizador uma tabela com todas as quotas
 * pagas por ele.
 *
 * @author cam
 * @version 20181006
 */

package view;

import javax.swing.*;
import java.awt.*;

public class QuotasPagasView extends JFrame {
    private JPanel quotasPagasPanel;
    private JScrollPane barra;

    public QuotasPagasView() {
        setSize(700,400);
        setLocationRelativeTo(null);

        quotasPagasPanel = new JPanel();
        quotasPagasPanel.setLayout(new GridLayout(1, 1));
    }

    /**
     * Cria a tabela com as informações relativas às quotas do determinado sócio.
     */
    public void createTableQuotas(JTable quotasTable) {
        quotasTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        quotasTable.setDefaultEditor(Object.class, null);

        barra = new JScrollPane(quotasTable);
        quotasPagasPanel.add(barra);

        getContentPane().add(quotasPagasPanel);
    }
}
