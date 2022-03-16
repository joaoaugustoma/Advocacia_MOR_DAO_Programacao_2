package gui;

import listener.ProcessoAcusacaoListener;
import listener.ProcessoDefesaListener;

import javax.swing.*;
import java.awt.*;

public class NovoProcessoGUI extends JFrame {
    public NovoProcessoGUI() throws HeadlessException {
        setTitle("Uns & Outros Associados | Novo Processo");
        setSize(500, 300);
        setLocation(500, 300);

        JPanel mainPanel = new JPanel();

        JLabel novoProcessoLabel = new JLabel("NOVO PROCESSO");
        JButton defesaBtn = new JButton("Defesa");
        JButton acusacaoBtn = new JButton("Acusação");

        ProcessoDefesaListener processoDefesaAction = new ProcessoDefesaListener();
        defesaBtn.addActionListener(processoDefesaAction);

        ProcessoAcusacaoListener processoAcusacaoAction = new ProcessoAcusacaoListener();
        acusacaoBtn.addActionListener(processoAcusacaoAction);

        mainPanel.add(novoProcessoLabel);
        mainPanel.add(defesaBtn);
        mainPanel.add(acusacaoBtn);

        add(mainPanel);
        setVisible(true);
    }
}
