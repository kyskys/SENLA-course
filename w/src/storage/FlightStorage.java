package storage;

import entity.Flight;

public class FlightStorage extends AStorage {
	
	public FlightStorage(int num) {
		super(num);
	}

	public void show() {
		for(int i=0;i<entities.length;i++) {
			if(entities[i]!=null) {
				Flight f = (Flight) entities[i];
				System.out.println(f.getName()+" "+f.isCancelled()+" "+ f.isLate()+" "+f.getMaxSits());
			}
		}
	}

}
