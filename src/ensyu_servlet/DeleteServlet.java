package ensyu_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ensyu_model.Res;
import ensyu_model.ResDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/keijiban_del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ResDAO rdao = new ResDAO();
		String numberStr = request.getParameter("number");

		if(numberStr==null) {
			response.sendRedirect("keijibn_home");
			return;
		}

		int number = Integer.parseInt(numberStr);
		Res r = rdao.findByNumber(number);


		request.setAttribute("Res", r);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ensyu_jsp/keijiban_del.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ResDAO rdao = new ResDAO();
		String numberStr = request.getParameter("number");
		int number = Integer.parseInt(numberStr);

		rdao.delete(number);

		response.sendRedirect("keijiban_home");
	}

}
