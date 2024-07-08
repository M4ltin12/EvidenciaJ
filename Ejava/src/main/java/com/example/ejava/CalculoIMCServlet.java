package com.example.ejava;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class CalculoIMCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        double peso = Double.parseDouble(request.getParameter("peso"));

        if (peso <= 0) {
            response.sendRedirect("calculoIMC.jsp?error=InvalidWeight");
            return;
        }

        // Aquí se obtienen los datos del usuario desde la base de datos (omitido por brevedad)
        double estatura = 1.75; // Simulación de estatura

        double imc = peso / (estatura * estatura);

        // Aquí se guarda el cálculo del IMC en la base de datos (omitido por brevedad)

        response.sendRedirect("calculoIMC.jsp");
    }
}