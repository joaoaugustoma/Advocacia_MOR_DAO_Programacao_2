package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.*;

public class InicioGUI extends JFrame {
    GerenciarClienteListener gerenciarClienteListener;
    GerenciarVarasListener gerenciarVarasListener;
    GerenciarAudienciaListener gerenciarAudienciaListener;
    GerenciarTribunaisListener gerenciarTribunaisListener;
    GerenciarProcessosListener gerenciarProcessosListener;
    GerenciarCustasListener gerenciarCustasListener;

    public InicioGUI(){
        setTitle("Uns & Outros Associados | Processos");
        setSize(1000, 700);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel tituloPanel = new JPanel();

        JLabel processoLabel = new JLabel("PROCESSOS");
        tituloPanel.add(processoLabel);

        JButton GerenciarCliente = new JButton("Gerenciar Pessoa");
        JButton Gerenciarvaras = new JButton("Gerenciar Varas");
        JButton gerenciarAudiencia = new JButton("Gerenciar Audiencia");
        JButton gerenciarTribunais = new JButton("Gerenciar Tribunais");
        JButton gerenciarProcessos = new JButton("Gerenciar Processos");
        JButton gerenciarCustas = new JButton("Gerenciar Custas");

        gerenciarClienteListener = new GerenciarClienteListener();
        GerenciarCliente.addActionListener(gerenciarClienteListener);

        gerenciarVarasListener = new GerenciarVarasListener();
        Gerenciarvaras.addActionListener(gerenciarVarasListener);

        gerenciarAudienciaListener = new GerenciarAudienciaListener();
        gerenciarAudiencia.addActionListener(gerenciarAudienciaListener);

        gerenciarTribunaisListener = new GerenciarTribunaisListener();
        gerenciarTribunais.addActionListener(gerenciarTribunaisListener);

        gerenciarProcessosListener = new GerenciarProcessosListener();
        gerenciarProcessos.addActionListener(gerenciarProcessosListener);

        gerenciarCustasListener = new GerenciarCustasListener();
        gerenciarCustas.addActionListener(gerenciarCustasListener);

        mainPanel.add(tituloPanel);
        mainPanel.add(GerenciarCliente);
        mainPanel.add(Gerenciarvaras);
        mainPanel.add(gerenciarAudiencia);
        mainPanel.add(gerenciarTribunais);
        mainPanel.add(gerenciarProcessos);
        mainPanel.add(gerenciarCustas);
        

        add(mainPanel);
        setVisible(true);
    }
}