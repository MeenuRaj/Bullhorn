

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

import model.Accinfo;
import model.Bullhorn;
import customTools.DBUtil;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		String search = request.getParameter("search");
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Bullhorn bull = new model.Bullhorn();
		if(request.getParameter("action").equals("allposts"))
		{
		String q="select b from Bullhorn b where b.username LIKE '%"+search+"%' or b.post LIKE '%"+search+"%'";
		TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

		List<Bullhorn> list=bq.getResultList();
		message= "<div class=\"container\"><table class=\"table table-striped\"><thead><tr><th>Posts</th></tr></thead><tbody>";
		
		for(Bullhorn temp:list)
		{	
		if(temp.getPost() != null)
		{
			message += "<tr><td>"+temp.getPost()+"</td><td><a href=\"profile?user="+temp.getUsername()+"\">"+temp.getUsername()+"</a></td></tr>\n";
		}
		}
		message+= "</tbody> </table></div>";
		request.setAttribute("message", message);
	getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		}
		else
		{
			HttpSession session1 = request.getSession(true); 
			String username = (String) session1.getAttribute("u_name");
			System.out.println(username);
			String q="select b from Bullhorn b where b.username='"+username+"' and b.post LIKE '%"+search+"%'";
			TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

			List<Bullhorn> list=bq.getResultList();
			message= "<div class=\"container\"><table class=\"table table-striped\"><thead><tr><th>Posts</th></tr></thead><tbody>";
			
			for(Bullhorn temp:list)
			{	
			if(temp.getPost() != null)
			{
				message += "<tr><td>"+temp.getPost()+"</td></tr>\n";
			}
			}
			message+= "</tbody> </table></div>";

			String pro = "";
		 q="select a from Accinfo a where a.fName = '"+username+"'";
			System.out.println(""+q);
			TypedQuery<Accinfo>aq =em.createQuery(q,Accinfo.class);
			System.out.println(""+aq);
			List<Accinfo> list1=aq.getResultList();
			System.out.println("query reult:"+aq.getResultList());
			for(Accinfo temp:list1)
			{	
				pro= "<div class=\"container\"><table class=\"table table-striped\"><thead><tr><th>Name</th><th>Moto</th><th>Join Date</th></tr></thead><tbody>";
				pro+="<tr><td>"+temp.getFName()+"</td><td>"+temp.getMoto()+"</td><td>"+temp.getDates()+"</td></tr>";
				pro+= "</tbody> </table></div>";
			
			}
			
			pro+= "</tbody> </table></div>";
				response.setContentType("text/html");
				request.setAttribute("profile", pro);
			request.setAttribute("posts", message);
		getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
