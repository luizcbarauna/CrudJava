/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luizf
 */
public class ControllerCRUD implements ActionListener{
    frmFuncionario viewCRUD = new frmFuncionario();
    FuncionarioDAO modelCRUD = new FuncionarioDAO();
public ControllerCRUD(frmFuncionario viewCRUD, FuncionarioDAO modelCRUD){
 this.modelCRUD = modelCRUD;
 this.viewCRUD = viewCRUD;
 this.viewCRUD.btnSalvar.addActionListener(this);
  this.viewCRUD.btnListar.addActionListener(this);
    
}
public void InicializarCRUD(){}
public void CreateTable(JTable tableD){
    DefaultTableModel modelT = new DefaultTableModel();
    tableD.setModel(modelT);
    modelT.addColumn("cpf");
    modelT.addColumn("nome");
    modelT.addColumn("rua");
    modelT.addColumn("cargo");
    modelT.addColumn("dt_admissao");
    modelT.addColumn("salarioBruto");
Object[] coluna = new Object[6];
int numRegistros = modelCRUD.listaFuncionario().size();

for (int i=0; i<numRegistros; i++){
    coluna[0] = modelCRUD.listaFuncionario().get(i).getCpf();
    coluna[1] = modelCRUD.listaFuncionario().get(i).getNome();
    coluna[2] =modelCRUD.listaFuncionario().get(i).getRua();
    coluna[3]= modelCRUD.listaFuncionario().get(i).getCargo();
    coluna[4]= modelCRUD.listaFuncionario().get(i).getDt_admissao();
    coluna[5]=modelCRUD.listaFuncionario().get(i).getSalarioBruto();
    modelT.addRow(coluna);
}
}
public void actionPerformed(ActionEvent e){
    if(e.getSource()== viewCRUD.btnSalvar){
        String cpf = viewCRUD.txtcpf.getText();
        String nome = viewCRUD.txtNome.getText();
        String rua = viewCRUD.txtRua.getText();
        String cargo = viewCRUD.txtCargo.getText();
        String dt_admissao = viewCRUD.txtdt_Admissao.getText();
        Double salarioBruto =Double.parseDouble(viewCRUD.txtSalarioBruto.getText());
        String rptaRegistro = modelCRUD.InsertFuncionario(cpf, nome, rua, cargo, dt_admissao, salarioBruto);
        if(rptaRegistro != null){
            JOptionPane.showMessageDialog(null, rptaRegistro);
        }else{
            JOptionPane.showMessageDialog(null,"Registro com problema");
        }
    }
if(e.getSource()== viewCRUD.btnListar){
    CreateTable(viewCRUD.jtdados);
}
}
}