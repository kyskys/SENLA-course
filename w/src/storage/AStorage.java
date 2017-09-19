package storage;

import entity.AEntity;

public abstract class AStorage {
	AEntity[] entities;

	public AStorage(int num) {
		entities = new AEntity[num];
	}
	public void add(AEntity e) {
		entities[searchEmpty()]=e;
	}

	public void remove(AEntity e){
		entities[searchEntity(e)]=null;
	}
	
	public int searchEmpty(){
		for(int i=0;i<entities.length;i++) {
			if(entities[i]==null) {
				return i;
			}
		}
		return -1;
	}
	public int searchEntity(AEntity e) {
		for(int i=0;i<entities.length;i++) {
			if(entities[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
}
