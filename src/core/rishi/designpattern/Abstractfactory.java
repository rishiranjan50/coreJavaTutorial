package core.rishi.designpattern;
/*
 * factory of factory
 * 
 */
public class Abstractfactory {

	public static void main(String[] args) {
		//BusFactory factory = new Bus
	}
}

interface VechicleFactory{
	public VechicleFactory getFactory();
}
 
class CarFactory implements VechicleFactory{

	@Override
	public VechicleFactory getFactory() {
		// TODO Auto-generated method stub
		return new CarFactory();
	}
}

class BusFactory implements VechicleFactory{

	@Override
	public VechicleFactory getFactory() {
		// TODO Auto-generated method stub
		return new BusFactory();
	}
	
}