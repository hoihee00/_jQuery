package jcafe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@WebServlet("/jcafe/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String itemNo = request.getParameter("itemNo");
		ProductDAO dao = new ProductDAO();
		ProductVO vo = dao.getProduct(itemNo);
		response.getWriter().append(JSONArray.fromObject(vo).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
