package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classe.Cliente;

public class DadosCliente {

    public boolean Salvar(Cliente obj) throws SQLException {
        Conexao conecta = new Conexao();

            String sql = "insert into clientes (nome, email, whats) values (?,?,?)";
            PreparedStatement stm = conecta.con.prepareStatement(sql);

            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getEmail());
            stm.setString(3, obj.getWhats());

        int Registros = stm.executeUpdate();

        if(Registros > 0){
            return true;
        }else{
            return false;
        }
    }
}
