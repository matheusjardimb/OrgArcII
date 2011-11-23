package br.pucrs.orgArqII;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.pucrs.orgArqII.MIPS.AssemblyElement;
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
		jProximo = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jReiniciar = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel3 = new javax.swing.JLabel();
		jArquivo = new javax.swing.JButton();
		jScrollPane4 = new javax.swing.JScrollPane();
		jCommands = new javax.swing.JList();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jMemoria = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Registradores");

		jRegs.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Reg", "Valor" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jRegs);

		jLabel2.setText("Memória");

		jProximo.setText("Próximo");
		jProximo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
				updateForm();
			}
		});

		jButton2.setText("Sair");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
				updateForm();
			}
		});

		jReiniciar.setText("Reiniciar");
		jReiniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				updateForm();
			}
		});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Busca", "Decodificação", "Execução", "Memória", "Write Back" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(jTable2);

		jLabel3.setText("Estado atual");

		jArquivo.setText("Arquivo");
		jArquivo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
				updateForm();
			}
		});
		jScrollPane4.setViewportView(jCommands);

		jLabel4.setText("Comandos");

		jMemoria.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Reg", "Valor" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(jMemoria);

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
																.addComponent(jReiniciar)
																.addGap(7, 7, 7)
																.addComponent(jProximo)
																.addGap(6, 6, 6)
																.addComponent(jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(jLabel2)
																								.addGap(127, 127, 127))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane2,
																										0, 0,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jScrollPane4,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						176,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(jLabel4)
																								.addGap(102, 102, 102)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel3)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel1)
																				.addComponent(jLabel2)
																				.addComponent(jLabel3))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jScrollPane2)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																								.addComponent(
																										jScrollPane3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jScrollPane1))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(jLabel4)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jScrollPane4,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 428,
																		Short.MAX_VALUE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jProximo).addComponent(jReiniciar).addComponent(jButton2)
												.addComponent(jArquivo)).addContainerGap()));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.mips == null) {
			JOptionPane.showMessageDialog(this, "Carregue um arquivo primeiro");
			return;
		}
		this.mips.restart();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.mips == null) {
			JOptionPane.showMessageDialog(this, "Carregue um arquivo primeiro");
			return;
		}
		// if (!this.mips.hasNext()) {
		// JOptionPane.showMessageDialog(this,
		// "O último comando foi executado");
		// return;
		// }
		this.mips.next();
	}

	private void updateForm() {
		if (this.mips == null) {
			return;
		}
		updateRegisters();
		updateCommands();
		updateMemory();
	}

	private void updateMemory() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Pos");
		defaultTableModel.addColumn("Valor");
		for (String pos : this.mips.getMemory().keySet()) {
			defaultTableModel.addRow(new String[] { pos.toString(), this.mips.getMemoryValue(pos) });
		}
		jMemoria.setModel(defaultTableModel);
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
		for (AssemblyElement elem : this.mips.getElements()) {
			String aux = "   ";
			if (elem instanceof Command && this.mips.isActualCommand((Command) elem))
				aux = "-> ";
			defaultListModel.addElement(aux + elem);
		}
		this.jCommands.setModel(defaultListModel);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// JFileChooser jFileChooser = new JFileChooser();
		// jFileChooser.showOpenDialog(this);
		// if (jFileChooser.getSelectedFile() == null)
		// return;
		// this.mips = new
		// MIPS(SourceReader.readFile(jFileChooser.getSelectedFile().getPath()));
		String aux = "commands.txt";
		this.mips = new MIPS(SourceReader.readFile(aux));
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jProximo;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jReiniciar;
	private javax.swing.JButton jArquivo;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JList jCommands;
	private javax.swing.JTable jMemoria;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTable jRegs;
	private javax.swing.JTable jTable2;
	// End of variables declaration

}
