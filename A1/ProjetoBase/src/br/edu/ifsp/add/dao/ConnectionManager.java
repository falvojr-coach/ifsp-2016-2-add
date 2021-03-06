package br.edu.ifsp.add.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que gerencia uma conexão única com o banco de dados. Para isso, a
 * classe mantem um atributo com a Connection e implementa o padrão de projetos
 * Singleton.
 *
 * @author Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public final class ConnectionManager {

    private static ConnectionManager instancia;

    public static ConnectionManager getInstancia() {
        if (ConnectionManager.instancia == null) {
            ConnectionManager.instancia = new ConnectionManager();
        }
        return ConnectionManager.instancia;
    }

    private ConnectionManager() {
        super();
        this.conexao = this.newConnection();
    }

    private final Connection conexao;

    public Connection getConexao() {
        return this.conexao;
    }

    /**
     * Basta invocar esse método para recebermos uma NOVA conexão pronta para
     * uso. Por isso, limitamos essa chamada ao construtor da classe
     * ConnectionManager, que implementa o padrão de projeto Singleton.
     *
     * @return conexão do tipo Connection.
     */
    private Connection newConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/add_a1", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
