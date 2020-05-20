package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/mlist")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		model.MemberDAO mdao = new model.MemberDAO();
		ArrayList<model.Member> mlist = mdao.findAll();

		request.setAttribute("list", mlist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mlist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			model.MemberDAO mdao = new model.MemberDAO();
			String name = request.getParameter("name");
			String adr = request.getParameter("adr");

			if(name.equals("")) {
				request.setAttribute("msg", "名前を入力してください。");
				request.setAttribute("url", "mlist");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}

			if(adr.equals("")) {
				request.setAttribute("msg", "住所を入力してください。");
				request.setAttribute("url", "mlist");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}

			if(name.length() != 0 && adr.length() != 0) {
				mdao.Insert(new model.Member(0,name,adr));
			}

			response.sendRedirect("mlist");

		}catch(NumberFormatException e){
				request.setAttribute("msg", "");
				request.setAttribute("url", "mlist");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
	}

}
