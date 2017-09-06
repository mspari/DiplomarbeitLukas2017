/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mspari.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author marinaspari
 */
public class Databaseconnection
{

    public static void main(String[] args)
    {
        final String hostname = "localhost";
        final String port = "3306";
        final String dbname = "databaseconnection";
        final String user = "root";
        final String password = "1234";

        try
        {
            Connection conn;
            Properties connectionProps = new Properties();
            connectionProps.put("user", user);
            connectionProps.put("password", password);

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
            conn = DriverManager.getConnection(url, connectionProps);

            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM databaseconnection.testconnection;");
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                
                System.out.println(id+ " " + firstname + " " + lastname + " "+ email);
                System.out.println("test2");
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }
}
