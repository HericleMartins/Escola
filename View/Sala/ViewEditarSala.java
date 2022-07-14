package View.Sala;

import Controller.SalaController;
import Model.Sala;

import static java.util.Objects.isNull;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class ViewEditarSala extends javax.swing.JInternalFrame {
	private final SalaController sc = new SalaController();
	private Sala sala = new Sala();
	private JInternalFrame chamador;

	public ViewEditarSala(JInternalFrame chamador) {
		initComponents();
		this.chamador = chamador;
	}

	public void montarSala(int codigo) {
		this.sala = this.sc.consultarSalaCodigo(codigo);
		eNomeSala.setText(this.sala.getNome());
		ePredioSala.setText(String.valueOf(this.sala.getPredio()));
		eNumeroSala.setText(String.valueOf(this.sala.getSala()));
		eCapacidadeSala.setText(String.valueOf(this.sala.getCapacidade()));
	}

	public void alterarSala() {
		this.sala.setNome(eNomeSala.getText().trim().isEmpty() ? null : eNomeSala.getText());
		this.sala.setPredio(ePredioSala.getText().trim().isEmpty() ? null : Integer.parseInt(ePredioSala.getText()));
		this.sala.setSala(eNumeroSala.getText().trim().isEmpty() ? null : Integer.parseInt(eNumeroSala.getText()));
		this.sala.setCapacidade(eCapacidadeSala.getText().trim().isEmpty() ? null : Integer.parseInt(eCapacidadeSala.getText()));
		String campos = this.sc.validarCamposSala(sala);
		if (isNull(campos)) {
			if (this.sc.alterarSala(this.sala)) {
				JOptionPane.showMessageDialog(null, "Sala alterada com sucesso");
				abrirUltimoEFecharAtual();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Sala não pode ser alterada");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos necessarios não preenchidos\n" + campos);
		}
	}

	private void abrirUltimoEFecharAtual() {
		if (!isNull(chamador)) {
			chamador.setVisible(true);
		}
		this.dispose();
	}

	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		eNomeSala = new javax.swing.JTextField();
		eNumeroSala = new javax.swing.JTextField();
		eCapacidadeSala = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		ePredioSala = new javax.swing.JTextField();

		jLabel2.setText("Predio:");

		jLabel4.setText("NÂºSala");

		jButton2.setText("Salvar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Cancelar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel5.setText("Capacidade:");

		jLabel3.setText("Nome:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addComponent(eNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addGap(86, 86, 86).addComponent(ePredioSala,
										javax.swing.GroupLayout.PREFERRED_SIZE, 145,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
						.addGroup(
								layout.createSequentialGroup()
										.addComponent(eNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jLabel5)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eCapacidadeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(133, 133, 133).addComponent(jButton2).addGap(29, 29, 29)
						.addComponent(jButton3)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2).addComponent(ePredioSala, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(eNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5).addComponent(eCapacidadeSala,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton3))
						.addContainerGap(27, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		alterarSala();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		JOptionPane.showMessageDialog(null, "Sala não alterada");
		abrirUltimoEFecharAtual();
	}// GEN-LAST:event_jButton3ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField eCapacidadeSala;
	private javax.swing.JTextField eNomeSala;
	private javax.swing.JTextField eNumeroSala;
	private javax.swing.JTextField ePredioSala;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	// End of variables declaration//GEN-END:variables
}
