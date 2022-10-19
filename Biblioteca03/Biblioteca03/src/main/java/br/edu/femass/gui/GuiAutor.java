package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.List;

public class GuiAutor {
    private JButton btnCadastrarAutor;
    private JFormattedTextField txtNome;
    private JFormattedTextField txtSobrenome;
    private JFormattedTextField txtNacionalidade;
    private JPanel jPanelAutor;
    private JList lstAutor;

    public GuiAutor() {
        updateListAutor();

        btnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = new Autor(txtNome.getText(), txtSobrenome.getText(), txtNacionalidade.getText());
                    new DaoAutor().save(autor);
                    updateListAutor();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                txtNome.setText("");
                txtNacionalidade.setText("");
                txtSobrenome.setText("");
            }
        });
        lstAutor.addComponentListener(new ComponentAdapter() {
        });
    }

    private void updateListAutor() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutor.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public JPanel getjPanelAutor() {
        return jPanelAutor;
    }
}
