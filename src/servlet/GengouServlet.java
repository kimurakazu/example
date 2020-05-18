package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gengou;

/**
 * Servlet implementation class GengouServlet
 */
@WebServlet("/gengou")
public class GengouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GengouServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gengouStr = request.getParameter("gengou");
		String nenStr = request.getParameter("nen");
		int gengou = Integer.parseInt(gengouStr);
		int nen = Integer.parseInt(nenStr);

		request.setAttribute("gengou", new Gengou(gengou,nen));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gengou.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
