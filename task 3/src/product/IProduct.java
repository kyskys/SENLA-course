package product;

import part.IProductPart;

public interface IProduct {
	
	public void installFirstPart(IProductPart p);

	public void installSecondPart(IProductPart p);

	public void installThirdPart(IProductPart p);
}
