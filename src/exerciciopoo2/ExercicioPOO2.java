/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciopoo2;
import Model.*;
import View.*;
import Controller.*;
/**
 *
 * @author luizf
 */
public class ExercicioPOO2 {

  
    public static void main(String[] args) {
        frmFuncionario viewC = new frmFuncionario();
        FuncionarioDAO modelC= new FuncionarioDAO();
        ControllerCRUD controllerC= new ControllerCRUD(viewC,modelC);
    viewC.setVisible(true);
    viewC.setLocationRelativeTo(null);
    }
    
}
