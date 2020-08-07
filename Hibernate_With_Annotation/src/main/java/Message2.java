import javax.persistence.*;

@Entity
@Table(name="MESSAGE2")
public class Message2 {
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;
    @Column(name="MESSAGE_TEXT")
    private String text;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEXT_MESSAGE_ID")
    private Message2 nextMessage;

    private Message2(){}

    public Message2(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message2 getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(Message2 nextMessage) {
        this.nextMessage = nextMessage;
    }
}
