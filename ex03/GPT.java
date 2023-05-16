package ex03;

public abstract class GPT {
    private String name;

    // 생성자
    public GPT(String name) {
        this.name = name;
    }

    // 이름 반환
    public String getName() {
        return this.name;
    }
    public String hello() {
        return "안녕, 내 이름은 " + this.name + "이야";
    }
}
