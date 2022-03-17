package gui;

import dao.ProcessosDAO;
import gui.table.MostrarProcessos;
import gui.CadastrarProcessos;
import listener.VoltarListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarProcessos extends JFrame {
    public GerenciarProcessos(){
        montarJanela();

        JPanel mainPanel = new JPanel();
        MostrarProcessos tabela = MostrarProcessos.getInstance();
        JButton addProcessosBtn = new JButton("Adicionar processo");
        JButton rmvProcessosBtn = new JButton("Remover processo");
        JButton VoltarBTN = new JButton("Voltar");

        AdicionarProcessosListener adicionarProcessosListener = new AdicionarProcessosListener();
        addProcessosBtn.addActionListener(adicionarProcessosListener);

        RemoverProcessosListener removerProcessosListener = new RemoverProcessosListener();
        rmvProcessosBtn.addActionListener(removerProcessosListener);

        VoltarListener VoltarListener = new VoltarListener(this);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        mainPanel.add(tabela);
        mainPanel.add(addProcessosBtn);
        mainPanel.add(rmvProcessosBtn);
        mainPanel.add(VoltarBTN);
        add(mainPanel);
        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Gerenciar Processos");
        setSize(1000, 700);
        setLocation(200, 50);
    }
}

class AdicionarProcessosListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        CadastrarProcessos cadastrarProcessos = new CadastrarProcessos();
    }
}

class RemoverProcessosListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable aux;
        aux = MostrarProcessos.getInstance().MontrarTabela();

        int []rows = aux.getSelectedRows();
        if(aux.getSelectedRowCount() > 0){
            for(int i = 0; i<=aux.getSelectedRowCount(); i++){
                int id = Integer.parseInt((aux.getValueAt(rows[i], 0)).toString());
                System.out.println("ID: " + id);
                if(ProcessosDAO.getInstance().deleteProcessos(id)){
                    JOptionPane.showMessageDialog(null, "Um processo foi removido!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    MostrarProcessos.getInstance().RemoveFromTabela(rows[i]);
                }
                else{
                    JOptionPane.showMessageDialog(null, "erro ao remover algum processo!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Não há nada linhas selecionadas para apagar", "",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }
}