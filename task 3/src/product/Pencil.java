package product;

import part.*;

public class Pencil implements IProduct {

	public IProductPart firstPart;
	public IProductPart secondPart;
	public IProductPart thirdPart;

	@Override
	public void installFirstPart(IProductPart p) {
		firstPart = p;
		System.out.println("first part installed");
	}

	@Override
	public void installSecondPart(IProductPart p) {
		secondPart = p;
		System.out.println("second part installed");
	}

	@Override
	public void installThirdPart(IProductPart p) {
		thirdPart = p;
		System.out.println("third part installed");
	}
}
