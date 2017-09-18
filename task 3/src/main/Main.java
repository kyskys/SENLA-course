package main;

import assembly_line.PencilAssemblyLine;
import linestep.*;
import product.Pencil;

public class Main {

	public static void main(String[] args) {
		Pencil pen = new Pencil();
		PencilAssemblyLine line = new PencilAssemblyLine(new LineStepCore(), new LineStepShell(), new LineStepSpring());
		line.assembleProduct(pen);
	}

}
