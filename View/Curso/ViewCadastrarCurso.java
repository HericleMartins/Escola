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
import javax.swing.JOptionPane;

public final class ViewCadastrarCurso extends javax.swing.JInternalFrame {

	private final ArrayList<Professor> professores;
	private CursoController cc;
	private final ArrayList<Sala> salas;
	private final ProfessorController pc;
	private final SalaController sc;

	public ViewCadastrarCurso() {
		initComponents();
		this.sc = new SalaController();
		this.pc = new ProfessorController();
		this.cc = new CursoController();
		this.salas = this.sc.consultarSalas();
		this.professores = this.pc.consultarProfessores();
		setarProfessores();
		setarSalas();
	}

	public void cadastrarCurso() {
		Curso curso = new Curso();
		
		if (!listProfessor.isSelectionEmpty()) {
			Professor professor = new Professor();
			professor = pc.consultarProfessorCodigoProfessor(
					professores.get(listProfessor.getSelectedIndex()).getCodigoProfessor());
			curso.setProfessor(professor);
		}
		if (!listSala.isSelectionEmpty()) {
			Sala sala = new Sala();
			sala = sc.consultarSalaCodigo(salas.get(listSala.getSelectedIndex()).getCodigo());
			curso.setSala(sala);
		}
		curso.setNome(eNomeCurso.getText().trim().isEmpty() ? null : eNomeCurso.getText());
		curso.setCargaHoraria(eCargaHorariaCurso.getText().trim().isEmpty() ? null
				: Double.parseDouble(eCargaHorariaCurso.getText()));
		curso.setDescricao(eDescricaoCurso.getText().trim().isEmpty() ? null : eDescricaoCurso.getText());
		curso.setStatus(rAtivo.isSelected());
		String campos = this.cc.validarCamposCurso(curso);
		if (isNull(campos)) {
			if (cc.cadastrarCurso(curso)) {
				JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "N„o foi possivel cadastrar curso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos necessarios n„o preenchidos\n" + campos);
		}
	}

	public void setarProfessores() {
		DefaultListModel modelList = new DefaultListModel();
		if (!isNull(this.professores)) {
			for (Professor prof : professores) {
				modelList.addElement(prof.getCodigoProfessor() + " - " + prof.getNome());
			}
			this.listProfessor.setModel(modelList);
		} else {
			JOptionPane.showMessageDialog(null, "N„o existe professores para cadastrar no curso");
			dispose();
		}
	}

	public void setarSalas() {
		DefaultListModel modelList = new DefaultListModel();
		if (!isNull(this.salas)) {
			for (Sala sal : salas) {
				modelList.addElement(sal.getCodigo() + " - " + sal.getNome());
			}
			this.listSala.setModel(modelList);
		} else {
			JOptionPane.showMessageDialog(null, "N„o existe salas para cadastrar no curso");
			dispose();

		}
	}

	private void initComponents() {

		radioGroup = new javax.swing.ButtonGroup();
		jScrollPane1 = new javax.swing.JScrollPane();
		listProfessor = new javax.swing.JList<>();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		listSala = new javax.swing.JList<>();
		jLabel3 = new javax.swing.JLabel();
		eNomeCurso = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		eCargaHorariaCurso = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		eDescricaoCurso = new javax.swing.JTextPane();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		rAtivo = new javax.swing.JRadioButton();
		rInativo = new javax.swing.JRadioButton();

		listProfessor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(listProfessor);

		jLabel1.setText("Professores");

		jLabel2.setText("Salas");

		listSala.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane2.setViewportView(listSala);

		jLabel3.setText("Nome curso");

		jLabel4.setText("Carga horaria");

		eCargaHorariaCurso.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCargaHorariaCursoKeyReleased(evt);
			}
		});

		jLabel5.setText("Descri√ß√£o");

		jScrollPane3.setViewportView(eDescricaoCurso);

		jButton1.setText("Salvar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Cancelar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		radioGroup.add(rAtivo);
		rAtivo.setSelected(true);
		rAtivo.setText("Ativo");

		radioGroup.add(rInativo);
		rInativo.setText("Inativo");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(rInativo).addGap(18, 18, 18)
								.addComponent(jButton1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton2))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4)
										.addComponent(jLabel1).addComponent(rAtivo).addComponent(jLabel5))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane3)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261,
												Short.MAX_VALUE)
										.addComponent(eNomeCurso).addComponent(jScrollPane2)
										.addComponent(eCargaHorariaCurso, javax.swing.GroupLayout.Alignment.TRAILING))))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(jLabel1)
										.addGap(55, 55, 55).addComponent(jLabel2))
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 57,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(eNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
								.addComponent(eCargaHorariaCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 28, Short.MAX_VALUE)
										.addComponent(jLabel5).addGap(18, 18, 18).addComponent(rAtivo))
								.addComponent(jScrollPane3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(rInativo).addComponent(jButton1).addComponent(jButton2))
						.addGap(15, 15, 15)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		if (isNull(this.salas) || isNull(this.professores)) {
			if (isNull(this.salas) && isNull(this.professores)) {
				JOptionPane.showMessageDialog(null, "N„o existe salas e professores para cadastrar no curso");
				dispose();
			} else if (isNull(this.salas)) {
				JOptionPane.showMessageDialog(null, "N„o existe salas para cadastrar no curso");
				dispose();

			} else if (isNull(this.professores)) {
				JOptionPane.showMessageDialog(null, "N„o existe professores para cadastrar no curso");
				dispose();
			}
		} else {
			cadastrarCurso();
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		JOptionPane.showMessageDialog(null, "Curso n√£o cadastrado");
		this.dispose();
	}

	private void eCargaHorariaCursoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCargaHorariaCursoKeyReleased
		eCargaHorariaCurso.setText(passarParaNumero(eCargaHorariaCurso.getText(), true));
	}

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
	private javax.swing.ButtonGroup radioGroup;
}
