package create.singletone.after;

public class SecondPage {
	private Settings settings = Settings.getSettings();
	
	public void printSettings() {
		System.out.println("2ndPage: "+settings.getDarkMode()+" "+settings.getFontSize());
	}
}
