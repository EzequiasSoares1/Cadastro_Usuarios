package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.Controlador;
import Model.Pessoa;

public class TelaListas  extends JFrame{

	public  TelaListas(){
		tabela();
		botao();
		configurandoPainel();
		configurandoTela();
		setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel painel, barraPadraoSuperio, barraPadraoinferior;
	private JTable tabela;
	private JButton sair;

	public void configurandoTela() {
		setSize(450, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		configurandoPainel();
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
		
		barraPadraoinferior = new JPanel();
		barraPadraoinferior.setBounds(0, 500, 450, 13);
		barraPadraoinferior.setBackground(Color.decode("#540c83"));
		add(barraPadraoinferior);
		
		
	}
	public void botao() {
		sair = new JButton(new ImageIcon(getClass().getResource("iconExit.png")));
		sair.setBounds(350, 430, 30, 30);
		sair.setBorder(null);
		sair.setOpaque(false);
		sair.setContentAreaFilled(false);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMenu();
			}
		});
		add(sair);
	}
	
	public void tabela() {
		DefaultTableModel modelo = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int lin, int colun) {
				return false;
			}
		};
		modelo.addColumn("CPF");
		modelo.addColumn("Nome");
		
		List<Pessoa> p;
		try {
			p = new Controlador().ListarTodos();
			for(int i = 0; i < p.size(); i++) {
				Object[] linha = new Object[3];
				linha[0] = p.get(i).getCpf();
				linha[1] = p.get(i).getNome();
				modelo.addRow(linha);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Problema com o BD = " + e.getMessage());
			dispose();
			new TelaMenu();
		}
		
		
		
		tabela = new JTable(modelo);
	    tabela.setBackground(Color.decode("#cccccc"));
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(30, 30, 375, 350);
		add(scroll);
	}
}
