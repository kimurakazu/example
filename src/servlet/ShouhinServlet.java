package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShouhinServlet
 */
@WebServlet("/shouhin")
public class ShouhinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShouhinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		model.ShouhinDAO sdao = new model.ShouhinDAO();
		String num = request.getParameter("num");
		int n = Integer.parseInt(num);
		model.Shouhin s = sdao.findBySid(n);


		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>商品</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>商品ID：" + s.getSid() + "</p>");
		out.println("<p>商品名：" + s.getName() + "</p>");
		out.println("<p>単価：" + s.getTanka() + "円</p>");
		out.println("</body>");
		out.println("</html>");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		model.ShouhinDAO sdao = new model.ShouhinDAO();
		String name = request.getParameter("name");
		String tanka = request.getParameter("tanka");
		int t = Integer.parseInt(tanka);
		model.Shouhin s = new model.Shouhin(0,name,t);
		String url ="http://localhost:8080/example/slist";

		sdao.insert(s);


		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>商品</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p> 商品追加しました。 </p>");
		out.println("<a href="+url+">商品リストへ</a> ");
		out.println("</body>");
		out.println("</html>");

	}

}
