package coreservlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes" })
	public void doGet(HttpServletRequest request,
			       	  HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart;
		synchronized(session) {
			
			cart = (ShoppingCart)session.getAttribute("shoppingCart");
			
			if (cart == null) {
				cart = new ShoppingCart();
				session.setAttribute("shoppingCart",  cart);
			}
			
			String itemID = request.getParameter("itemID");
			
			if (itemID != null) {
				
				String numItemsString =
						request.getParameter("numItems");
				if (numItemsString == null) {
					cart.addItem(itemID);
					
				} else {

					int numItems;
					try {
						
						numItems = Integer.parseInt(numItemsString);
						
					} catch (NumberFormatException nfe) {
						
						numItems = 1;
						
					}
					
					cart.setNumOrdered(itemID, numItems);
					
				} 
				
			}
			
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Siparisinizin Durumu";
		
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#AFA4A2\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>");
		synchronized(session) {
			
			List itemsOrdered = cart.getItemsOrdered();
			if (itemsOrdered.size() == 0 ) {
				out.println("<H2><I>No items in your cart...</I></H2>");
			} else {
				String itemID = request.getParameter("itemID");
				out.println
					("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
					 "<TR BGCOLOR=\"YELLOW\">\n" +
					 "  <TH>Urun Id<TH>Bilgi\n" +
					 "  <TH>Birim Fiyat<TH>Adet<TH>Toplam Fiyat");
				
				ItemOrder order;
				NumberFormat formatter =
						NumberFormat.getCurrencyInstance();
				for (int i = 0; i < itemsOrdered.size(); i++) {
					
					order = (ItemOrder)itemsOrdered.get(i);
					out.println
						("<TR>\n" +
						 "  <TD>" + order.getItemID() + "\n" +
						 "  <TD>" + order.getShortDescription() + "\n" +
						 "  <TD>" + formatter.format(order.getUnitCost()) + "\n" +
						 "  <TD>" +
						 "<FORM>\n" +
						 "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
						 "		 VALUE=\"" + order.getItemID() + "\">\n" +
						 "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n" +
						 "       SIZE=3 VALUE=\"" +
						 order.getNumItems() + "\">\n" +
						 "<SMALL>\n" +
						 "<INPUT TYPE=\"SUBMIT\"\n " +
						 "		 VALUE=\"Guncelle\"\n" +
						 "</SMALL>\n" +
						 "</FORM>\n" +
						 "  <TD>" +
						 formatter.format(order.getTotalCost()));
					 
				} 
				
				@SuppressWarnings("deprecation")
				String checkoutURL =
						response.encodeUrl("../Checkout.html");
				out.println
					("</TABLE>\n" +
				     "<FORM ACTION=\"" + checkoutURL + "\">\n" +
					 "<BIG><CENTER>\n" +
				     "<INPUT TYPE=\"SUBMIT\"\n" +
					 "		 VALUE=\"Siparis Ver\">\n" +
				     "</CENTER></BIG></FORM>");
				
			} 
			
			out.println("</BODY></HTML>");
			
		} 
		
	} 

} 