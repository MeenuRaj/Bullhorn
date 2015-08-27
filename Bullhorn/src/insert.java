
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bullhorn;
import customTools.DBUtil;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message="";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	if(request.getParameter("action").equals("add"))
		{
		message = "";
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Bullhorn bull = new model.Bullhorn();
		trans.begin();
		System.out.println(request.getParameter("action"));
		//System.out.println("first");
		try {
			
			//String id = request.getParameter("id");
			//bull.setId(Integer.parseInt(id));
			//System.out.println("2");
			String post = request.getParameter("post");
			bull.setPost(post);
			//System.out.println("3");
			em.persist(bull);
			//System.out.println("4");
			trans.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			trans.rollback();
		} 
		String q="select b from Bullhorn b order by b.id desc";

		TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

		List<Bullhorn> list=bq.getResultList();

		for(Bullhorn temp:list)

		message+=temp.getPost()+"<br>";

		request.setAttribute("message", message);

		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
	}
	
	else if(request.getParameter("action").equals("view"))
	{
		System.out.println("ffff");
		 message = "";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Bullhorn bull = new model.Bullhorn();
		String q="select b from Bullhorn b order by b.id desc";

		TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

		List<Bullhorn> list=bq.getResultList();

		for(Bullhorn temp:list)

			message+=temp.getPost()+"<br>";

		request.setAttribute("message", message);

		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);

	}
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doGet(request, response);
	}

}
