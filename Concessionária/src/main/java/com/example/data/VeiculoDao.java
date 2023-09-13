package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.model.Veiculo;

public class VeiculoDao {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "rm98837";
    private static final String PASS = "280101";

    public void inserir(Veiculo veiculo) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        
        var sql = "INSERT INTO veiculos (marca, modelo, ano, valor) VALUES (?, ?, ?, ?)";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, veiculo.getMarca());
        comando.setString(2, veiculo.getModelo());
        comando.setInt(3, veiculo.getAno());
        comando.setBigDecimal(4, veiculo.getValor());
        comando.executeUpdate();
        comando.close();
    }
    
}
