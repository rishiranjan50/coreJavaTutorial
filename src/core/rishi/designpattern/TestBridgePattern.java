package core.rishi.designpattern;


public class TestBridgePattern {

	public static void main(String[] args) {
		IMedeaResources resources = new Artist();
		Views longview = new LongView(resources);
		longview.printView();
	}
}

abstract class Views{
	IMedeaResources resources;
	public  Views(IMedeaResources resources){
		this.resources=resources;
	}
	
	public abstract void printView();
}

class LongView extends Views{

	public  LongView(IMedeaResources resource){
		super(resource);
	}
	@Override
	public void printView() {
		// TODO Auto-generated method stub
		resources.show();
		System.out.println("Inside long view");
	}
	
}

interface IMedeaResources{
	public void show();
}

class Artist implements IMedeaResources{
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Inside artist");
	}
	
}