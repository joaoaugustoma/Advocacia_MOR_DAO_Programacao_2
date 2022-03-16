package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.ConsultarProcessoListener;
import listener.GerenciarAudienciaListener;
import listener.GerenciarClienteListener;
import listener.NovoProcessoListener;

public class InicioGUI extends JFrame {
    NovoProcessoListener novoProcessoAction;
    ConsultarProcessoListener continuarProcessoAction;
    GerenciarClienteListener gerenciarClienteListener;
    GerenciarAudienciaListener gerenciarAudienciaListener;

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
        JButton continuarProcessoBtn = new JButton("Continuar Processo");
        JButton gerenciarCliente = new JButton("Gerenciar Cliente");
        JButton gerenciarAudiencia = new JButton("Gerenciar Audiencia");

        novoProcessoAction = new NovoProcessoListener();
        novoProcessoBtn.addActionListener(novoProcessoAction);

        continuarProcessoAction = new ConsultarProcessoListener();
        continuarProcessoBtn.addActionListener(continuarProcessoAction);

        gerenciarClienteListener = new GerenciarClienteListener();
        gerenciarCliente.addActionListener(gerenciarClienteListener);

        gerenciarAudienciaListener = new GerenciarAudienciaListener();
        gerenciarAudiencia.addActionListener(gerenciarAudienciaListener);


        mainPanel.add(tituloPanel);
        mainPanel.add(novoProcessoBtn);
        mainPanel.add(continuarProcessoBtn);
        mainPanel.add(gerenciarCliente);
        mainPanel.add(gerenciarAudiencia);

        add(mainPanel);
        setVisible(true);
    }
}