package cl.inacap.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.ConsolasDAO;
import cl.inacap.zCapModel.dao.ConsolasDAOLocal;
import cl.inacap.zCapModel.dao.JuegosDAOLocal;
import cl.inacap.zCapModel.dto.Consola;
import cl.inacap.zCapModel.dto.Juego;

/**
 * Servlet implementation class AgregarJuegoController
 */
@WebServlet("/AgregarJuegoController.do")
public class AgregarJuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject 
       private ConsolasDAOLocal consolasDAO;
       @Inject
       private JuegosDAOLocal juegosDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarJuegoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Consola> consolas = consolasDAO.getAll();
		request.setAttribute("consolas", consolas);
		request.getRequestDispatcher("WEB-INF/vistas/agregarJuego.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreTxt = request.getParameter("nombre-txt").trim();
		String descripcionTxt = request.getParameter("descripcion-txt").trim();
		String consolaTxt = request.getParameter("consola-select").trim();
		String aptoTxt = request.getParameter("apto-radio").trim();
		String precioTxt = request.getParameter("precio-txt").trim();
		String fechaTxt = request.getParameter("fecha-txt").trim();
		int precio=0;
		LocalDate fecha;
		Consola consola = null;
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		
		List<Consola> consolasFiltradas = consolasDAO.filterBynName(consolaTxt);
		
		fecha = LocalDate.parse(fechaTxt,formater);
		if(!consolasFiltradas.isEmpty()) {
			consola = consolasFiltradas.get(0);
		}
		
		precio = Integer.parseInt(precioTxt);
		Juego juego = new Juego();
		juego.setNombre(nombreTxt);
		juego.setDescripccion(descripcionTxt);
		juego.setConsola(consola);
		juego.setAptoNinios(aptoTxt.equals("si"));
		juego.setPrecio(precio);
		juego.setFechaLanza(fecha);
		
		juegosDAO.save(juego);
		request.setAttribute("mensaje", "Juego registrado"); 
				
		doGet(request, response);
	}

}
