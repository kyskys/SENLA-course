package main;

import assembly_line.PencilAssemblyLine;
import product.Pencil;

public class Main {

	public static void main(String[] args) {
		Pencil pen = new Pencil();
		PencilAssemblyLine line = new PencilAssemblyLine();
		line.assembleProduct(pen);
	}

}
