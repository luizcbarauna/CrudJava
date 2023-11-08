/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
  this.viewCRUD.btnLimpar.addActionListener(this);
  this.viewCRUD.btnModificar.addActionListener(this);
  this.viewCRUD.btnExcluir.addActionListener(this);
  this.viewCRUD.btnBuscar.addActionListener(this);
  this.viewCRUD.btnLimpar.addActionListener(this);
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
public void LimparTela(){
    viewCRUD.txtcpf.setText("");
    viewCRUD.txtNome.setText("");
    viewCRUD.txtRua.setText("");
    viewCRUD.txtCargo.setText("");
    viewCRUD.txtdt_Admissao.setText("");
    viewCRUD.txtSalarioBruto.setText("");
}    

public void actionPerformed(ActionEvent e){
    if(e.getSource()== viewCRUD.btnSalvar){
        String cpf = viewCRUD.txtcpf.getText();
        String nome = viewCRUD.txtNome.getText();
        String rua = viewCRUD.txtRua.getText();
        String cargo = viewCRUD.txtCargo.getText();
        String dt_admissao = viewCRUD.txtdt_Admissao.getText();
        Double salarioBruto =Double.parseDouble(viewCRUD.txtSalarioBruto.getText());
        String rptaRegistro = modelCRUD.insertFuncionario(cpf, nome, rua, cargo, dt_admissao, salarioBruto);
        if(rptaRegistro != null){
            JOptionPane.showMessageDialog(null, rptaRegistro);
        }else{
            JOptionPane.showMessageDialog(null,"Registro com problema");
        }
    }
    
if(e.getSource()== viewCRUD.btnListar){
    CreateTable(viewCRUD.jtdados);
    LimparTela();
}
if(e.getSource()==viewCRUD.btnExcluir){
 int RegInicio = viewCRUD.jtdados.getSelectedRow();   
int numReg = viewCRUD.jtdados.getSelectedRowCount();
ArrayList<String> listaCpf = new ArrayList();
String cpf="";
if(RegInicio>=0){
    for(int i=0; i<numReg;i++){
        cpf=String.valueOf(viewCRUD.jtdados.getValueAt(i+RegInicio,0));
        listaCpf.add(cpf);
    }
}
for(int i=0; i<numReg;i++){
    int rptaUser = JOptionPane.showConfirmDialog(null,"Eliminar O registro:"+listaCpf.get(i)+"?");
    if(rptaUser==0){
     modelCRUD.excluirFuncionario(listaCpf.get(i));
    }
}
CreateTable(viewCRUD.jtdados);
}//else{
 //JOptionPane.showMessageDialog(null,"selecione um registro");
//}

    if(e.getSource()==viewCRUD.btnBuscar){
        String Cpf= viewCRUD.txtcpf.getText();
        DefaultTableModel modelT = new DefaultTableModel();
        viewCRUD.jtdados.setModel(modelT);
        
        modelT.addColumn("cpf");
        modelT.addColumn("nome");
        modelT.addColumn("rua");
        modelT.addColumn("cargo");
        modelT.addColumn("dt_admissao");
        modelT.addColumn("salarioBruto");
        Object[] coluna = new Object[6];
        int numRegistros = modelCRUD.searchFuncionario(Cpf).size();
        for(int i= 0; i<numRegistros;i++){
        coluna[0]=modelCRUD.searchFuncionario(Cpf).get(i).getCpf();
        coluna[1]=modelCRUD.searchFuncionario(Cpf).get(i).getNome();
        coluna[2]=modelCRUD.searchFuncionario(Cpf).get(i).getRua();
        coluna[3]=modelCRUD.searchFuncionario(Cpf).get(i).getCargo();
        coluna[4]=modelCRUD.searchFuncionario(Cpf).get(i).getDt_admissao();
        coluna[5]=modelCRUD.searchFuncionario(Cpf).get(i).getSalarioBruto();
        modelT.addRow(coluna);
        }
        }
    if(e.getSource()==viewCRUD.btnModificar){
        int RegUpdate = viewCRUD.jtdados.getSelectedRow();
        int numReg= viewCRUD.jtdados.getSelectedRowCount();
        if(RegUpdate>=0&& numReg==1){
            viewCRUD.txtcpf.setText(String.valueOf(viewCRUD.jtdados.getValueAt(RegUpdate, 0)));
            viewCRUD.txtcpf.setEditable(false);
            viewCRUD.txtNome.setText(String.valueOf(viewCRUD.jtdados.getValueAt(RegUpdate,1)));
            viewCRUD.txtRua.setText(String.valueOf(viewCRUD.jtdados.getValueAt(RegUpdate,2)));
            viewCRUD.txtCargo.setText(String.valueOf(viewCRUD.jtdados.getValueAt(RegUpdate,3)));
            viewCRUD.txtdt_Admissao.setText(String.valueOf(viewCRUD.jtdados.getValueAt(RegUpdate,4)));
            viewCRUD.txtSalarioBruto.setText(String.valueOf(viewCRUD.jtdados.getValueAt(RegUpdate, 5)));
            viewCRUD.btnExcluir.setEnabled(false);
            viewCRUD.btnLimpar.setEnabled(false);
            viewCRUD.btnBuscar.setEnabled(false);
            viewCRUD.btnSalvar.setEnabled(false);
        }else{
          JOptionPane.showMessageDialog(null,"Selecione um Registro");
        }
        if(e.getSource()==viewCRUD.btnModificar){
            String cpf= viewCRUD.txtcpf.getText();
            String nome= viewCRUD.txtNome.getText();
            String rua = viewCRUD.txtRua.getText();
            String cargo= viewCRUD.txtCargo.getText();
            String dt_admissao=viewCRUD.txtdt_Admissao.getText();
            Double salarioBruto=Double.parseDouble(viewCRUD.txtSalarioBruto.getText());
                int rptaModificado = modelCRUD.updateFuncionario(cpf,nome,rua,cargo,dt_admissao,salarioBruto);
            if (rptaModificado>0){
                JOptionPane.showMessageDialog(null, "Registro modificado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Registro não pode ser modificado");
            }
        }LimparTela();
        viewCRUD.txtcpf.setEditable(true);
        viewCRUD.btnExcluir.setEnabled(true);
        viewCRUD.btnLimpar.setEnabled(true);
        viewCRUD.btnSalvar.setEnabled(true);
        viewCRUD.btnBuscar.setEnabled(true);
    }
}
}
