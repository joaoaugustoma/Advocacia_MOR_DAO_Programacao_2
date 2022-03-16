package gui;

import dao.TribunaisDAO;
import dao.VarasDAO;
import gui.table.MostrarTribunais;
import gui.table.MostrarVaras;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarTribunais extends JFrame {
    public GerenciarTribunais(){
        montarJanela();
        
        JPanel mainPanel = new JPanel();
        MostrarTribunais tabela = MostrarTribunais.getInstance();
        JButton addTribunaisBtn = new JButton("Adicionar tribunal");
        JButton rmvTribunaisBtn = new JButton("Remover tribunal");

        AdicionarTribunaisListener adicionarTribunaisListener = new AdicionarTribunaisListener();
        addTribunaisBtn.addActionListener(adicionarTribunaisListener);

        RemoverTribunaisListener removerTribunaisListener = new RemoverTribunaisListener();
        rmvTribunaisBtn.addActionListener(removerTribunaisListener);

        mainPanel.add(tabela);
        mainPanel.add(addTribunaisBtn);
        mainPanel.add(rmvTribunaisBtn);
        add(mainPanel);
        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Gerenciar Tribunais");
        setSize(1000, 700);
        setLocation(200, 50);
    }
}

class AdicionarTribunaisListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CadastrarTribunais cadastrarTribunais = new CadastrarTribunais();
    }
}

class RemoverTribunaisListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable aux;
        aux = MostrarTribunais.getInstance().MontrarTabela();

        int []rows = aux.getSelectedRows();
        if(aux.getSelectedRowCount() > 0){
            for(int i = 0; i<aux.getSelectedRowCount(); i++){
                int id = Integer.parseInt((aux.getValueAt(rows[i], 0)).toString());
                System.out.println("ID: " + id);
                if(TribunaisDAO.getInstance().deleteTribunais(id)){
                    JOptionPane.showMessageDialog(null, "Uma tribunal foi removido!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    MostrarTribunais.getInstance().RemoveFromTabela(rows[i]);
                }
                else{
                    JOptionPane.showMessageDialog(null, "erro ao remover algum tribunal!", "",
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