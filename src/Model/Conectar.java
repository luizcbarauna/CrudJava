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
public Conectar(){
    
}    
public Connection getConnection(){
    String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_folhadepagamento;user=sa;password=infopag;integratedSecurity=true;";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    try{
        Class.forName(driver);
    }catch(ClassNotFoundException e) {
        System.out.println("Class.forName error");
        System.out.println(e.getMessage()); 
    }
    try{
        return DriverManager.getConnection(url);
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Erro na inserção!\nErro:"+ e.getMessage());
    throw new RuntimeException(e);
    }
}
}   