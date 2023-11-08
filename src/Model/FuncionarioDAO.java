package Model;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author luizf
 */
public class FuncionarioDAO {
    Conectar conectar;
    public FuncionarioDAO(){
        conectar=new Conectar();
    }
    public String insertFuncionario(String cpf,String  nome,String  rua,String  cargo,String  dt_admissao,Double  salarioBruto){
        String respReg = null;
        try{
            Connection acessoDB= conectar.getConnection();
        CallableStatement cs =acessoDB.prepareCall("{call SP_InsertFuncionario(?,?,?,?,?,?)}");
        cs.setString(1,cpf);
        cs.setString(2, nome);
        cs.setString(3, rua);
        cs.setString(4, cargo);
        cs.setString(5, dt_admissao);
        cs.setDouble(6, salarioBruto);
        int numRegAfetados=cs.executeUpdate();
        if(numRegAfetados>0){
            respReg="Registro gravado";
        }
        }catch (Exception e){
            
        }
        return respReg;
    }

   
    public ArrayList<Funcionario> listaFuncionario(){
        ArrayList listaFuncionario;
        listaFuncionario = new ArrayList();
        Funcionario funcionario;
        try{
            Connection acessoDB = conectar.getConnection();
            PreparedStatement ps = acessoDB.prepareStatement("select cpf, nome, rua, cargo, dt_admissao, salarioBruto from TB_funcionario");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setCpf(rs.getString(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setRua(rs.getString(3));
                funcionario.setCargo(rs.getString(4));
                funcionario.setDt_admissao(rs.getString(5));
                funcionario.setSalarioBruto(rs.getDouble(6));
                listaFuncionario.add(funcionario);
            }
        }catch(Exception e){
        }
        return listaFuncionario;
    }
 public int excluirFuncionario(String cpf)
 {int numReg=0;
 try{
     Connection acessoDB = conectar.getConnection();
      CallableStatement cs =acessoDB.prepareCall("{call SP_DeleteFuncionario(?)}");
      cs.setString(1,cpf);
      numReg=cs.executeUpdate();
 }catch(Exception e){
        
 }
     return numReg;
 }
public ArrayList<Funcionario> searchFuncionario(String cpf){
    ArrayList<Funcionario> listaFuncionario = new ArrayList();
    Funcionario funcionario;
    try{
         Connection acessoDB = conectar.getConnection();
         CallableStatement cs =acessoDB.prepareCall("{call SP_searchFuncionario(?)}");
         cs.setString(1, cpf);
         ResultSet rs =cs.executeQuery();
         while(rs.next()){
             funcionario = new Funcionario();
             funcionario.setCpf(rs.getString(1));
             funcionario.setNome(rs.getString(2));
             funcionario.setRua(rs.getString(3));
             funcionario.setCargo(rs.getString(4));
             funcionario.setDt_admissao(rs.getString(5));
             funcionario.setSalarioBruto(rs.getDouble(6));
             listaFuncionario.add(funcionario);
         }
         }catch(Exception e){
                 }
         return listaFuncionario;
    }
public int updateFuncionario(String cpf, String nome, String rua, String cargo, String dt_admissao, Double salarioBruto){
    int numReg=0;
    try{ 
        Connection acessoDB= conectar.getConnection();
        CallableStatement cs =acessoDB.prepareCall("{call SP_updateFuncionario(?,?,?,?,?,?)}");
        cs.setString(1,cpf);
        cs.setString(2, nome);
        cs.setString(3, rua);
        cs.setString(4, cargo);
        cs.setString(5, dt_admissao);
        cs.setDouble(6, salarioBruto);
        numReg=cs.executeUpdate();
    }catch(Exception e){
}
    return numReg;
}
}