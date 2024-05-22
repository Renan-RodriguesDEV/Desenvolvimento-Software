package conexao_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renan
 */
public class ConexaoBanco {
    static final String USER = "root";
    static final String URL = "jdbc:mysql://localhost:3306/utoopy";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection cnx = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(URL, USER, PASS);
            if (cnx != null) {
                System.out.println("Connection succes");
                ResultSet rs = cnx.createStatement().executeQuery("select * from clientes");
                while (rs.next()) {
                    System.out.println("Nome: " + rs.getString("nome_cliente"));
                }
            } else {
                System.out.println("Failed connection");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found " + ex.getMessage());
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Not possible connection in jdbc " + ex.getMessage());
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            if (cnx != null) {
                try {
                    cnx.close();
                    System.out.println("finish connection");
                } catch (SQLException ex) {
                    System.out.println("Ocorreu um erro: " + ex.getMessage());
                    Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }

    }
}
