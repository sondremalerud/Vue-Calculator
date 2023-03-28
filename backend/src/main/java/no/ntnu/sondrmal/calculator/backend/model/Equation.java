package no.ntnu.sondrmal.calculator.backend.model;


import jakarta.persistence.*;

//import javax.persistence.*;

@Entity
@Table(name = "EQUATIONS")
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "expression")

    private String expression;

    @Column(name = "answer")

    private String answer;

    public Equation(String username, String expression, String answer) {
        this.username = username;
        this.expression = expression;
        this.answer = answer;
    }

    public Equation() {

    }

    public long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
