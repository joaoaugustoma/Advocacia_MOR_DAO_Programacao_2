package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import dao.CustasDAO;
import gui.table.MostrarCustas;
import listener.VoltarListener;

public class GerenciarCustas extends JFrame {
    public GerenciarCustas(){
        montarJanela();
        
        JPanel mainPanel = new JPanel();
        MostrarCustas tabela = MostrarCustas.getInstance();
        JButton AdicionarCustasBTN = new JButton("Adicionar Custas");
        JButton RemoverCustasBTN = new JButton("Remover Custas");
        JButton VoltarBTN = new JButton("Voltar");

        AdicionarCustasListener AdicionarCustasListener = new AdicionarCustasListener();
        AdicionarCustasBTN.addActionListener((ActionListener) AdicionarCustasListener);

        RemoverCustasListener RemoverCustasListener = new RemoverCustasListener();
        RemoverCustasBTN.addActionListener((ActionListener) RemoverCustasListener);

        VoltarListener VoltarListener = new VoltarListener(this);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        mainPanel.add(tabela);
        mainPanel.add(AdicionarCustasBTN);
        mainPanel.add(RemoverCustasBTN);
        mainPanel.add(VoltarBTN);
        add(mainPanel);
        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Gerenciar Custas");
        setSize(1000, 700);
        setLocation(200, 50);
    }
}

class AdicionarCustasListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CadastrarCustas cadastrarCustas = new CadastrarCustas();
    }
}

class RemoverCustasListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable aux;
        aux = MostrarCustas.getInstance().MontrarTabela();

        int []rows = aux.getSelectedRows();
        if(aux.getSelectedRowCount() > 0){
            for(int i = 0; i<=aux.getSelectedRowCount(); i++){
                int id = Integer.parseInt((aux.getValueAt(rows[i], 0)).toString());
                System.out.println("ID: " + id);
                if(CustasDAO.getInstance().DeleteCustas(id)){
                    JOptionPane.showMessageDialog(null, "Uma vara foi removida!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    MostrarCustas.getInstance().RemoveFromTabela(rows[i]);
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