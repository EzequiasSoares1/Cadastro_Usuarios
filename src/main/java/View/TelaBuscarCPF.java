package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controlador;

public class TelaBuscarCPF extends JFrame{
	
	private static final long serialVersionUID = 7584568068582719531L;
	private JButton verificar;
	private JTextField cpf;
	private JLabel label;

	public TelaBuscarCPF () {
		
		botao();
		adicionarLay();
		campo();
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(400,250);
		setVisible(true);
	}
	
	public  void botao() {
		verificar = new JButton("Buscar");
		verificar.setBounds(140, 160, 100, 25);
		verificar.setForeground(Color.WHITE);
		verificar.setBackground(Color.decode("#540c83"));
		verificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new TelaEditar(new Controlador().Buscar(cpf.getText()));
					
				} catch (Exception e1) {
				}
			}
		});
		add(verificar);
	}
	
	public void adicionarLay() {
		label = new JLabel();
		label.setText("Digite o Cpf");
		label.setBounds(140, 35, 200, 50);
		add(label);
	}
	
	public void campo() {
		cpf = new JTextField();
		cpf.setBounds(90, 100, 200, 25);
		add(cpf);
	}


}
