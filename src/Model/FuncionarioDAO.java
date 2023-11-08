package Model;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author luizf
 */
public class FuncionarioDAO {
    Conectar conectar;
 //construtor instanciando variavel conectar
    public FuncionarioDAO(){
        conectar=new Conectar();
    }
    //metodo para inserir um funcionario no banco de dados
    public String insertFuncionario(String cpf,String  nome,String  rua,String  cargo,String  dt_admissao,Double  salarioBruto){
        String respReg = null;
        //tenta obter conexão com o banco de dados
        try{
            Connection acessoDB= conectar.getConnection();
            //Prepara uma chamada de um procedure no banco de dados com todos os parametros 
        CallableStatement cs =acessoDB.prepareCall("{call SP_InsertFuncionario(?,?,?,?,?,?)}");
           //define o valor dos parametros da procedure
        cs.setString(1,cpf);
        cs.setString(2, nome);
        cs.setString(3, rua);
        cs.setString(4, cargo);
        cs.setString(5, dt_admissao);
        cs.setDouble(6, salarioBruto);
        //executa a procedure
        int numRegAfetados=cs.executeUpdate();
        //se criou algum registro novo exibe a mensagem registro gravado
        if(numRegAfetados>0){
            respReg="Registro gravado";
        }
        //exibe o erro em caso de exceção
        }catch (Exception e){
            
        }
        //retorna a resposta
        return respReg;
    }

   //declara um metodo de uma lista de objetos funcionario
    public ArrayList<Funcionario> listaFuncionario(){
        //declara e inicializa um ArrayList chamado listaFuncionario que armazenará os objetos Funcionario.
        ArrayList listaFuncionario;
        listaFuncionario = new ArrayList();
        //declara uma variavel do tipo funcionario
        Funcionario funcionario;
        //tenta obter coneção com o banco de dados
        try{
            Connection acessoDB = conectar.getConnection();
            //comando sql para buscar os registros no banco
            PreparedStatement ps = acessoDB.prepareStatement("select cpf, nome, rua, cargo, dt_admissao, salarioBruto from TB_funcionario");
            //executa o comando sql
            ResultSet rs = ps.executeQuery();
            //executa a instrução e grava todos os usuarios
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
            //captura a exceçao caso ocorra
        }catch(Exception e){
        }
        //retorna a lista
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