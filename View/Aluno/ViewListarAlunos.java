package View.Aluno;

import Controller.AlunoController;
import Controller.AlunoCursoController;
import Model.Aluno;
import Model.Curso;
import View.Curso.ViewListarCursos;
import java.awt.Color;
import java.util.ArrayList;
import static java.util.Objects.isNull;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe de visualização dos alunos
 *
 * @author Héricles Martins
 */
public class ViewListarAlunos extends javax.swing.JInternalFrame {

	private final AlunoController ac = new AlunoController();
	private final AlunoCursoController acc = new AlunoCursoController();
	private JInternalFrame chamador;

	public ViewListarAlunos(JInternalFrame chamador) {
		initComponents();
		this.chamador = chamador;
	}

	/**
	 * Função para montar os alunos na tela
	 *
	 * @param aAlunos ArrayList de alunos para serem montados
	 */
	public void montarAlunos(ArrayList<Aluno> aAlunos) {
		if (isNull(aAlunos)) {
			aAlunos = this.ac.consultarAlunos();
		}
		DefaultTableModel model = (DefaultTableModel) tableAlunos.getModel();
		model.setRowCount(0);
		if (!isNull(aAlunos) && !aAlunos.isEmpty()) {
			for (Aluno aAluno : aAlunos) {
				model.addRow(new Object[] { aAluno.getNome(), aAluno.getMatricula(), aAluno.getCpf() });
			}
		}
	}

	/**
	 * Função para pesquisar por pedaço do nome
	 *
	 * @param editText Valor do editText de pesquisa
	 */
	public void pesquisar(String editText) {
		if (editText.trim().isEmpty()) {
			editText = null;
		}
		montarAlunos(this.ac.consultarAlunoNome(editText));
	}

	/**
	 * Função que chama o editar do aluno
	 *
	 * @param matricula matricula do aluno que esta na coluna
	 */
	public void editar(int matricula) {
		ViewEditarAluno va = new ViewEditarAluno(this);
		va.setVisible(true);
		JDesktopPane desk = super.getDesktopPane();
		va.montarAluno(matricula);
		desk.add(va);
		this.setVisible(false);
	}

	/**
	 * Função para abrir o form que chamou esse
	 */
	public void abrirUltimoEFecharAtual() {
		if (!isNull(chamador)) {
			chamador.setVisible(true);
		}
		this.dispose();
	}

	/**
	 * Função para buscar os cursos do Aluno selecionado
	 */
	public void buscarCursosAluno() {
		int row = tableAlunos.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableAlunos.getModel();
			int codigoAluno = Integer.parseInt(model.getValueAt(row, 1).toString());
			Aluno aluno = ac.consultarAlunoMatricula(codigoAluno);
			ArrayList<Curso> aCursos = acc.buscarCursosAluno(aluno);
			if (!aCursos.isEmpty()) {
				ViewListarCursos vlc = new ViewListarCursos(this);
				vlc.montarCursos(aCursos);
				vlc.setVisible(true);
				JDesktopPane desk = super.getDesktopPane();
				desk.add(vlc);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Aluno não cadastrado em nenhum curso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um aluno");
		}

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		EPesquisaNome = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableAlunos = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameClosing(evt);
			}

			public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
			}
		});

		EPesquisaNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		EPesquisaNome.setForeground(java.awt.Color.gray);
		EPesquisaNome.setText("Pesquisar");
		EPesquisaNome.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				EPesquisaNomeFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				EPesquisaNomeFocusLost(evt);
			}
		});

		EPesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {

			public void keyReleased(java.awt.event.KeyEvent evt) {
				EPesquisaNomeKeyReleased(evt);
			}
		});

		jButton1.setText("Visualizar cursos do aluno");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		tableAlunos.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nome", "Matricula", "CPF" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(tableAlunos);

		jButton2.setText("Matricular aluno em um curso");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Editar cadastro aluno");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 324,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addComponent(jButton2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addComponent(jButton1).addGap(18, 18, 18).addComponent(jButton3))
				.addComponent(jScrollPane1));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(9, 9, 9)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		EPesquisaNome.getAccessibleContext().setAccessibleName("");
		EPesquisaNome.getAccessibleContext().setAccessibleDescription("Pesquisar");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

		buscarCursosAluno();

	}// GEN-LAST:event_jButton1ActionPerformed

	private void EPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_EPesquisaNomeKeyReleased

		pesquisar(EPesquisaNome.getText());

	}// GEN-LAST:event_EPesquisaNomeKeyReleased

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		int row = tableAlunos.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableAlunos.getModel();
			int matricula = Integer.parseInt(model.getValueAt(row, 1).toString());
			Aluno aluno = ac.consultarAlunoMatricula(matricula);
			ViewMatricularAlunoCurso vmac = new ViewMatricularAlunoCurso(aluno, this);
			vmac.setVisible(true);
			JDesktopPane desk = super.getDesktopPane();
			vmac.montarCursos();
			desk.add(vmac);
			this.setVisible(false);

		} else {
			JOptionPane.showMessageDialog(null, "Selecione um aluno");
		}

	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		int row = tableAlunos.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableAlunos.getModel();

			editar(Integer.parseInt(model.getValueAt(row, 1).toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um aluno");
		}
	}// GEN-LAST:event_jButton3ActionPerformed

	private void EPesquisaNomeFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_EPesquisaNomeFocusGained
		if (EPesquisaNome.getText().equals("Pesquisar")) {
			EPesquisaNome.setText("");
			EPesquisaNome.setForeground(Color.BLACK);
		}
	}// GEN-LAST:event_EPesquisaNomeFocusGained

	private void EPesquisaNomeFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_EPesquisaNomeFocusLost
		if (EPesquisaNome.getText().isEmpty()) {
			EPesquisaNome.setForeground(Color.GRAY);
			EPesquisaNome.setText("Pesquisar");
		}
	}// GEN-LAST:event_EPesquisaNomeFocusLost

	private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameClosing
		abrirUltimoEFecharAtual();
	}// GEN-LAST:event_formInternalFrameClosing

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField EPesquisaNome;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tableAlunos;
	// End of variables declaration//GEN-END:variables
}
