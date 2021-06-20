package coreservlets;

public class TechBooksPage extends CatalogPage{

	private static final long serialVersionUID = 1L;

	public void init() {
		
		String[] ids = { "tech001", "tech002" };
		setItems(ids);
		setTitle("Muhendislik Kitaplari");
		
	} 
	
} 