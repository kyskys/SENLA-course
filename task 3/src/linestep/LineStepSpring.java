package linestep;

import part.Spring;

public class LineStepSpring implements ILineStep {

	@Override
	public Spring buildProductPart() {
		System.out.println("building spring");
		return new Spring();
	}

}
