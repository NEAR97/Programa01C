/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.programa01ccc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author braum
 */
public class Programa01CCC {

    public static void main(String[] args) {
        
        Connection con = null;
        Statement st = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/ejemplo1";
            String usr = "postgres";
            String pwd = "123456";
            String sql = "insert into ejemplo1 (clave, nombre, direccion, telefono) values "
                    + " ('02', 'Gabriel', 'Av. 1', '7777')";

            con = DriverManager.getConnection(url, usr, pwd);
            Logger.getLogger(Programa01CCC.class.getName()).log(Level.INFO, "Se conectó...");

            st = con.createStatement();
            boolean res = st.execute(sql);

            if (!res) {
                Logger.getLogger(Programa01CCC.class.getName()).log(Level.INFO, "Se guardó...");
            } else {
                Logger.getLogger(Programa01CCC.class.getName()).log(Level.INFO, "No se guardó...");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Programa01CCC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01CCC.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01CCC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
