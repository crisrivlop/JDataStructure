package operationtree;

public class LogicalOperationFabric implements FabricOperator{
	
	public final static char OR = '|';
	public final static char AND = '&';
	public final static char XOR = 'X';
	public final static char NOT = '!';
	public final static char XNOR = 'N';
	public final static char NAND = 'D';
	
	

	public LogicalOperation createOperator(char operation, LogicalOperation left, LogicalOperation right) {
		// TODO Auto-generated method stub
		LogicalOperation operator = null;
        switch (operation) {
		case OR:
			operator = new OperationOr(left, right);
			break;
		case AND:
			operator = new OperationAnd(left, right);
			break;
		case XOR:
			operator = new OperationXor(left, right);
			break;
		case XNOR:
			operator = new OperationXnor(left,right);
			break;
		case NAND:
			operator = new OperationNand(left, right);
			break;
		default:
			break;
		}
        if (operator == null){
        	throw  new BadSintaxException("Error: no se conoce el caracter \"" + operation + "\"");
        }
        return operator;
	}

	public LogicalOperation createSimpleOperator(boolean pdato) {
		// TODO Auto-generated method stub
		return new SimpleLogicalOperation(pdato);
	}

	@Override
	public boolean isValidToken(char logicalValue) {
		switch (logicalValue) {
		case 'f':
			break;
		case 'v':
			break;
		default:
			return false;
		}
		return true;
	}

	@Override
	public boolean compare(char oper1, char oper2){
		Operator operator1 = this.createOperator(oper1, null, null);
		Operator operator2 = this.createOperator(oper2, null, null);
		return operator1.getPriority() > operator2.getPriority(); 
	}

}






/*
 * ================================================================================
 * Operations
 * ================================================================================ 
 */

interface LogicalOperation extends Operator{
	@Override
	public SimpleLogicalOperation resolve();
}



class SimpleLogicalOperation extends SimpleOperator implements LogicalOperation{
	private boolean dato;
	
	public SimpleLogicalOperation(boolean pdato) {
		// TODO Auto-generated constructor stub
		dato = pdato;
	}
	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		return this;
	}
	public boolean getValue(){
		return dato;
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
}




class OperationAnd implements LogicalOperation{
	private LogicalOperation a,b;
	
	public OperationAnd(LogicalOperation first, LogicalOperation second) {
		// TODO Auto-generated constructor stub
		a=first;
		b=second;
	}

	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		return new SimpleLogicalOperation(a.resolve().getValue() && b.resolve().getValue());
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}



class OperationOr implements LogicalOperation{

	private LogicalOperation a,b;
	
	public OperationOr(LogicalOperation first, LogicalOperation second) {
		// TODO Auto-generated constructor stub
		a=first;
		b=second;
	}

	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		return new SimpleLogicalOperation(a.resolve().getValue() || b.resolve().getValue());
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}



class OperationXor implements LogicalOperation{
	private LogicalOperation a,b;

	public OperationXor(LogicalOperation first, LogicalOperation second) {
		// TODO Auto-generated constructor stub
		a=first;
		b=second;
	}
	
	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		boolean first,second;
		first = a.resolve().getValue();
		second = b.resolve().getValue();
		return new SimpleLogicalOperation(!(first && second) && second || first);
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}
}




class OperationNand implements LogicalOperation{
	private LogicalOperation a,b;
	
	public OperationNand(LogicalOperation first, LogicalOperation second) {
		// TODO Auto-generated constructor stub
		a=first;
		b=second;
	}

	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		return new SimpleLogicalOperation(!(a.resolve().getValue() && b.resolve().getValue()));
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 2;
	}
}





class OperationNor implements LogicalOperation{
	private LogicalOperation a,b;
	
	public OperationNor(LogicalOperation first, LogicalOperation second) {
		// TODO Auto-generated constructor stub
		a=first;
		b=second;
	}

	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		return new SimpleLogicalOperation(!(a.resolve().getValue() || b.resolve().getValue()));
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}
}




class OperationXnor implements LogicalOperation{
	private LogicalOperation a,b;

	public OperationXnor(LogicalOperation first, LogicalOperation second) {
		// TODO Auto-generated constructor stub
		a=first;
		b=second;
	}
	
	@Override
	public SimpleLogicalOperation resolve() {
		// TODO Auto-generated method stub
		boolean first,second;
		first = a.resolve().getValue();
		second = b.resolve().getValue();
		return new SimpleLogicalOperation(first && second || !(second || first));
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}
}