package br.edu.femass.gui.TelaInicial;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.gui.GuiAluno;
import br.edu.femass.gui.GuiDevolucao;
import br.edu.femass.gui.GuiProfessor;
import br.edu.femass.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.List;

public class GuiAtendente {
    private JComboBox cboLeitor;
    private JTextField txtCodigo;
    private JList lstLivro;
    private JButton btnEmprestar;
    private JPanel jPanelAtendente;
    private JPanel jPanelAtendente2;
    private JButton btnDevolver;
    private JButton btnCadastrarProfessor;
    private JButton btnCadastrarAluno;
    private JRadioButton profRadioButton;
    private JRadioButton alunoRadioButton;
    private Boolean isProfessor = Boolean.FALSE;

    public GuiAtendente() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(profRadioButton);
        buttonGroup.add(alunoRadioButton);

        updateListLivro();

        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Leitor leitorSelecionado = getLeitor();
                Livro livroSelecionado = (Livro) lstLivro.getSelectedValue();



                Emprestimo emprestimo = new Emprestimo(leitorSelecionado, livroSelecionado);
                try {
                    new DaoEmprestimo().save(emprestimo);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e + "devolvi");
            }
        });
        btnCadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiProfessor guiProfessor = new GuiProfessor();
                JFrame frame = new JFrame("Professor");
                frame.setContentPane(guiProfessor.getjPanelProfessor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAluno guiAluno = new GuiAluno();
                JFrame frame = new JFrame("Aluno");
                frame.setContentPane(guiAluno.getjPanelAluno());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDevolucao guiDevolucao = new GuiDevolucao();
                JFrame frame = new JFrame("Devolver");
                frame.setContentPane(guiDevolucao.getjPanelDevolucao());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        lstLivro.addComponentListener(new ComponentAdapter() {
        });
        profRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!e.getActionCommand().isEmpty()){
                    cboLeitor.removeAllItems();
                    updateListProfessores();
                    isProfessor = true;
                    txtCodigo.setText("");
                }
            }
        });
        alunoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!e.getActionCommand().isEmpty()){
                    cboLeitor.removeAllItems();
                    updateListAlunos();
                    isProfessor = false;
                    txtCodigo.setText("");
                }
            }
        });
        cboLeitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getLeitor();
            }
        });
    }

    private Leitor getLeitor() {
        Integer selectedIndex = cboLeitor.getSelectedIndex();

        try {
            if(selectedIndex < 0){
                return null;
            }

            if (isProfessor) {
                Professor professor = getProfessores().get(selectedIndex);
                txtCodigo.setText(professor.getCodigo().toString());
                return professor;
            }else {
                Aluno aluno = getAlunos().get(selectedIndex);
                txtCodigo.setText(aluno.getCodigo().toString());
                return aluno;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void updateListProfessores() {
        try {
            List<Professor> professores = getProfessores();
            professores.forEach(professor -> {cboLeitor.addItem(professor);});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Professor> getProfessores() throws Exception {
        List<Professor> professores = new DaoProfessor().getAll();
        return professores;
    }

    private void updateListAlunos() {
        try {
            List<Aluno> alunos = getAlunos();
            alunos.forEach(professor -> {cboLeitor.addItem(alunos);});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Aluno> getAlunos() throws Exception {
        List<Aluno> alunos = new DaoAluno().getAll();
        return alunos;
    }

    private void updateListLivro() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstLivro.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanelAtendente() {
        JFrame newFrame = new JFrame();
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return jPanelAtendente;
    }
}
