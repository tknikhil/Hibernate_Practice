

public class Message {
	private Long Id;
	private String Text;
	private Message NextMessage;
	
	public Message() {}
	
	public Message(String text) {
		Text = text;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public Message getNextMessage() {
		return NextMessage;
	}
	public void setNextMessage(Message nextMessage) {
		NextMessage = nextMessage;
	}
	

}
