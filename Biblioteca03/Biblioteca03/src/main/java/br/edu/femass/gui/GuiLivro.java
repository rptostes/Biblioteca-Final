package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class GuiLivro {
    private JButton btnCadastrar;
    private JTextField txtTitulo;
    private JPanel jPanelLivro;
    private JList lstAutores;
    private JLabel Autor;
    private JList lstLivros;
    private JFormattedTextField nome;
    private JFormattedTextField sobrenome;
    private JFormattedTextField nacionalidade;

    public GuiLivro() {

        updateListAutores();

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Autor> autorSelected = (List<br.edu.femass.model.Autor>) lstAutores.getSelectedValuesList();

                    Livro livro = new Livro(txtTitulo.getText(), autorSelected);
                    new DaoLivro().save(livro);
                    updateListLivros();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                txtTitulo.setText("");
            }
        });
        lstLivros.addComponentListener(new ComponentAdapter() {
        });
    }

    private void updateListLivros() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstLivros.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateListAutores() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutores.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanelLivro() {
        return jPanelLivro;
    }
}
