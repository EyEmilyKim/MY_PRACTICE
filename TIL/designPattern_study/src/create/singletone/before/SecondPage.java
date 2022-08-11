package create.singletone.before;

public class SecondPage {
	private Settings settings = new Settings();
	
	public void printSettings() {
		System.out.println("2ndPage: "+settings.getDarkMode()+" "+settings.getFontSize());
	}
}
