// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyAssignopRight extends Assignop {

    private RightOp RightOp;

    public MyAssignopRight (RightOp RightOp) {
        this.RightOp=RightOp;
        if(RightOp!=null) RightOp.setParent(this);
    }

    public RightOp getRightOp() {
        return RightOp;
    }

    public void setRightOp(RightOp RightOp) {
        this.RightOp=RightOp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RightOp!=null) RightOp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RightOp!=null) RightOp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RightOp!=null) RightOp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyAssignopRight(\n");

        if(RightOp!=null)
            buffer.append(RightOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyAssignopRight]");
        return buffer.toString();
    }
}
