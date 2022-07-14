package View.Aluno;

import Controller.AlunoCursoController;
import Model.Aluno;
import Model.Curso;
import java.util.ArrayList;
import static java.util.Objects.isNull;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewMatricularAlunoCurso extends javax.swing.JInternalFrame {

    private AlunoCursoController acc = new AlunoCursoController();
    private Aluno aluno;
    private ArrayList<Curso> aCursos;
    private JInternalFrame chamador;

    public ViewMatricularAlunoCurso(Aluno aluno,JInternalFrame chamador) {
        initComponents();
        this.aluno = aluno;
        this.aCursos = acc.buscarCursosValidosAluno(aluno);
        this.LNomeAluno.setText(aluno.getNome());
        this.chamador = chamador;
    }

    public void montarCursos() {
        if (aCursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não tem cursos disponiveis para esse aluno");
            abrirUltimoEFecharAtual();
            
        } else {
            DefaultTableModel model = (DefaultTableModel) tableCursosDisponiveis.getModel();
            model.setRowCount(0);
            for (Curso aCurso : aCursos) {
                model.addRow(new Object[]{aCurso.getNome(), aCurso.getCodigo(), aCurso.getSala().getPredio() +"/"+aCurso.getSala().getSala(), aCurso.getProfessor().getNome()});
            }
        }
    }

     public void abrirUltimoEFecharAtual() {
        if ( ! isNull(this.chamador )){
            this.chamador.setVisible(true);
        }
        this.dispose();
    }

    
    private void initComponents() {

        LNomeAluno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCursosDisponiveis = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        LNomeAluno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LNomeAluno.setText("jLabel1");

        tableCursosDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome curso", "Codigo curso", "Predio/sala", "Nome professor"
            	}
        ));
        jScrollPane1.setViewportView(tableCursosDisponiveis);

        jButton1.setText("Matricular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		jButton3.setText("Cancelar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(LNomeAluno))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LNomeAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tableCursosDisponiveis.getSelectedRow();
        Curso curso = aCursos.get(row);
        if (acc.validarQuantidadeCurso(curso)) {
            if (acc.matricularAluno(this.aluno, curso)) {
                JOptionPane.showMessageDialog(null, "Aluno matriculado no curso escolhido");

            } else {
                JOptionPane.showMessageDialog(null, "NÃ£o foi possivel matricular o aluno no curso escolhido");
            }
            abrirUltimoEFecharAtual();
            
        } else {
            JOptionPane.showMessageDialog(null, "Sala atingiu capacidade maxima");

        }

    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		JOptionPane.showMessageDialog(null, "Aluno não matriculado");
		abrirUltimoEFecharAtual();
	}// GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LNomeAluno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCursosDisponiveis;
    // End of variables declaration//GEN-END:variables
}
