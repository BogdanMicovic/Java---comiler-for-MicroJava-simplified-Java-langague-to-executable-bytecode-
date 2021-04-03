// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyFormParsListRecursive extends FormParsList {

    private FormParsList FormParsList;
    private FormParsListOneTwo FormParsListOneTwo;

    public MyFormParsListRecursive (FormParsList FormParsList, FormParsListOneTwo FormParsListOneTwo) {
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.FormParsListOneTwo=FormParsListOneTwo;
        if(FormParsListOneTwo!=null) FormParsListOneTwo.setParent(this);
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
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
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(FormParsListOneTwo!=null) FormParsListOneTwo.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(FormParsListOneTwo!=null) FormParsListOneTwo.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(FormParsListOneTwo!=null) FormParsListOneTwo.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyFormParsListRecursive(\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsListOneTwo!=null)
            buffer.append(FormParsListOneTwo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyFormParsListRecursive]");
        return buffer.toString();
    }
}
