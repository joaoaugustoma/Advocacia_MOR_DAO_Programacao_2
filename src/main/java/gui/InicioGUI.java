package gui;

import javax.swing.*;

import listener.*;

import java.awt.*;

public class InicioGUI extends JFrame {
    GerenciarClienteListener gerenciarClienteListener;
    GerenciarVarasListener gerenciarVarasListener;
    GerenciarAudienciaListener gerenciarAudienciaListener;
    GerenciarTribunaisListener gerenciarTribunaisListener;
    GerenciarProcessosListener gerenciarProcessosListener;
    GerenciarCustasListener gerenciarCustasListener;

    public InicioGUI(){
        setTitle("Uns & Outros Associados | Processos");
        setSize(900, 100);
        setLocation(200, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

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

        mainPanel.add(GerenciarCliente);
        mainPanel.add(gerenciarTribunais);
        mainPanel.add(Gerenciarvaras);
        mainPanel.add(gerenciarAudiencia);
        mainPanel.add(gerenciarProcessos);
        mainPanel.add(gerenciarCustas);

        add(mainPanel);
        setVisible(true);
    }
}