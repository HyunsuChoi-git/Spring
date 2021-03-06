package board.model.vo;
import java.sql.Timestamp;

public class BoardVO {
	
    private int num;
    private String id;
    private String nick;
    private String subject;
    private String content;
    private String img;
    private int ref;
    private int re_step;
    private int re_level;
    private int readcount;
    private Timestamp reg;
    
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public int getRef() {
        return ref;
    }
    public void setRef(int ref) {
        this.ref = ref;
    }
    public int getRe_step() {
        return re_step;
    }
    public void setRe_step(int re_step) {
        this.re_step = re_step;
    }
    public int getRe_level() {
        return re_level;
    }
    public void setRe_level(int re_level) {
        this.re_level = re_level;
    }
    public int getReadcount() {
        return readcount;
    }
    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }
    public Timestamp getReg() {
        return reg;
    }
    public void setReg(Timestamp reg) {
        this.reg = reg;
    }


}