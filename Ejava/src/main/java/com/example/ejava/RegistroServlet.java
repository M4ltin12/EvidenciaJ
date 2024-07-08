package com.example.ejava;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCompleto = request.getParameter("nombreCompleto");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double estatura = Double.parseDouble(request.getParameter("estatura"));

        if (estatura < 1 || estatura > 2.5 || edad < 15) {
            response.sendRedirect("registro.jsp?error=InvalidInput");
            return;
        }

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO Usuario (nombreCompleto, nombreUsuario, password, edad, sexo, estatura) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombreCompleto);
                stmt.setString(2, nombreUsuario);
                stmt.setString(3, password);
                stmt.setInt(4, edad);
                stmt.setString(5, sexo);
                stmt.setDouble(6, estatura);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("registro.jsp?error=DatabaseError");
            return;
        }

        response.sendRedirect("login.jsp");
    }
}