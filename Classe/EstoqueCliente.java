package Classe;

import Banco.Conexao;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueCliente {
    int id_produto;
    String nome_mec;
    int qtd_merc;
    double valor;
    boolean merc_generico;
    boolean remedio;


    public int getId_produto(){
        return id_produto;
    }

    public String getNome_mec(){
        return nome_mec;
    }


    public int getQtd_merc() {
        return qtd_merc;
    }

    public double getValor() {
        return valor;
    }

    public boolean getMerc_generico() {
        return merc_generico;
    }

    public boolean getRemedio() {
        return remedio;
    }

    public void setId_produto(int id_produto){
        this.id_produto = id_produto;
    }

    public void setNome_mec(String nome_mec){
        this.nome_mec = nome_mec;
    }
    public void setQtd_merc(int qtd_merc) {
        this.qtd_merc = qtd_merc;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMerc_generico(boolean merc_generico){
        this.merc_generico = merc_generico;
    }

    public void setRemedio(boolean remedio) {
        this.remedio = remedio;
    }
    public void descontomedicamentGeneric (double perc) {
        this.valor += this.valor * perc/100;
    }

    Conexao conecta = new Conexao();

    public void insert() {
        try {
            conecta.conectar();
            String sql = "insert into produtos (nome_mec, qtd_merc, valor, merc_generico, remedio) values (?,?,?,?,?)";
            PreparedStatement stm = conecta.con.prepareStatement(sql);

            stm.setString(1,nome_mec);
            stm.setInt(2,qtd_merc);
            stm.setDouble(3,valor);
            stm.setBoolean(4,merc_generico);
            stm.setBoolean(5,remedio);


            stm.execute();

            System.out.println("Dados cadastrados com sucesso!");
            stm.close();

        }catch(SQLException erro) {
            System.out.println("Erro, não foi possível cadastrar."+erro);
        }
    }

    public void consultar () {
        try {
            conecta.conectar();
            String sql = "select nome_mec, qtd_merc, valor, merc_generico, remedio id_produto from produtos where id_produto = ?";

            PreparedStatement stm = conecta.con.prepareStatement(sql);
            stm.setInt(1, id_produto);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                this.setNome_mec(rs.getString("nome"));
                this.setQtd_merc(rs.getInt("Quantidade de Mercadoria"));
                this.setValor(rs.getDouble("Valor"));
                this.setMerc_generico(rs.getBoolean("É remédio génerio?"));
                this.setRemedio(rs.getBoolean("É remédio: "));
            }
            stm.close();
        } catch (SQLException erro) {
            System.out.println("Não foi possivel encontrar os dados." +erro);
        }
    }

    public void atualizar (String nome_mec, int qtd_merc, double valor, boolean merc_generico, boolean remedio) {
        System.out.println(nome_mec);
        try {
            conecta.conectar();
            String sql = ("UPDATE produtos SET nome_mec= '" +nome_mec+"', qtd_merc= '"+qtd_merc+"', valor= '"+valor+"', merc_generico= '"+merc_generico+"', remedio= '"+remedio+"' WHERE id_produto=" +id_produto+";");

            PreparedStatement stm = conecta.con.prepareStatement(sql);

            stm.executeUpdate();

            System.out.println("Dados atualizados com sucesso");

        } catch (SQLException erro) {
            System.out.println("Erro não foi possivel atualizar os dados."+erro);
        }
    }

    public void excluir () {
        try{
            conecta.conectar();
            String sql = "delete from produtos where id_produto = ?";

            PreparedStatement stm = conecta.con.prepareStatement(sql);

            stm.setInt(1, id_produto);
            stm.execute();

            System.out.println("Dados excluidos com sucesso");

        } catch (SQLException erro) {
            System.out.println("Erro não foi possivel excluir os dados."+erro);
        }
    }

}

