package br.edu.femass;

import br.edu.femass.gui.TelaInicial.GuiLogin;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        GuiLogin guiLogin = new GuiLogin();

        JFrame frame = new JFrame("Aula de Prog 3");
        frame.setContentPane(guiLogin.getjPanelLogin());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }


}
