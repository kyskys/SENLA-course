package assembly_line;

import linestep.LineStepCore;
import linestep.LineStepShell;
import linestep.LineStepSpring;
import product.IProduct;

public class PencilAssemblyLine implements IAssemblyLine{

	@Override
	public IProduct assembleProduct(IProduct p) {
		LineStepCore lsc = new LineStepCore();
		LineStepShell lssh = new LineStepShell();
		LineStepSpring lssp = new LineStepSpring();
		p.installFirstPart(lsc.buildProductPart());
		p.installSecondPart(lssh.buildProductPart());
		p.installThirdPart(lssp.buildProductPart());
		System.out.println("assembling finished");
		return p;
	}

}
