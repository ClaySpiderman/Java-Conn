/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testetab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clayton
 */
public class Conn {
    
    private String servidor="localhost:3306";
    private String banco="service";
    private String usuario="root";
    private String senha="";
    
    private Connection conexao;
    private Statement stm;
    private ResultSet rs;
    
    public boolean Connecta(){
        
        try {
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+banco,usuario,senha);
            
            stm = conexao.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return false;
    }
    
    public ArrayList<String> select(){
        Connecta();
        String sqlCode = "select *from automator_clientes";
        
        ArrayList<String> lista = new ArrayList<String>();
        Object[] coluna = new Object[2];
        
        try {
            
            ResultSet rs = stm.executeQuery(sqlCode);
            
            while (rs.next()) {
                lista.add(rs.getString("nome"));
                lista.add(rs.getString("sobrenome"));
            }
            
            
            
         return lista;
         
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return null; 
    }
    
}
