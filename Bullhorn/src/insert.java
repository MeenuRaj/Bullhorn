
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
import javax.servlet.http.HttpSession;

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
		message= "<div class=\"container\"><table class=\"table table-striped\"><thead><tr><th>Posts</th></tr></thead><tbody>";
		HttpSession session = request.getSession(true); 
		String uid = (String) session.getAttribute("username");
	if(request.getParameter("action").equals("add"))
		{
	
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Bullhorn bull = new model.Bullhorn();
		trans.begin();
		try {
			
			String post = request.getParameter("post");
			bull.setPost(post);
			bull.setUsername(uid);
			em.persist(bull);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		} 
		String q="select b from Bullhorn b order by b.id desc";

		TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

		List<Bullhorn> list=bq.getResultList();
		for(Bullhorn temp:list)
			message += "<tr><td>"+temp.getPost()+"</td><td><a href=\"profile?user="+temp.getUsername()+"\">"+temp.getUsername()+"</a></td></tr>\n";
		//message+=temp.getPost()+"<br>";
		message+= "</tbody> </table></div>";
		request.setAttribute("message", message);
	}
	
	else if(request.getParameter("action").equals("view"))
	{

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Bullhorn bull = new model.Bullhorn();
		String q="select b from Bullhorn b order by b.id desc";

		TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

		List<Bullhorn> list=bq.getResultList();

		for(Bullhorn temp:list)
		{	
		if(temp.getPost() != null)
		{
			message += "<tr><td>"+temp.getPost()+"</td><td><a href=\"profile?user="+temp.getUsername()+"\">"+temp.getUsername()+"</a></td></tr>\n";
		}
		}
		message+= "</tbody> </table></div>";
		request.setAttribute("message", message);
	}
	getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
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
