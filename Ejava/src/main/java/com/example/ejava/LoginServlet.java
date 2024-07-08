package com.example.ejava;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        // Aquí se valida el usuario en la base de datos (omitido por brevedad)

        boolean loginExitoso = true; // Simulación de login

        if (loginExitoso) {
            HttpSession session = request.getSession();
            session.setAttribute("nombreUsuario", nombreUsuario);
            response.sendRedirect("calculoIMC.jsp");
        } else {
            response.sendRedirect("login.jsp?error=InvalidLogin");
        }
    }
}
