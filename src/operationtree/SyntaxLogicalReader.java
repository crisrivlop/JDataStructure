package operationtree;

import controlStructure.Stack;



class LogicSyntaxHelper{
	protected int count;
	protected LogicalOperation operator;
	public LogicSyntaxHelper(int pcount, LogicalOperation poperator) {
		// TODO Auto-generated constructor stub
		count = pcount;
		operator = poperator;
	}
	public int getCount() {
		return count;
	}
	public LogicalOperation getOperator(){
		return operator;
	}
}


public class SyntaxLogicalReader {

	LogicalOperation head;
	public static final char BRACKETS_OPEN = '(';
	public static final char BRACKETS_CLOSE = ')';
	private static final String OPERATIONS= "|&X!ND";
	private final LogicalOperationFabric fabric = new LogicalOperationFabric();
	
	
	public SyntaxLogicalReader(String expression) {
		if (expression != null && !expression.equals("")){
			char a = expression.charAt(expression.length()-1);
			if (fabric.isValidToken(a) || a == ')'){
				head = readExpression(0,expression).getOperator();
			}
			else{throw new BadSintaxException("token final no valido");}
		}
		else{
			throw new BadSintaxException("Error: expresion invalida");
		}
	}

	
	/**
	 * Hacer con los not
	 */
	private LogicSyntaxHelper readExpression(int count, String expression){
		Stack<LogicalOperation> operatores = new Stack<>();
		Stack<Character> operations = new Stack<>();
		LogicSyntaxHelper sh;
		char operation;
		boolean lastIsOperation = true;
		boolean tocken;
		for(; count< expression.length();){
			operation = expression.charAt(count);
			if (isValidOperation(operation)){
				if(lastIsOperation){
					if(operation != LogicalOperationFabric.NOT)throw new BadSintaxException("Sintaxis erronea!");
					lastIsOperation = false;
					operateLower(operatores, operations, operation);
					tocken = operation=='v';
					operatores.push(fabric.createSimpleOperator(tocken));
				}
				else{
					lastIsOperation = true;
					operateLower(operatores, operations, operation);
				}
				operations.push(operation);
				count++;
			}
			else if (operation == BRACKETS_OPEN){
				if(!lastIsOperation)throw new BadSintaxException("Expresion invalida a(b...");
				sh = readExpression(count+1, expression);
				count = sh.getCount();
				operatores.push(sh.getOperator());
				lastIsOperation = false;
			}
			else if(operation == BRACKETS_CLOSE){
				if (lastIsOperation)throw new BadSintaxException("Operador " + operations.peek() + " no tiene sentancia a la derecha, choca con \")\"" );
				operatores.push(subEvaluation(operatores, operations));
				return new LogicSyntaxHelper(count+1, operatores.pop());
			}
			else if(fabric.isValidToken(operation)){
				tocken = operation=='v';
				count++;
				operatores.push(fabric.createSimpleOperator(tocken));
				lastIsOperation = false;
			}
			else throw new BadSintaxException("item no conocido: " + operation);
		}
		if (!operations.isEmpty())operatores.push(subEvaluation(operatores, operations));
		return new LogicSyntaxHelper(count, operatores.pop());
	}
	
	private boolean isValidOperation(char operation){
		String tmp = String.format("%s",operation);
		return OPERATIONS.contains(tmp);
	}
	
	public boolean resolve(){
		return head.resolve().getValue();
	}
	
	/*
	 * Opera las colas hasta que la operacion sea mayor o igual
	 */
	private void operateLower(Stack<LogicalOperation> operatores, Stack<Character> operations, char operation){
		while(!operations.isEmpty() && fabric.compare(operations.peek(),operation)){
			operatores.push(fabric.createOperator(operations.pop(), operatores.pop(), operatores.pop()));
		}
	}
	
	private LogicalOperation subEvaluation(Stack<LogicalOperation> operatores, Stack<Character> operations){
		if(!operations.isEmpty()){
			while(!operations.isEmpty()){
				operatores.push(fabric.createOperator(operations.pop(), operatores.pop(), operatores.pop()));
			}
		}
		return operatores.pop();
	}
}
