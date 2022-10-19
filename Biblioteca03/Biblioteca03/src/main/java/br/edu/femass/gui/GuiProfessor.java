package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.List;

public class GuiProfessor {
    private JFormattedTextField txtNome;
    private JFormattedTextField txtEndereco;
    private JFormattedTextField txtTelefone;
    private JButton btnCadastrar;
    private JList lstProfessores;
    private JFormattedTextField txtDisciplina;
    private JPanel jPanelProfessor;


    public GuiProfessor() {
        updateListProfessores();

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Professor professor = new Professor(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtDisciplina.getText());
                    new DaoProfessor().save(professor);
                    updateListProfessores();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                txtNome.setText("");
                txtEndereco.setText("");
                txtTelefone.setText("");
                txtDisciplina.setText("");
            }


        });
        lstProfessores.addComponentListener(new ComponentAdapter() {
        });
        lstProfessores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                Professor professor = (Professor) lstProfessores.getSelectedValue();
                if (professor==null) return;
                txtNome.setText(professor.getNome());
                txtEndereco.setText(professor.getEndereco());
                txtTelefone.setText(professor.getTelefone());
                txtDisciplina.setText(professor.getDisciplina());
            }
        });
    }

    private void updateListProfessores() {
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            lstProfessores.setListData(professores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanelProfessor() {
        return jPanelProfessor;
    }


}
