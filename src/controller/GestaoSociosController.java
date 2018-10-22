/**
 * Controller da aplicação.
 * Coordena a troca de informação entre a interface gráfica e a camada lógica.
 *
 * @author cam
 * @version 20181006
 */

package controller;

import model.GestaoSocios;
import model.Quota;
import model.Socio;
import model.SocioNullException;
import view.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GestaoSociosController implements Observer {
    private GestaoSocios osSocios;
    private DefaultTableModel modelTable = new DefaultTableModel();
    private DefaultTableModel modelTableQuotas = new DefaultTableModel();
    private JTable sociosTable = new JTable(modelTable);
    private JTable quotasTable = new JTable(modelTableQuotas);

    //View inicial
    private InitialView initialView;
    private JTextField title;
    private JLabel photoLabel;
    private JButton visualizarSociosBtn, novoSocioBtn, pagarQuotaBtn;

    //View Visualizar Sócios
    private VisualizarSociosView visualizarSociosView;
    private JPanel visualizarPanel;

    //View Detalhes Sócio
    private SocioDetailsView socioDetailsView;
    private JTextField numberTextD, nameTextD, anoTextD, cursoTextD, moradaTextD;
    private JTextField nameFieldD, numberFieldD, cursoFieldD, anoFieldD, moradaFieldD;
    private JButton quotasPagasBtn, alterarDadosBtn;

    //View Detalhes Sócio Quotas
    private QuotasPagasView quotasPagasView;

    //View Novo Sócio
    private NovoSocioView novoSocioView;
    private JTextField numberText, nomeText, cursoText, anoText, moradaText;
    private JTextField numberField, nomeField, cursoField, anoField, moradaField;
    private JButton fecharBtn, guardarBtn;

    //View Pagar Quota
    private PagarQuotaView pagarQuotaView;
    private JTextField pagarQuotaTextField, numberTextQ, valorTextQ, valorFieldQ, numberFieldQ;
    private JButton pagarBtn;

    public GestaoSociosController() {
        initComponents();
        initListeners();

        this.osSocios.addObserver(this);
    }

    public void showMainWindow() {
        initialView.setVisible(true);
    }

    private void initComponents() {
        osSocios = new GestaoSocios();

        //View inicial
        initialView = new InitialView();
        title = initialView.getTextFieldTitle();
        photoLabel = initialView.getPhotoLabel();
        visualizarSociosBtn = initialView.getVisualizarSociosBtn();
        novoSocioBtn = initialView.getNovoSocioBtn();
        pagarQuotaBtn = initialView.getPagarQuotaBtn();

        //View Visualizar Sócios
        visualizarSociosView = new VisualizarSociosView();
        modelTable.addColumn("Número");
        modelTable.addColumn("Nome");
        modelTable.addColumn("Curso");
        modelTable.addColumn("Ano");
        modelTable.addColumn("Morada");
        visualizarSociosView.createTableSocios(sociosTable);
        this.seedApplicationExample();
        this.seedTableSocios();

        //View Detalhes Sócio
        socioDetailsView = new SocioDetailsView();
        numberTextD = socioDetailsView.getNumberTextD();
        nameTextD = socioDetailsView.getNameTextD();
        cursoTextD = socioDetailsView.getCursoTextD();
        anoTextD = socioDetailsView.getAnoTextD();
        moradaTextD = socioDetailsView.getMoradaTextD();
        numberFieldD = socioDetailsView.getNumberFieldD();
        nameFieldD = socioDetailsView.getNameFieldD();
        cursoFieldD = socioDetailsView.getCursoFieldD();
        anoFieldD = socioDetailsView.getAnoFieldD();
        moradaFieldD = socioDetailsView.getMoradaFieldD();
        quotasPagasBtn = socioDetailsView.getQuotasPagasBtn();
        alterarDadosBtn = socioDetailsView.getAlterarDadosBtn();

        //View Detalhes Sócio Quotas
        quotasPagasView = new QuotasPagasView();
        modelTableQuotas.addColumn("Data");
        modelTableQuotas.addColumn("Valor");
        quotasPagasView.createTableQuotas(quotasTable);

        //View Novo Sócio
        novoSocioView = new NovoSocioView();
        numberText = novoSocioView.getNumberText();
        nomeText = novoSocioView.getNomeText();
        cursoText = novoSocioView.getCursoText();
        anoText = novoSocioView.getAnoText();
        moradaText = novoSocioView.getMoradaText();
        numberField = novoSocioView.getNumberField();
        nomeField = novoSocioView.getNomeField();
        cursoField = novoSocioView.getCursoField();
        anoField = novoSocioView.getAnoField();
        moradaField = novoSocioView.getMoradaField();
        fecharBtn = novoSocioView.getFecharBtn();
        guardarBtn = novoSocioView.getGuardarBtn();

        //View Pagar Quota
        pagarQuotaView = new PagarQuotaView();
        pagarQuotaTextField = pagarQuotaView.getPagarQuotaTextField();
        numberTextQ = pagarQuotaView.getNumberTextQ();
        valorTextQ = pagarQuotaView.getValorTextQ();
        numberFieldQ = pagarQuotaView.getNumberFieldQ();
        valorFieldQ = pagarQuotaView.getValorFieldQ();
        pagarBtn = pagarQuotaView.getPagarBtn();
    }

    private void initListeners() {
        visualizarSociosBtn.addActionListener(new VisualizarSociosBtnListener());
        sociosTable.getSelectionModel().addListSelectionListener(new VisualizarDetalheSocioListener());
        novoSocioBtn.addActionListener(new NovoSocioBtnListener());
        guardarBtn.addActionListener(new GuardarBtnListener());
        fecharBtn.addActionListener(new FecharBtnListener());
        alterarDadosBtn.addActionListener(new AlterarDadosBtnListener());
        quotasPagasBtn.addActionListener(new QuotasPagasBtnListener());
        pagarQuotaBtn.addActionListener(new PagarQuotaBtnListener());
        pagarBtn.addActionListener(new PagarBtnListener());
    }

    /**
     * Apresenta a tabela com a informação de todos os sócios do sistema.
     */
    private class VisualizarSociosBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            visualizarSociosView.setVisible(true);
        }
    }

    /**
     * Apresenta os detalhes de um determinado sócio.
     */
    private class VisualizarDetalheSocioListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            visualizarSociosView.setVisible(false);

            int lineNr = sociosTable.getSelectedRow();
            if(lineNr >= 0) {
                String socioNr = sociosTable.getModel().getValueAt(lineNr, 0).toString();

                socioDetailsView.setVisible(true);

                Socio s = osSocios.getSocios().get(Integer.parseInt(socioNr));
                socioDetailsView.fillDetails(s.getNumero(), s.getNome(), s.getCurso(), s.getAno(), s.getMorada());
            }
        }
    }

    /**
     * Apresenta o formulário de criação de um novo sócio.
     */
    private class NovoSocioBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            visualizarSociosView.setVisible(false);

            novoSocioView.setVisible(true);
        }
    }

    /**
     * Responsável por guardar as informações do novo sócio.
     */
    private class GuardarBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int numberValue = Integer.parseInt(numberField.getText());
                String nameValue = nomeField.getText();
                String cursoValue = cursoField.getText();
                int anoValue = Integer.parseInt(anoField.getText());
                String moradaValue = moradaField.getText();

                osSocios.addSocio(numberValue, nameValue, cursoValue, anoValue, moradaValue, new ArrayList<>());

                JOptionPane.showMessageDialog(initialView,
                        "Novo sócio adicionado com sucesso.",
                        "",
                        JOptionPane.PLAIN_MESSAGE);
            }
            catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(novoSocioView,
                        "O nº de sócio e o ano têm que ser caracteres númericos.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

            catch (SocioNullException a) {
                JOptionPane.showMessageDialog(novoSocioView,
                        a.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

            numberField.setText("");
            nomeField.setText("");
            cursoField.setText("");
            anoField.setText("");
            moradaField.setText("");
        }
    }

    /**
     * Fecha o formulário de criação de um novo sócio.
     */
    private class FecharBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            novoSocioView.setVisible(false);
        }
    }

    /**
     * Altera os dados pessoais de um determinado sócio.
     */
    private class AlterarDadosBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            visualizarSociosView.setVisible(false);

            try {
                int socioNr = Integer.parseInt(numberFieldD.getText());
                String name = nameFieldD.getText();
                String curso = cursoFieldD.getText();
                int anoValue = Integer.parseInt(anoFieldD.getText());
                String moradaValue = moradaFieldD.getText();

                osSocios.alterarInfoSocio(socioNr, name, curso, anoValue, moradaValue);

                socioDetailsView.setVisible(false);

                JOptionPane.showMessageDialog(initialView,
                        "Os dados do sócio nº" + socioNr + " (" + name + ") foram alterados com sucesso.",
                        "",
                        JOptionPane.PLAIN_MESSAGE);
            }

            catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(novoSocioView,
                        "O ano têm que ser caracter númerico.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Apresenta uma tabela com todas as quotas outrora pagas pelo sócio.
     */
    private class QuotasPagasBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int socioNr = Integer.parseInt(numberFieldD.getText());

            quotasPagasView.setVisible(true);
            seedTableQuotas(socioNr);
        }
    }

    /**
     * Apresenta o formulário que permite que seja efetuado um novo
     * pagamento de uma quota.
     */
    private class PagarQuotaBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            pagarQuotaView.setVisible(true);
        }
    }

    /**
     * Responsável por pagar efetivamente a quota (guardar no sistema a
     * informação de que uma nova quota foi paga).
     */
    private class PagarBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int socioNr = Integer.parseInt(numberFieldQ.getText());
                double valorQuota = Double.parseDouble(valorFieldQ.getText());
                osSocios.pagarQuota(socioNr, valorQuota);

                JOptionPane.showMessageDialog(initialView,
                        "Quota paga no valor de " + valorQuota + "€ pelo/a " + osSocios.getSocio(socioNr).getNome() + ".",
                        "",
                        JOptionPane.PLAIN_MESSAGE);

                numberFieldQ.setText("");
                valorFieldQ.setText("");
            }

            catch (SocioNullException a) {
                JOptionPane.showMessageDialog(initialView,
                        a.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(novoSocioView,
                        "O valor da quota tem que ser um caracter númerico e ambos os campos têm que estar preenchidos.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Preenche a tabela com a informação de todos os sócios.
     */
    public void seedTableSocios() {
        modelTable.setNumRows(0);

        for(Socio socio : osSocios.getSocios().values()) {
            modelTable.addRow(new Object[]{socio.getNumero(), socio.getNome(),
                    socio.getCurso(), socio.getAno(), socio.getMorada()});
        }
    }

    /**
     * Cria a tabela com todas as quotas pagas por um determinado sócio.
     */
    public void seedTableQuotas(int socioNr) {
        modelTableQuotas.setNumRows(0);

        Socio socio = osSocios.getSocios().get(socioNr);

        for(Quota q : socio.getQuotas()) {
            modelTableQuotas.addRow(new Object[]{q.getData(), q.getValor()});
        }
    }

    /**
     * Alimenta a aplicação com três sócios, meramente ilustrativos.
     */
    public void seedApplicationExample() {
        ArrayList<Quota> quotasExample = new ArrayList<>();
        quotasExample.add(new Quota(10, LocalDate.now()));
        quotasExample.add(new Quota(15, LocalDate.now()));

        try {
            this.osSocios.addSocio(1776, "Catarina", "MiEI", 3, "Braga", quotasExample);
            this.osSocios.addSocio(1970, "Eva", "MiEI", 2, "Braga", new ArrayList<>());
            this.osSocios.addSocio(1890, "Lucas", "MiEI", 4, "Braga", new ArrayList<>());
        }
        catch (SocioNullException a) {
            JOptionPane.showMessageDialog(initialView,
                    a.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        seedTableSocios();
    }
}
