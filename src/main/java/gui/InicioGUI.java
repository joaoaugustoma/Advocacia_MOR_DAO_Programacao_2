package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.ConsultarProcessoListener;
import listener.GerenciarClienteListener;
import listener.NovoProcessoListener;

public class InicioGUI extends JFrame {
    NovoProcessoListener novoProcessoAction;
    ConsultarProcessoListener continuarProcessoAction;
    GerenciarClienteListener GerenciarClienteListener;

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
        JButton GerenciarCliente = new JButton("Gerenciar Cliente");

        novoProcessoAction = new NovoProcessoListener();
        novoProcessoBtn.addActionListener(novoProcessoAction);

        continuarProcessoAction = new ConsultarProcessoListener();
        continuarProcessoBtn.addActionListener(continuarProcessoAction);

        GerenciarClienteListener = new GerenciarClienteListener();
        GerenciarCliente.addActionListener(GerenciarClienteListener);

        mainPanel.add(tituloPanel);
        mainPanel.add(novoProcessoBtn);
        mainPanel.add(continuarProcessoBtn);
        mainPanel.add(GerenciarCliente);

        add(mainPanel);
        setVisible(true);
    }
}