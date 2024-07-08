package com.example.ejava;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IMCHistoricoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario no autenticado");
            return;
        }

        List<IMCRecord> imcRecords = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT fechaMedicion, valorIMC FROM IMC WHERE idUsuario = (SELECT idUsuario FROM Usuario WHERE nombreUsuario = ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombreUsuario);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        IMCRecord record = new IMCRecord();
                        record.setFechaMedicion(rs.getDate("fechaMedicion"));
                        record.setValorIMC(rs.getDouble("valorIMC"));
                        imcRecords.add(record);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error de base de datos");
            return;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print("[");
        for (int i = 0; i < imcRecords.size(); i++) {
            IMCRecord record = imcRecords.get(i);
            out.print("{\"fecha\":\"" + record.getFechaMedicion() + "\", \"imc\":" + record.getValorIMC() + "}");
            if (i < imcRecords.size() - 1) {
                out.print(",");
            }
        }
        out.print("]");
        out.flush();
    }

    private static class IMCRecord {
        private java.sql.Date fechaMedicion;
        private double valorIMC;

        public java.sql.Date getFechaMedicion() {
            return fechaMedicion;
        }

        public void setFechaMedicion(java.sql.Date fechaMedicion) {
            this.fechaMedicion = fechaMedicion;
        }

        public double getValorIMC() {
            return valorIMC;
        }

        public void setValorIMC(double valorIMC) {
            this.valorIMC = valorIMC;
        }
    }
}