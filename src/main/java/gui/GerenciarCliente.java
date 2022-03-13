package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.table.MostrarClientes;

public class GerenciarCliente extends JFrame {
    public GerenciarCliente(){
        montarJanela();
        
        JPanel mainPanel = new JPanel();
        MostrarClientes tabela = MostrarClientes.getInstance();
        JButton AdicionarClienteBTN = new JButton("Adicionar Cliente");
        JButton RemoverClienteBTN = new JButton("Remover Cliente");

        AdicionarClienteListener AdicionarClienteListener = new AdicionarClienteListener();
        AdicionarClienteBTN.addActionListener((ActionListener) AdicionarClienteListener);

        RemoverClienteListener RemoverClienteListener = new RemoverClienteListener();
        RemoverClienteBTN.addActionListener((ActionListener) RemoverClienteListener);

        mainPanel.add(tabela);
        mainPanel.add(AdicionarClienteBTN);
        mainPanel.add(RemoverClienteBTN);
        add(mainPanel);
        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Gerenciar Cliente");
        setSize(1000, 700);
        setLocation(200, 50);
    }
}

class AdicionarClienteListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CadastrarCliente cadastrarCliente = new CadastrarCliente();
    }
}

class RemoverClienteListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        RemoverCliente removerCliente = new RemoverCliente();
    }
}