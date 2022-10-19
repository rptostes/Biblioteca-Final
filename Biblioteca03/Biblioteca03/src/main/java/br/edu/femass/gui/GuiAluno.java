package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.List;

public class GuiAluno {
    private JFormattedTextField txtMatricula;
    private JFormattedTextField txtNome;
    private JFormattedTextField txtEndereco;
    private JFormattedTextField txtTelefone;
    private JButton btnCadastrar;
    private JList lstAlunos;
    private JPanel jPanelAluno;

    public GuiAluno() {
        updateListAlunos();

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtMatricula.getText());
                    new DaoAluno().save(aluno);
                    updateListAlunos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                txtNome.setText("");
                txtEndereco.setText("");
                txtTelefone.setText("");
                txtMatricula.setText("");
            }
        });
        lstAlunos.addComponentListener(new ComponentAdapter() {
        });
        lstAlunos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                Aluno aluno = (Aluno) lstAlunos.getSelectedValue();
                if (aluno==null) return;
                txtNome.setText(aluno.getNome());
                txtEndereco.setText(aluno.getEndereco());
                txtMatricula.setText(aluno.getMatricula());
                txtTelefone.setText(aluno.getTelefone());
            }
        });
    }



    private void updateListAlunos() {
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            lstAlunos.setListData(alunos.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanelAluno() {
        return jPanelAluno;
    }
}
