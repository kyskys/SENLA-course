package linestep;

import part.Core;

public class LineStepCore implements ILineStep {

	@Override
	public Core buildProductPart() {
		System.out.println("building core");
		return new Core();
	}

}
