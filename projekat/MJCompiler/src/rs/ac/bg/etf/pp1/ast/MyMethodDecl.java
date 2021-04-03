// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMethodDecl extends MethodDecl {

    private MethodDeclTypes MethodDeclTypes;
    private String methodName;
    private OptFormParsList OptFormParsList;
    private VarDeclList VarDeclList;
    private StatementList StatementList;

    public MyMethodDecl (MethodDeclTypes MethodDeclTypes, String methodName, OptFormParsList OptFormParsList, VarDeclList VarDeclList, StatementList StatementList) {
        this.MethodDeclTypes=MethodDeclTypes;
        if(MethodDeclTypes!=null) MethodDeclTypes.setParent(this);
        this.methodName=methodName;
        this.OptFormParsList=OptFormParsList;
        if(OptFormParsList!=null) OptFormParsList.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodDeclTypes getMethodDeclTypes() {
        return MethodDeclTypes;
    }

    public void setMethodDeclTypes(MethodDeclTypes MethodDeclTypes) {
        this.MethodDeclTypes=MethodDeclTypes;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName=methodName;
    }

    public OptFormParsList getOptFormParsList() {
        return OptFormParsList;
    }

    public void setOptFormParsList(OptFormParsList OptFormParsList) {
        this.OptFormParsList=OptFormParsList;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclTypes!=null) MethodDeclTypes.accept(visitor);
        if(OptFormParsList!=null) OptFormParsList.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclTypes!=null) MethodDeclTypes.traverseTopDown(visitor);
        if(OptFormParsList!=null) OptFormParsList.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclTypes!=null) MethodDeclTypes.traverseBottomUp(visitor);
        if(OptFormParsList!=null) OptFormParsList.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMethodDecl(\n");

        if(MethodDeclTypes!=null)
            buffer.append(MethodDeclTypes.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methodName);
        buffer.append("\n");

        if(OptFormParsList!=null)
            buffer.append(OptFormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMethodDecl]");
        return buffer.toString();
    }
}
