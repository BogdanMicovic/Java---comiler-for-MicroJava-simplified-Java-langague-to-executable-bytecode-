// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyFormParsListOneTwo extends FormParsListOneTwo {

    private Type Type;
    private String formParName;
    private MulSqBrackets MulSqBrackets;

    public MyFormParsListOneTwo (Type Type, String formParName, MulSqBrackets MulSqBrackets) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formParName=formParName;
        this.MulSqBrackets=MulSqBrackets;
        if(MulSqBrackets!=null) MulSqBrackets.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormParName() {
        return formParName;
    }

    public void setFormParName(String formParName) {
        this.formParName=formParName;
    }

    public MulSqBrackets getMulSqBrackets() {
        return MulSqBrackets;
    }

    public void setMulSqBrackets(MulSqBrackets MulSqBrackets) {
        this.MulSqBrackets=MulSqBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(MulSqBrackets!=null) MulSqBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MulSqBrackets!=null) MulSqBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MulSqBrackets!=null) MulSqBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyFormParsListOneTwo(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formParName);
        buffer.append("\n");

        if(MulSqBrackets!=null)
            buffer.append(MulSqBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyFormParsListOneTwo]");
        return buffer.toString();
    }
}
