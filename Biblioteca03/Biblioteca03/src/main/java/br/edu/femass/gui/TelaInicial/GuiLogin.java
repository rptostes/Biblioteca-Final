package br.edu.femass.gui.TelaInicial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLogin {
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JButton btnEntrar;
    private JPanel jPanelLogin;


    private JTextField txtNome;
    private JTextField txtEndereco;
    private JButton btnSalvar;
    private JPanel getjPanelLogin;
    private JFormattedTextField txtCpf;
    private JList lstClientes;
    private JComboBox cboClientes;


    public GuiLogin() {
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtUsuario.getText().equals("atendente") && txtSenha.getText().equals("123")){
                    GuiAtendente guiAtendente = new GuiAtendente();
                    JFrame frame = new JFrame("Atendente");
                    frame.setContentPane(guiAtendente.getjPanelAtendente());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }else if(txtUsuario.getText().equals("bibliotecario") && txtSenha.getText().equals("123")){
                    GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
                    JFrame frame = new JFrame("Bibliotecario");
                    frame.setContentPane(guiBibliotecario.getjPanelBibliotecario());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
                txtUsuario.setText("");
                txtSenha.setText("");


            }
        });
    }

    public JPanel getjPanelLogin() {
        return jPanelLogin;
    }

}
