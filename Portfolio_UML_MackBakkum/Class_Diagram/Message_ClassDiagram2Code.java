public class Message {

    private int messageId;
    private User sender;
    private User receiver;
    private LocalDateTime dateTime;
    private String subject;
    private String messageContent;
    private int threadId;
    private boolean isRead;
    private boolean archivedBySender;
    private boolean archivedByReceiver;

    // Temporary fields, utlizied for displaying the name correctly in the messageDetails page
    private String senderFullName;
    private String senderCompanyName;
    private String receiverFullName;
    private String receiverCompanyName;

    public Message(int messageId, User sender, User receiver, LocalDateTime dateTime, String subject, String messageContent, int threadId, boolean isRead, boolean archivedBySender, boolean archivedByReceiver) {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.dateTime = dateTime;
        this.subject = subject;
        this.messageContent = messageContent;
        this.threadId = threadId;
        this.isRead = isRead;
        this.archivedBySender = archivedBySender;
        this.archivedByReceiver = archivedByReceiver;
    }

    public Message() {
        this(0, null, null, LocalDateTime.now(), "default", "ignore", 0, false, false, false);
    }

    @Override
    public String toString() {
        return "Message toString:\n ID: " + messageId + ",\n Sender: " + (sender != null ? sender.getUsername() : "null") +
                ",\n Receiver: " + (receiver != null ? receiver.getUsername() : "null") +
                ",\n DateTime: " + dateTime + ",\n Subject: " + subject + ",\n MessageContent: " + messageContent +
                ",\n Thread: " + threadId + ",\n IsRead: " + isRead + ",\n ArchivedBySender: " + archivedBySender +
                ",\n ArchivedByReceiver: " + archivedByReceiver;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Message message = (Message) obj;

        if (messageId != message.messageId) return false;
        return Objects.equals(sender, message.sender) &&
                Objects.equals(receiver, message.receiver) &&
                threadId == message.threadId &&
                isRead == message.isRead
                && archivedBySender == message.archivedBySender
                && archivedByReceiver == message.archivedByReceiver;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + threadId;
        result = 31 * result + (isRead ? 1: 0);
        result = 31 * result + (archivedBySender ? 2: 0);
        result = 31 * result + (archivedByReceiver ? 3: 0);
        return result;
    }
}