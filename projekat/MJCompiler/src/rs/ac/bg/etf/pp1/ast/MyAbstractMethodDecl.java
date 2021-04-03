// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyAbstractMethodDecl extends AbstractMethodDecl {

    private MethodDeclTypes MethodDeclTypes;
    private String abstractMethodName;
    private OptFormParsList OptFormParsList;

    public MyAbstractMethodDecl (MethodDeclTypes MethodDeclTypes, String abstractMethodName, OptFormParsList OptFormParsList) {
        this.MethodDeclTypes=MethodDeclTypes;
        if(MethodDeclTypes!=null) MethodDeclTypes.setParent(this);
        this.abstractMethodName=abstractMethodName;
        this.OptFormParsList=OptFormParsList;
        if(OptFormParsList!=null) OptFormParsList.setParent(this);
    }

    public MethodDeclTypes getMethodDeclTypes() {
        return MethodDeclTypes;
    }

    public void setMethodDeclTypes(MethodDeclTypes MethodDeclTypes) {
        this.MethodDeclTypes=MethodDeclTypes;
    }

    public String getAbstractMethodName() {
        return abstractMethodName;
    }

    public void setAbstractMethodName(String abstractMethodName) {
        this.abstractMethodName=abstractMethodName;
    }

    public OptFormParsList getOptFormParsList() {
        return OptFormParsList;
    }

    public void setOptFormParsList(OptFormParsList OptFormParsList) {
        this.OptFormParsList=OptFormParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclTypes!=null) MethodDeclTypes.accept(visitor);
        if(OptFormParsList!=null) OptFormParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclTypes!=null) MethodDeclTypes.traverseTopDown(visitor);
        if(OptFormParsList!=null) OptFormParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclTypes!=null) MethodDeclTypes.traverseBottomUp(visitor);
        if(OptFormParsList!=null) OptFormParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyAbstractMethodDecl(\n");

        if(MethodDeclTypes!=null)
            buffer.append(MethodDeclTypes.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+abstractMethodName);
        buffer.append("\n");

        if(OptFormParsList!=null)
            buffer.append(OptFormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyAbstractMethodDecl]");
        return buffer.toString();
    }
}
