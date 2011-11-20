package br.pucrs.orgArqII;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.pucrs.orgArqII.MIPS.Command;
import br.pucrs.orgArqII.MIPS.MIPS;
import br.pucrs.orgArqII.MIPS.Registers;
import br.pucrs.orgArqII.Utils.SourceReader;

public class MainForm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private MIPS mips;

	public MainForm() {
		initComponents();
	}

	@SuppressWarnings("serial")
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jRegs = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jCommands = new javax.swing.JList();
		jReiniciar = new javax.swing.JButton();
		jSair = new javax.swing.JButton();
		jProximo = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jStatus = new javax.swing.JTable();
		jLabel3 = new javax.swing.JLabel();
		jArquivo = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Banco de registradores");

		jRegs.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Reg", "Valor" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jRegs);

		jLabel2.setText("Comandos");

		jCommands.setRequestFocusEnabled(false);// Unclickable!
		jScrollPane2.setViewportView(jCommands);

		jReiniciar.setText("Reiniciar");
		jReiniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				updateForm();
			}
		});

		jSair.setText("Sair");
		jSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
				updateForm();
			}
		});

		jProximo.setText("Próximo");
		jProximo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
				updateForm();
			}
		});

		jStatus.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Busca",
				"Decodificação", "Execução", "Memória", "Write Back" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(jStatus);

		jLabel3.setText("Estado atual");

		jArquivo.setText("Arquivo");
		jArquivo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
				updateForm();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
														0, 0, Short.MAX_VALUE)
												.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(jArquivo)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jProximo)
																.addGap(7, 7, 7)
																.addComponent(jReiniciar)
																.addGap(6, 6, 6)
																.addComponent(jSair,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										176,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(jLabel2)
																								.addGap(108, 108, 108)))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel3)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jScrollPane2)
										.addComponent(jScrollPane1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jReiniciar).addComponent(jProximo).addComponent(jSair)
										.addComponent(jArquivo))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.mips.restart();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.mips == null) {
			JOptionPane.showMessageDialog(this, "Carregue um arquivo primeiro");
			return;
		}
		if (!this.mips.hasNext()) {
			JOptionPane.showMessageDialog(this, "O último comando foi executado");
			return;
		}
		this.mips.next();
	}

	private void updateForm() {
		updateRegisters();
		updateCommands();
	}

	private void updateRegisters() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Reg");
		defaultTableModel.addColumn("Valor");
		for (Registers reg : Registers.values()) {
			defaultTableModel.addRow(new String[] { reg.toString(), this.mips.getRegisterValue(reg) });
		}
		jRegs.setModel(defaultTableModel);
	}

	private void updateCommands() {		
		DefaultListModel defaultListModel = new DefaultListModel();
		for (Command c : this.mips.getCommands()) {
			String aux = "";
			if (this.mips.isActualCommand(c))
				aux = "-> ";
			defaultListModel.addElement(aux + c);
		}
		this.jCommands.setModel(defaultListModel);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
//		JFileChooser jFileChooser = new JFileChooser();
//		jFileChooser.showOpenDialog(this);
//		if (jFileChooser.getSelectedFile() == null)
//			return;
//		this.mips = new MIPS(SourceReader.readFile(jFileChooser.getSelectedFile().getPath()));
		String aux = "commands.txt";
		this.mips = new MIPS(SourceReader.readFile(aux));
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

	// UI elements
	private javax.swing.JButton jReiniciar;
	private javax.swing.JButton jSair;
	private javax.swing.JButton jProximo;
	private javax.swing.JButton jArquivo;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JList jCommands;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jRegs;
	private javax.swing.JTable jStatus;
}
