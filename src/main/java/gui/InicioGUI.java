package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.PessoaDAO;
import listener.*;

import java.sql.SQLException;

public class InicioGUI extends JFrame {
    NovoProcessoListener novoProcessoAction;
    ConsultarProcessoListener consultarProcessoAction;
    GerenciarClienteListener gerenciarClienteListener;
        GerenciarVarasListener gerenciarVarasListener;
    GerenciarAudienciaListener gerenciarAudienciaListener;
    GerenciarTribunaisListener gerenciarTribunaisListener;

    public InicioGUI(){
        setTitle("Uns & Outros Associados | Processos");
        setSize(1000, 700);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel tituloPanel = new JPanel();

        JLabel processoLabel = new JLabel("PROCESSOS");
        tituloPanel.add(processoLabel);

        JButton novoProcessoBtn = new JButton("Novo Processo");
        JButton consultarProcessoBtn = new JButton("Consultar Processo");
        JButton GerenciarCliente = new JButton("Gerenciar Cliente");
        JButton Gerenciarvaras = new JButton("Gerenciar Varas");
        JButton gerenciarAudiencia = new JButton("Gerenciar Audiencia");
        JButton gerenciarTribunais = new JButton("Gerenciar Tribunais");

        novoProcessoAction = new NovoProcessoListener();
        novoProcessoBtn.addActionListener(novoProcessoAction);

        consultarProcessoAction = new ConsultarProcessoListener();
        consultarProcessoBtn.addActionListener(consultarProcessoAction);

        gerenciarClienteListener = new GerenciarClienteListener();
        GerenciarCliente.addActionListener(gerenciarClienteListener);

        gerenciarVarasListener = new GerenciarVarasListener();
        Gerenciarvaras.addActionListener(gerenciarVarasListener);

        gerenciarAudienciaListener = new GerenciarAudienciaListener();
        gerenciarAudiencia.addActionListener(gerenciarAudienciaListener);

        gerenciarTribunaisListener = new GerenciarTribunaisListener();
        gerenciarTribunais.addActionListener(gerenciarTribunaisListener);

        mainPanel.add(tituloPanel);
        mainPanel.add(novoProcessoBtn);
        mainPanel.add(consultarProcessoBtn);
        mainPanel.add(GerenciarCliente);
        mainPanel.add(Gerenciarvaras);
        mainPanel.add(gerenciarAudiencia);
        mainPanel.add(gerenciarTribunais);

        add(mainPanel);
        setVisible(true);

    }
}