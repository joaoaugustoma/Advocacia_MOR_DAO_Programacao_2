import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.InicioGUI;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe MetalLookAndFeel não encontrada!!!");
        } catch (InstantiationException e) {
            System.out.println("Não foi possivel criar instancia!!");
        } catch (IllegalAccessException e) {
            System.out.println("Acesso Ilegal");
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Sem suporte!!");
        }

        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InicioGUI inicioGUI = new InicioGUI();
            }
        });
    }
}