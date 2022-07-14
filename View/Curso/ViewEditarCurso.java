package View.Curso;

import Controller.CursoController;
import Controller.ProfessorController;
import Controller.SalaController;
import static Funcoes.FuncoesAuxiliares.passarParaNumero;
import Model.Curso;
import Model.Professor;
import Model.Sala;
import java.util.ArrayList;
import static java.util.Objects.isNull;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class ViewEditarCurso extends javax.swing.JInternalFrame {

	private final ArrayList<Professor> professores;
	private final CursoController cc;
	private Curso curso;
	private final ArrayList<Sala> salas;
	private Sala sala;
	private Professor professor;
	private final ProfessorController pc;
	private final SalaController sc;
	private JInternalFrame chamador;

	public ViewEditarCurso(JInternalFrame chamador) {
		initComponents();
		this.sc = new SalaController();
		this.pc = new ProfessorController();
		this.cc = new CursoController();
		this.curso = new Curso();
		this.salas = this.sc.consultarSalas();
		this.professores = this.pc.consultarProfessores();
		this.chamador = chamador;
		setarProfessores();
		setarSalas();

	}

	public void setarProfessores() {
		DefaultListModel modelList = new DefaultListModel();
		for (Professor prof : professores) {
			modelList.addElement(prof.getCodigoProfessor() + " - " + prof.getNome());
		}
		this.listProfessor.setModel(modelList);
	}

	public void setarSalas() {
		DefaultListModel modelList = new DefaultListModel();
		for (Sala sal : salas) {
			modelList.addElement(sal.getCodigo() + " - " + sal.getNome());
		}
		this.listSala.setModel(modelList);
	}

	public void montarCurso(int codigo) {
		this.curso = this.cc.consultarCursoCodigo(codigo);
		this.professor = this.curso.getProfessor();
		this.sala = this.curso.getSala();
		DefaultListModel listaProfessor = (DefaultListModel) this.listProfessor.getModel();
		for (int i = 0; i < listaProfessor.size(); i++) {
			String prof = professor.getCodigoProfessor() + " - " + professor.getNome();
			if (prof.equals(listaProfessor.get(i))) {
				this.listProfessor.addSelectionInterval(i, i);
			}
		}
		DefaultListModel listaSala = (DefaultListModel) this.listSala.getModel();
		for (int i = 0; i < listaSala.size(); i++) {
			String sal = this.sala.getCodigo() + " - " + sala.getNome();
			if (sal.equals(listaSala.get(i))) {
				this.listSala.addSelectionInterval(i, i);
			}

		}
		eNomeCurso.setText(this.curso.getNome());
		eCargaHorariaCurso.setText(String.valueOf(this.curso.getCargaHoraria()));
		eDescricaoCurso.setText(this.curso.getDescricao());
		if (this.curso.getStatus()) {
			rAtivo.setSelected(true);
		} else {
			rInativo.setSelected(true);
		}
	}

	public void alterarCurso() {
		if (!listProfessor.isSelectionEmpty()) {
			this.professor = pc.consultarProfessorCodigoProfessor(
					this.professores.get(listProfessor.getSelectedIndex()).getCodigoProfessor());
			this.curso.setProfessor(this.professor);
		}
		if (!listSala.isSelectionEmpty()) {
			this.sala = sc.consultarSalaCodigo(salas.get(listSala.getSelectedIndex()).getCodigo());
			curso.setSala(sala);
		}
		this.curso.setNome(eNomeCurso.getText().trim().isEmpty() ? null : eNomeCurso.getText());
		this.curso.setCargaHoraria(eCargaHorariaCurso.getText().trim().isEmpty() ? null
				: Double.parseDouble(eCargaHorariaCurso.getText()));
		this.curso.setDescricao(eDescricaoCurso.getText().trim().isEmpty() ? null : eDescricaoCurso.getText());
		this.curso.setStatus(rAtivo.isSelected());
		String campos = this.cc.validarCamposCurso(curso);
		if (isNull(campos)) {
			if (cc.alterarCurso(this.curso)) {
				JOptionPane.showMessageDialog(null, "Curso Alterado com sucesso");
				abrirUltimoEFecharAtual();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar curso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos necessarios n�o preenchidos\n" + campos);
		}
	}

	public void abrirUltimoEFecharAtual() {
		if (!isNull(this.chamador)) {
			this.chamador.setVisible(true);
		}
		this.dispose();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonGroup = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		listSala = new javax.swing.JList<>();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		listProfessor = new javax.swing.JList<>();
		jButton2 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		eNomeCurso = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		eCargaHorariaCurso = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		eDescricaoCurso = new javax.swing.JTextPane();
		rAtivo = new javax.swing.JRadioButton();
		rInativo = new javax.swing.JRadioButton();

		jLabel1.setText("Professores");

		jLabel2.setText("Salas");

		listSala.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane2.setViewportView(listSala);

		jButton1.setText("Salvar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		listProfessor.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(listProfessor);

		jButton2.setText("Cancelar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel3.setText("Nome curso");

		jLabel4.setText("Carga horaria");

		eCargaHorariaCurso.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCargaHorariaCursoKeyReleased(evt);
			}
		});

		jLabel5.setText("Descrição");

		jScrollPane3.setViewportView(eDescricaoCurso);

		buttonGroup.add(rAtivo);
		rAtivo.setText("Ativo");

		buttonGroup.add(rInativo);
		rInativo.setText("Inativo");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1).addComponent(jLabel2))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane2).addComponent(jScrollPane1)))
								.addGroup(layout.createSequentialGroup().addComponent(rInativo)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton2))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(eNomeCurso))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4).addComponent(jLabel5).addComponent(rAtivo))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane3).addComponent(eCargaHorariaCurso,
														javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(jLabel2))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(eNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(eCargaHorariaCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel5).addComponent(jScrollPane3,
										javax.swing.GroupLayout.PREFERRED_SIZE, 66,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(3, 3, 3).addComponent(rAtivo)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(rInativo).addComponent(jButton1).addComponent(jButton2))
						.addContainerGap(17, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		alterarCurso();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		JOptionPane.showMessageDialog(null, "Curso não alterado");
		abrirUltimoEFecharAtual();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void eCargaHorariaCursoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCargaHorariaCursoKeyReleased
		eCargaHorariaCurso.setText(passarParaNumero(eCargaHorariaCurso.getText(), true));
	}// GEN-LAST:event_eCargaHorariaCursoKeyReleased

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup buttonGroup;
	private javax.swing.JTextField eCargaHorariaCurso;
	private javax.swing.JTextPane eDescricaoCurso;
	private javax.swing.JTextField eNomeCurso;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JList<String> listProfessor;
	private javax.swing.JList<String> listSala;
	private javax.swing.JRadioButton rAtivo;
	private javax.swing.JRadioButton rInativo;
	// End of variables declaration//GEN-END:variables
}
