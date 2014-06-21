package operationtree;



/**
 *
 * @author Crisrivlop
 */

interface ArithmeticalOperator extends Operator{

	@Override
	public abstract SimpleArithmeticalOperator resolve();
	
}


class SimpleArithmeticalOperator extends SimpleOperator implements ArithmeticalOperator{
    private int dato;
    
    public SimpleArithmeticalOperator resolve() {
        return this;
    }
    
    public SimpleArithmeticalOperator(int pdato){
        dato = pdato;
    }
    public int getValue(){return dato;}
    public void setValue(int pdato){dato = pdato;}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(dato);
	}
}

class OperatorDivide implements ArithmeticalOperator{
	private ArithmeticalOperator a,b;
	private final static int priority = 2;


	public OperatorDivide(ArithmeticalOperator first, ArithmeticalOperator second) {
		this.a = first;
		this.b = second;
	}


	@Override
	public SimpleArithmeticalOperator resolve() {
		int solution = b.resolve().getValue();
		if (solution != 0){
			return new SimpleArithmeticalOperator(a.resolve().getValue() / b.resolve().getValue());
		}
		throw new ArithmeticException("Expresion matematica invalida: division por cero");
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
}


class OperatorMultiply implements ArithmeticalOperator{
    private ArithmeticalOperator a,b;
    private final static int priority = 2;
    
    public OperatorMultiply(ArithmeticalOperator first, ArithmeticalOperator second) {
        this.a = first;
        this.b = second;
    }
    
    
    @Override
    public SimpleArithmeticalOperator resolve() {
        return new SimpleArithmeticalOperator(a.resolve().getValue() * b.resolve().getValue());
    }


	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
}

class OperatorMinus implements ArithmeticalOperator{
    private ArithmeticalOperator a,b;
    private final static int priority = 1;
    
    public OperatorMinus(ArithmeticalOperator first, ArithmeticalOperator second) {
        this.a = first;
        this.b = second;
    }
    
    @Override
    public SimpleArithmeticalOperator resolve() {
        return new SimpleArithmeticalOperator(a.resolve().getValue() - b.resolve().getValue());
    }
    public String toString(){
    	return a.resolve().getValue() + " - " + b.resolve().getValue();
    }

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
}


class OperatorPlus implements ArithmeticalOperator{
    private ArithmeticalOperator a,b;
    private final static int priority = 1;
    public OperatorPlus(ArithmeticalOperator first, ArithmeticalOperator second) {
        this.a = first;
        this.b = second;
    }
    
    @Override
    public SimpleArithmeticalOperator resolve() {
        return new SimpleArithmeticalOperator(a.resolve().getValue() + b.resolve().getValue());
    }

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a.toString() + " + " + b.toString();
	}
    
}

class OperatorPower implements ArithmeticalOperator{
	private final static int priority = 3;
	private ArithmeticalOperator a,b;
	public OperatorPower(ArithmeticalOperator base, ArithmeticalOperator exponent) {
		// TODO Auto-generated constructor stub
		a = base;
		b = exponent;
	}
	@Override
	public SimpleArithmeticalOperator resolve() {
		// TODO Auto-generated method stub
		return new SimpleArithmeticalOperator((int)Math.pow(a.resolve().getValue(), b.resolve().getValue()));
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}

}


class OperatorRoot implements ArithmeticalOperator {
	private final static int priority = 3;
	private ArithmeticalOperator a,b;
	public OperatorRoot(ArithmeticalOperator rootIndex, ArithmeticalOperator base) {
		b = rootIndex;
		a = base;
	}
	@Override
	public SimpleArithmeticalOperator resolve() {
		// TODO Auto-generated method stub
		int solution = a.resolve().getValue();
		if (solution > 0){
			double a = (double)1/(double)b.resolve().getValue();

			return new SimpleArithmeticalOperator((int)Math.pow(solution, a));
		}
		throw new ArithmeticException("Expresion matematica invalida: Base de raiz menor a cero");
		
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}


}


public class ArithmeticalOperatorFabric implements FabricOperator{
    public ArithmeticalOperator createOperator(char operation, ArithmeticalOperator right, ArithmeticalOperator left){
        ArithmeticalOperator operator = null;
        switch (operation) {
		case SyntaxArithmeticReader.PLUS:
			operator = new OperatorPlus(left,right);
			break;
		case SyntaxArithmeticReader.MINUS:
			operator = new OperatorMinus(left,right);
			break;
		case SyntaxArithmeticReader.MULTIPLY:
			operator = new OperatorMultiply(left,right);
			break;
		case SyntaxArithmeticReader.DIVIDE:
			operator = new OperatorDivide(left,right);
			break;
		case SyntaxArithmeticReader.EXPONENT:
			operator = new OperatorPower(left, right);
			break;
		case SyntaxArithmeticReader.ROOT:
			operator = new OperatorRoot(left, right);
			break;
		default:
			break;
		}
        if (operator == null){
        	throw  new BadSintaxException("Error: no se conoce el caracter \"" + operation + "\"");
        }
        return operator;
        
    }
    
    public SimpleArithmeticalOperator createSimpleOperator(int pdato){
        return new SimpleArithmeticalOperator(pdato);
    }
	@Override
	public boolean isValidToken(char number){
		return number == '0' | number == '1' | number == '2' | number == '3' | number == '4' | number == '5' | number == '6' | number == '7' | number == '8' | number == '9';
	}
	@Override
	public boolean compare(char oper1, char oper2){
		Operator operator1 = this.createOperator(oper1, null, null);
		Operator operator2 = this.createOperator(oper2, null, null);
		return operator1.getPriority() > operator2.getPriority(); 
	}
}
