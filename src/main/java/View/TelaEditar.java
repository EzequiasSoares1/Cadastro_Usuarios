package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Controller.Controlador;
import Model.Pessoa;
import Model.Sexo;

public class TelaEditar extends TelaDeCadastro {

	private static final long serialVersionUID = 8454534819014530433L;
	private JButton excluir;

	public TelaEditar(Pessoa c) {
		if (c == null) {
			super.setVisible(false);
			JOptionPane.showMessageDialog(null, "Cpf não encontrador");
			new TelaMenu();
		}
		setTitle("Editar");
		preencher(c);
	}

	private int posicao;

	public void preencher(Pessoa c) {
		getTNome().setText(c.getNome());
		getTTelefone().setText(c.getTell());
		getTEmail().setText(c.getEmail());
		getTCpf().setText(c.getCpf());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
	    String strDate = dateFormat.format(c.getData());;
		getTData().setText(strDate);
		setGen(c.getSexo());
		if (c.getSexo() != null) {
			if (c.getSexo().equals(Sexo.FEMININO)) {
				getF().setSelected(true);
				;
			} else if (c.getSexo().equals(Sexo.MASCULINO)) {
				getM().setSelected(true);
			} else {
				getI().setSelected(true);
			}
		}
		preencherEnd(c);
	}
	
	public void preencherEnd(Pessoa c) {
		getTRua().setText(c.getEndereco().getRua());
		getTCidade().setText(c.getEndereco().getCidade());
		getTEstado().setText(c.getEndereco().getEstado());
		getTNumero().setText(c.getEndereco().getNumero());
		getTPais().setText(c.getEndereco().getPais());
		getTReferencia().setText(c.getEndereco().getPontoReferencia());
		getTCep().setText(c.getEndereco().getCep());

	}

	public void cadastrar() {
		setCadastrar(new JButton("Editar"));
		getCadastrar().setBackground(Color.decode("#540c83"));
		getCadastrar().setForeground(Color.WHITE);
		getCadastrar().setBounds(190, 440, 100, 25);
		getCadastrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (getTitle().equals("Editar")) {
					try {
						Controlador c = new Controlador();
						if (c.Atualizar(getTNome().getText(), getTEmail().getText(), getTTelefone().getText(),
								getTCpf().getText(), getData(), getGen(),
								new Controlador().CriarEn(getTRua().getText(), getTNumero().getText(), getTCep().getText(), getTCidade().getText(),getTEstado().getText(),getTReferencia().getText()))) {
							JOptionPane.showMessageDialog(null, "Atualizador com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Verifique os campos");
						}
						dispose();
						new TelaMenu();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

				}
			}
		});
		add(getCadastrar());

		excluir = new JButton("Excluir");
		excluir.setBackground(Color.decode("#540c83"));
		excluir.setForeground(Color.WHITE);
		excluir.setBounds(550, 440, 100, 25);
		excluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (getTitle().equals("Editar")) {
					try {
						Controlador c = new Controlador();
						c.Excluir(getTCpf().getText());
						dispose();
						JOptionPane.showMessageDialog(null, "Exluido com sucesso");
						new TelaMenu();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

				}
			}
		});

		add(excluir);
		setSair(new JButton(new ImageIcon(getClass().getResource("iconExit.png"))));
		getSair().setBounds(790, 450, 30, 30);
		getSair().setBorder(null);
		getSair().setOpaque(false);
		getSair().setContentAreaFilled(false);
		getSair().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMenu();
			}
		});
		add(getSair());
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}
