/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author luizf
 */
public class Funcionario {
    String cpf;
          String  nome;
          String  rua;
          String  cargo;
          String  dt_admissao;
          Double  salarioBruto;
    public Funcionario(){
      cpf="";  
      nome="";
      rua="";
      cargo="";
      dt_admissao="";
      salarioBruto=0.0;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(String dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
}
