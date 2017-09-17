package linestep;

import part.Shell;

public class LineStepShell implements ILineStep {

	@Override
	public Shell buildProductPart() {
		System.out.println("building shell");
		return new Shell();
	}

}
