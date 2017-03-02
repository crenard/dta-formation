package dta.chat.view;

public class ChatConsoleTitleView extends ViewComposite {

	private String title;

	public ChatConsoleTitleView(String title) {
		this.title = title;
	}

	@Override
	public void print() {
		System.out.println(title);
	}

}
