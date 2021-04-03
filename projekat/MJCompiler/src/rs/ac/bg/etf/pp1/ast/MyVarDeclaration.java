// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:16


package rs.ac.bg.etf.pp1.ast;

public class MyVarDeclaration extends VarDeclaration {

    private String varName;
    private MultipleSquareBrackets MultipleSquareBrackets;

    public MyVarDeclaration (String varName, MultipleSquareBrackets MultipleSquareBrackets) {
        this.varName=varName;
        this.MultipleSquareBrackets=MultipleSquareBrackets;
        if(MultipleSquareBrackets!=null) MultipleSquareBrackets.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public MultipleSquareBrackets getMultipleSquareBrackets() {
        return MultipleSquareBrackets;
    }

    public void setMultipleSquareBrackets(MultipleSquareBrackets MultipleSquareBrackets) {
        this.MultipleSquareBrackets=MultipleSquareBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleSquareBrackets!=null) MultipleSquareBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleSquareBrackets!=null) MultipleSquareBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleSquareBrackets!=null) MultipleSquareBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyVarDeclaration(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(MultipleSquareBrackets!=null)
            buffer.append(MultipleSquareBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyVarDeclaration]");
        return buffer.toString();
    }
}
