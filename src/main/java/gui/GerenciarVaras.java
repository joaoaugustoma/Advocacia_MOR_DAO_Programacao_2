package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.VarasDAO;
import javax.swing.JTable;
import gui.table.MostrarVaras;

public class GerenciarVaras extends JFrame {
    public GerenciarVaras(){
        montarJanela();
        
        JPanel mainPanel = new JPanel();
        MostrarVaras tabela = MostrarVaras.getInstance();
        JButton AdicionarvarasBTN = new JButton("Adicionar varas");
        JButton RemovervarasBTN = new JButton("Remover varas");

        AdicionarvarasListener AdicionarvarasListener = new AdicionarvarasListener();
        AdicionarvarasBTN.addActionListener((ActionListener) AdicionarvarasListener);

        RemovervarasListener RemovervarasListener = new RemovervarasListener();
        RemovervarasBTN.addActionListener((ActionListener) RemovervarasListener);

        mainPanel.add(tabela);
        mainPanel.add(AdicionarvarasBTN);
        mainPanel.add(RemovervarasBTN);
        add(mainPanel);
        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Gerenciar varas");
        setSize(1000, 700);
        setLocation(200, 50);
    }
}

class AdicionarvarasListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CadastrarVaras cadastrarVaras = new CadastrarVaras();
    }
}

class RemovervarasListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable aux;
        aux = MostrarVaras.getInstance().MontrarTabela();

        int []rows = aux.getSelectedRows();
        if(aux.getSelectedRowCount() > 0){
            for(int i = 0; i<aux.getSelectedRowCount(); i++){
                int id = Integer.parseInt((aux.getValueAt(rows[i], 0)).toString());
                System.out.println("ID: " + id);
                if(VarasDAO.getInstance().DeleteVaras(id)){
                    JOptionPane.showMessageDialog(null, "Uma vara foi removida!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    MostrarVaras.getInstance().RemoveFromTabela(rows[i]);
                }
                else{
                    JOptionPane.showMessageDialog(null, "erro ao remover alguma vara!", "",
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