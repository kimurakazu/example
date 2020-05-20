package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String midStr = request.getParameter("mid");
		int mid = Integer.parseInt(midStr);
		model.MemberDAO mdao = new model.MemberDAO();
		model.Member m = mdao.findByMid(mid);

		request.setAttribute("member", m);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mupdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			model.MemberDAO mdao = new model.MemberDAO();
			String midStr = request.getParameter("mid");
			String name = request.getParameter("name");
			String adr = request.getParameter("adr");
			int mid = Integer.parseInt(midStr);

			if(name.equals("")) {
				throw new IllegalAccessException("名前を入力してください。");
			}

			if(adr.equals("")) {
				throw new IllegalAccessException("住所を入力してください。");
			}

			mdao.update(new model.Member(mid,name,adr));

			response.sendRedirect("mlist");

		}catch(NumberFormatException | IllegalAccessException e){
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("url", "mlist");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
	}

}
