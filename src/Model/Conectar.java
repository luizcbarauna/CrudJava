/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author luizf
 */
public class Conectar {
//construtor padrão
    public Conectar(){
    
}    
public Connection getConnection(){
    //Define uma string url com informações de conexão
    String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_folhadepagamento;user=sa;password=infopag;integratedSecurity=false;encrypt=false; trustServerCertificate=false;";
    //Define uma string driver com o nome da classe do driver JDBC para o SQL Server
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //Tenta carregar a classe do driver usando Class.forName. Se falhar, imprime uma mensagem de erro no console.
    try{
        Class.forName(driver);
    }catch(ClassNotFoundException e) {
        System.out.println("Class.forName error");
        System.out.println(e.getMessage()); 
    }
   //Tenta obter uma conexão com o banco de dados usando DriverManager. Se houver um erro exibe uma mensagem de erro e lança uma exceção RuntimeException
    try{
        return DriverManager.getConnection(url);
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Erro na inserção!\nErro:"+ e.getMessage());
    throw new RuntimeException(e);
    }
}
}   