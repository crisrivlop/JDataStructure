package operationtree;

/**
 * 
 * @author cristianrivera
 *
 */

import controlStructure.Stack;


class SyntaxHelper{
	protected int count;
	protected ArithmeticalOperator operator;
	public SyntaxHelper(int pcount, ArithmeticalOperator poperator) {
		// TODO Auto-generated constructor stub
		count = pcount;
		operator = poperator;
	}
	public int getCount() {
		return count;
	}
	public ArithmeticalOperator getOperator(){
		return operator;
	}
	
}

public class SyntaxArithmeticReader {
	

	private ArithmeticalOperator head;
	
	public static final char PLUS = '+';
	public static final char EXPONENT = '^';
	public static final char ROOT = 'r';
	public static final char MINUS = '-';
	public static final char DIVIDE = '/';
	public static final char MULTIPLY = '*';
	private static final String alloperation = "+-*/^r";
	private static final String numbers = "0123456789";
	public static final char BRACKETS_OPEN = '(';
	public static final char BRACKETS_CLOSE = ')';
	private final ArithmeticalOperatorFabric fabric = new ArithmeticalOperatorFabric();
	
	
	public SyntaxArithmeticReader(String expression) {
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
	 * Existe problemas con los numeros negativos
	 * cuando el numero negativo esta delante de un parentesis
	 * <<Solucionado>>
	 */
	private SyntaxHelper readExpression(int count, String expression){
		Stack<ArithmeticalOperator> operatores = new Stack<>();
		Stack<Character> operations = new Stack<>();
		SyntaxHelper sh;
		char operation;
		boolean lastIsOperation = true;
		for(; count< expression.length();){
			operation = expression.charAt(count);
			if (isValidOperation(operation)){
				if(lastIsOperation){
					if(operation != MINUS)throw new BadSintaxException("Sintaxis erronea!");
					operation = MULTIPLY;
					lastIsOperation = false;
					operateLower(operatores, operations, operation);
					operatores.push(fabric.createSimpleOperator(-1));
				}
				else{
					lastIsOperation = true;
					operateLower(operatores, operations, operation);
				}
				operations.push(operation);
				count++;
			}
			else if (operation == BRACKETS_OPEN){
				if(!lastIsOperation)operations.push(MULTIPLY);;
				sh = readExpression(count+1, expression);
				count = sh.getCount();
				operatores.push(sh.getOperator());
				lastIsOperation = false;
			}
			else if(operation == BRACKETS_CLOSE){
				if (lastIsOperation)throw new BadSintaxException("Operador " + operations.peek() + " no tiene sentancia a la derecha, choca con \")\"" );
				operatores.push(subEvaluation(operatores, operations));
				return new SyntaxHelper(count+1, operatores.pop());
			}
			else if(fabric.isValidToken(operation)){
				sh = bufferNum(count, expression);
				count = sh.getCount();
				operatores.push(sh.operator);
				lastIsOperation = false;
			}
			else throw new BadSintaxException("item no conocido: " + operation);
		}
		if (!operations.isEmpty())operatores.push(subEvaluation(operatores, operations));
		return new SyntaxHelper(count, operatores.pop());
	}


	private SyntaxHelper bufferNum(int count, String expression){
		String tmp;
		char datoLeido;
		int num = 0;
		for(;count < expression.length(); count++){
			datoLeido = expression.charAt(count);
			tmp = String.format("%s",datoLeido);
			if (numbers.contains(tmp)){
				num *= 10;
				num += new Integer(tmp);
			}
			else{break;}
		}
		SyntaxHelper sintaxhelper  = new SyntaxHelper(count, fabric.createSimpleOperator(num));
		return sintaxhelper;
	}

	
	
	private boolean isValidOperation(char operation){
		String tmp = String.format("%s",operation);
		return alloperation.contains(tmp);

	}
	
	private ArithmeticalOperator subEvaluation(Stack<ArithmeticalOperator> operatores, Stack<Character> operations){
		if(!operations.isEmpty()){
			while(!operations.isEmpty()){
				operatores.push(fabric.createOperator(operations.pop(), operatores.pop(), operatores.pop()));
			}
		}
		return operatores.pop();
	}
	
	
	/*
	 * Opera las colas hasta que la operacion sea mayor o igual
	 */
	private void operateLower(Stack<ArithmeticalOperator> operatores, Stack<Character> operations, char operation){
		while(!operations.isEmpty() && fabric.compare(operations.peek(),operation)){
			operatores.push(fabric.createOperator(operations.pop(), operatores.pop(), operatores.pop()));
		}
	}
	
	
	public int resolve(){
		return head.resolve().getValue();
	}
	public static void main(String[] args) {
		SyntaxArithmeticReader sar = new SyntaxArithmeticReader("-25+5(5*5)+25");
		System.out.println(sar.resolve());
	}
}
