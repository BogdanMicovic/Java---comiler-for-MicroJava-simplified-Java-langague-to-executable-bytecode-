// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:16


package rs.ac.bg.etf.pp1.ast;

public class MyConstantDeclarationsRecursive extends ConstantDeclarations {

    private ConstantDeclarations ConstantDeclarations;
    private ConstantDeclaration ConstantDeclaration;

    public MyConstantDeclarationsRecursive (ConstantDeclarations ConstantDeclarations, ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclarations=ConstantDeclarations;
        if(ConstantDeclarations!=null) ConstantDeclarations.setParent(this);
        this.ConstantDeclaration=ConstantDeclaration;
        if(ConstantDeclaration!=null) ConstantDeclaration.setParent(this);
    }

    public ConstantDeclarations getConstantDeclarations() {
        return ConstantDeclarations;
    }

    public void setConstantDeclarations(ConstantDeclarations ConstantDeclarations) {
        this.ConstantDeclarations=ConstantDeclarations;
    }

    public ConstantDeclaration getConstantDeclaration() {
        return ConstantDeclaration;
    }

    public void setConstantDeclaration(ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclaration=ConstantDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstantDeclarations!=null) ConstantDeclarations.accept(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantDeclarations!=null) ConstantDeclarations.traverseTopDown(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantDeclarations!=null) ConstantDeclarations.traverseBottomUp(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyConstantDeclarationsRecursive(\n");

        if(ConstantDeclarations!=null)
            buffer.append(ConstantDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstantDeclaration!=null)
            buffer.append(ConstantDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyConstantDeclarationsRecursive]");
        return buffer.toString();
    }
}
