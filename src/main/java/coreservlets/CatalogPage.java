package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class CatalogPage extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private CatalogItem[] items;
	private String[] itemIDs;
	private String title;
	
	protected void setItems(String[] itemIDs) {
		
		this.itemIDs = itemIDs;
		items = new CatalogItem[itemIDs.length];
		for(int i = 0; i < items.length; i++)
			items[i] = Catalog.getItem(itemIDs[i]);
		
	} 
	
	protected void setTitle(String title) {
		this.title = title;
	}
	
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		if (items == null) {
			
			response.sendError(response.SC_NOT_FOUND, "Missing Items.");
			return;
		
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#AFA4A2\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>");
		CatalogItem item;
		for(int i = 0; i < items.length; i++) {
			
			out.println("<HR>");
			item = items[i];
			if ( item == null ) {
				
				out.println("<FONT COLOR=\"RED\">" +
							"Unknown item ID " + itemIDs[i] +
							"</FONT>");
				
			} else {
				
				out.println();
				String formURL =
						"/yeni/servlet/OrderPage";
				formURL = response.encodeURL(formURL);
				out.println(
						"<FORM ACTION=\"" + formURL + "\">\n" +
						"<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
						"       VALUE=\"" + item.getItemID() + "\">\n" +
						"<H2>" + item.getShortDescription() +
						" ($" + item.getCost() + ")</H2>\n" +
						item.getLongDescription() + "\n" +
						"<P>\n<CENTER>\n" +
						"<INPUT TYPE = \"SUBMIT\" " +
						"VALUE=\"Ekle\">\n" +
						"</CENTER>\n<P>\n</FORM>");
						
			}
			
		}
		
		out.println("<HR>\n</BODY></HTML>");
		
	}
	
}