package ensyu_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ensyu_model.Memo;
import ensyu_model.MemoDao;

/**
 * Servlet implementation class MemoServlet
 */
@WebServlet("/memo")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String midStr = request.getParameter("mid");
		int mid = Integer.parseUnsignedInt(midStr);

		MemoDao mdao = new MemoDao();
		Memo m = mdao.findByMid(mid);

		request.setAttribute("memo", m);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ensyu_jsp/memo.jsp");
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
