package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.AudienciaDAO;
import javax.swing.JTable;
import gui.table.MostrarAudiencia;

public class GerenciarAudiencia extends JFrame {
    public GerenciarAudiencia(){
        montarJanela();

        JPanel mainPanel = new JPanel();
        MostrarAudiencia tabela = MostrarAudiencia.getInstance();
        JButton AdicionarAudienciaBTN = new JButton("Adicionar Audiencia");
        JButton RemoverAudienciaBTN = new JButton("Remover Audiencia");

        AdicionarAudienciaListener adicionarAudienciaListener = new AdicionarAudienciaListener();
        AdicionarAudienciaBTN.addActionListener((ActionListener) adicionarAudienciaListener);

        RemoverAudienciaListener RemoverAudienciaListener = new RemoverAudienciaListener();
        RemoverAudienciaBTN.addActionListener((ActionListener) RemoverAudienciaListener);

        mainPanel.add(tabela);
        mainPanel.add(AdicionarAudienciaBTN);
        mainPanel.add(RemoverAudienciaBTN);
        add(mainPanel);
        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Gerenciar Audiencia");
        setSize(1000, 700);
        setLocation(200, 50);
    }
}

class AdicionarAudienciaListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        CadastrarAudiencia cadastrarAudiencia = new CadastrarAudiencia();
    }
}

class RemoverAudienciaListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable aux;
        aux = MostrarAudiencia.getInstance().MontrarTabela();

        int []rows = aux.getSelectedRows();
        if(aux.getSelectedRowCount() > 0){
            for(int i = 0; i<=aux.getSelectedRowCount(); i++){
                int id = Integer.parseInt((aux.getValueAt(rows[i], 0)).toString());
                System.out.println("ID: " + id);
                if(AudienciaDAO.getInstance().DeleteAudiencia(id)){
                    JOptionPane.showMessageDialog(null, "Uma audiencia foi removida!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    MostrarAudiencia.getInstance().RemoveFromTabela(rows[i]);
                }
                else{
                    JOptionPane.showMessageDialog(null, "erro ao remover alguma audiencia!", "",
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