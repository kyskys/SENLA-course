package assembly_line;

import linestep.ILineStep;
import product.IProduct;

public class PencilAssemblyLine implements IAssemblyLine{
	ILineStep first;
	ILineStep second;
	ILineStep third;
	
	public PencilAssemblyLine(ILineStep first, ILineStep second, ILineStep third) {
		this.first=first;
		this.second=second;
		this.third=third;
	}
	@Override
	public IProduct assembleProduct(IProduct p) {
		p.installFirstPart(first.buildProductPart());
		p.installSecondPart(second.buildProductPart());
		p.installThirdPart(third.buildProductPart());
		System.out.println("assembling finished");
		return p;
	}

}
