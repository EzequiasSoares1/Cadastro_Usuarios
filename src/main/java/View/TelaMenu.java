package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaMenu extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel painel, barraPadraoSuperio;
	private JButton cadastrar, editar, listar;

	public TelaMenu() {
		setTitle("Menu");
		setSize(450, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		botoes();
		configurandoPainel();
		setVisible(true);
	}
	
	public void configurandoPainel() {

		painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(450, 550);
		painel.setBackground(Color.decode("#cccccc"));
		add(painel);

		barraPadraoSuperio = new JPanel();
		barraPadraoSuperio.setSize(450, 13);
		barraPadraoSuperio.setBackground(Color.decode("#540c83"));
		painel.add(barraPadraoSuperio);
		
	
	}
	
	public void botoes() {
		cadastrar = new JButton("Cadastrar");
		cadastrar.setForeground(Color.WHITE);
		cadastrar.setBackground(Color.decode("#540c83"));
		cadastrar.setBounds(155, 125, 120, 35);
		cadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaDeCadastro();
			}
		});
		add(cadastrar);
		
		editar = new JButton("Editar");
		editar.setForeground(Color.WHITE);
		editar.setBackground(Color.decode("#540c83"));
		editar.setBounds(155, 260, 120, 35);
		editar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaBuscarCPF();
			}
		});
		add(editar);
		
		listar = new JButton("Listar");
		listar.setForeground(Color.WHITE);
		listar.setBackground(Color.decode("#540c83"));
		listar.setBounds(155, 390, 120, 35);
		listar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaListas();
			}
		});
		add(listar);
		
		
	}
}
