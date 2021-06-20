package coreservlets;

public class KidsBooksPage extends CatalogPage {

	private static final long serialVersionUID = 1L;

	public void init() {
		
		String[] ids = { "dede001", "hacicavcav001", "yurekdede001" };
		setItems(ids);
		setTitle("100 Temel Eser");
		
	} 
	
} 