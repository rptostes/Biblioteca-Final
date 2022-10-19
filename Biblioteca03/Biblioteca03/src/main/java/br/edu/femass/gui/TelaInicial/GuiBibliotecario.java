package br.edu.femass.gui.TelaInicial;

import br.edu.femass.gui.GuiAutor;
import br.edu.femass.gui.GuiLivro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBibliotecario {

    private JButton btnCadastrarAutor;
    private JButton btnCadastrarLivro;
    private JList lstLeitoresEmAtraso;
    private JPanel jPanelBibliotecario;

    public GuiBibliotecario() {
        btnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                JFrame frame = new JFrame("Autor");
                frame.setContentPane(guiAutor.getjPanelAutor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                JFrame frame = new JFrame("Livro");
                frame.setContentPane(guiLivro.getjPanelLivro());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }

    public JPanel getjPanelBibliotecario() {
        return jPanelBibliotecario;
    }

}
