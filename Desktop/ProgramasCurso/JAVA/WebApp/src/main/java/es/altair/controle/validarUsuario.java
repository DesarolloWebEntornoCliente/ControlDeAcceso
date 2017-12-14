package es.altair.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplHibernate;

/**
 * Servlet implementation class validarUsuario
 */
public class validarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("usuario");
		String password = request.getParameter("password");

		UsuarioDAO uDao = new UsuarioDAOImplHibernate();
		
		Usuario usu = uDao.comprobarUsuario(login, password);
		
		if(usu != null) {
			// usuario Cirrecto - poner el usuario el session //
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuLogeado", usu);
			
			switch (usu.getTipo()) {
			case 0:
				// usuario Normal
				response.sendRedirect("jsp/principalUsu.jsp");
			break;
			case 1:
				response.sendRedirect("jsp/principalAdmin.jsp");

				break;
				

			default:
				break;
			}
			
			System.out.println(usu);
		}else {
			// Usuario Incorrecto
			response.sendRedirect("index.jsp?mensaje=Usuario o Password Incorrecto");
		}
	}

}
