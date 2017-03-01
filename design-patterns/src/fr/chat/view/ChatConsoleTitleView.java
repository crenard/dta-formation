package fr.chat.view;

public class ChatConsoleTitleView extends ViewComposite {

	private String title;

	public ChatConsoleTitleView(String title) {
		this.title = title;
	}

	@Override
	protected void executeBefore() {
		System.out.println(title);
	}

}
