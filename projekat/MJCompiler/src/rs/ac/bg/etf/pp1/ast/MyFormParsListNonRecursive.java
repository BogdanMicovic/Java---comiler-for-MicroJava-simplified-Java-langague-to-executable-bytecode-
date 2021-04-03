// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyFormParsListNonRecursive extends FormParsList {

    private FormParsListOneTwo FormParsListOneTwo;

    public MyFormParsListNonRecursive (FormParsListOneTwo FormParsListOneTwo) {
        this.FormParsListOneTwo=FormParsListOneTwo;
        if(FormParsListOneTwo!=null) FormParsListOneTwo.setParent(this);
    }

    public FormParsListOneTwo getFormParsListOneTwo() {
        return FormParsListOneTwo;
    }

    public void setFormParsListOneTwo(FormParsListOneTwo FormParsListOneTwo) {
        this.FormParsListOneTwo=FormParsListOneTwo;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsListOneTwo!=null) FormParsListOneTwo.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsListOneTwo!=null) FormParsListOneTwo.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsListOneTwo!=null) FormParsListOneTwo.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyFormParsListNonRecursive(\n");

        if(FormParsListOneTwo!=null)
            buffer.append(FormParsListOneTwo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyFormParsListNonRecursive]");
        return buffer.toString();
    }
}
