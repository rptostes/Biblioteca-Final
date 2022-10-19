package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class GuiDevolucao {
    private JButton devolverButton;
    private JList lstDevolucao;
    private JPanel jPanelDevolucao;

    public GuiDevolucao() {
        updateListDevolucao();

        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) lstDevolucao.getSelectedValue();
                String[] stringSplited = (selectedValue).split("\\s+"); //regex para sliptar text com espaço ex: "ola mundo" fica > ["ola", "mundo"]
                String leitor = stringSplited[1];
                String livro = stringSplited[4];

                try {
                    getEmprestimos().forEach(emprestimo -> {
                        if(emprestimo.getLeitor().getNome().contains(leitor) &&
                            emprestimo.getLivro().getTitulo().contains(livro)){
                            try {
                                new DaoEmprestimo().remove(emprestimo);

                                emprestimo.setDataDevolucao(LocalDate.now());
                                new DaoEmprestimo().save(emprestimo);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                updateListDevolucao();
            }
        });
    }

    private void updateListDevolucao() {
        try {
            List<Emprestimo> emprestimos = getEmprestimos();

            DefaultListModel<String> listModel = new DefaultListModel<>();
            emprestimos.forEach(emprestimo -> {
                if (Objects.isNull(emprestimo.getDataDevolucao())) { //filtra data de devolucao nula
                    listModel.addElement("Leitor: " + emprestimo.getLeitor().getNome() +
                            " - " + "Livro: " + emprestimo.getLivro().getTitulo());
                }
            });

            lstDevolucao.setModel(listModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Emprestimo> getEmprestimos() throws Exception {
        List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
        return emprestimos;
    }

    public JPanel getjPanelDevolucao() {
        return jPanelDevolucao;
    }

}
